package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.FilmRepository;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service layer that handles all business logic operated on Review class.
 */
@Service
public class ReviewService {
    /**
     * Autowired field reference of review repo.
     */
    @Autowired
    private ReviewRepository reviewRepository;
    /**
     * Autowired field reference of user repo.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Autowired field reference of film repo.
     */
    @Autowired
    private FilmRepository filmRepository;

    /**
     * Method that gets the specific Review by given id.
     * @param requiredId of the Newsletter to be found and shown.
     * @return the specific Newsletter to be found and shown.
     */
    public ReviewDTO getReview(Long requiredId){
        Optional<Review >r= reviewRepository.findById(requiredId);
        if(r.isEmpty())
            throw new RuntimeException("Review is not to be found!");
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setComment(r.get().getComment());
        reviewDTO.setGrade(r.get().getGrade());
        return reviewDTO;
    }

    /**
     * Method that retrieves all Reviews on every film given by any user.
     * @return List of all reviews.
     */
    public List<ReviewDTO> getReviews(){

        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();

        for(Review r:reviews){
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setComment(r.getComment());
            reviewDTO.setGrade(r.getGrade());
            reviewDTOs.add(reviewDTO);
        }

        return reviewDTOs;
    }

    /**
     * Method for saving a review.
     * @param review to be saved.
     * @param filmId on which film.
     * @param loggedUser the currently logged user that gives the review.
     * @return the saved review.
     */
    public Review saveReview(Review review, Long filmId, UserDetails loggedUser){

        String username = loggedUser.getUsername();

        Optional<Film> filmOptional = filmRepository.findById(filmId);
        Optional<AppUser> userOptional = userRepository.findByUsername(username);

        if(filmOptional.isEmpty() || userOptional.isEmpty())
            throw new RuntimeException("Film or user is not found in H2!");

        review.setFilm(filmOptional.get());
        review.setUser(userOptional.get());

        if(review.getGrade()<5||review.getGrade()>10)
            throw new IllegalArgumentException("Film can't get a grade higher than 10 and less than 5.");

        review.setDateGiven(Date.valueOf(LocalDate.now()));


        return reviewRepository.save(review);
    }

    /**
     * Method that updates the review.
     * @param review that carries new info.
     * @param requestedId old review.
     * @throws RuntimeException if the provided Review does not exist.
     * @return newly updated review.
     */
    public Review updateReview(Review review, Long requestedId){
        Optional<Review> reviewOptional = reviewRepository.findById(requestedId);
        if(reviewOptional.isEmpty())
            throw new RuntimeException("Such review does not exist in H2!");

        reviewOptional.get().setComment(review.getComment());
        reviewOptional.get().setGrade(review.getGrade());
        reviewOptional.get().setDateGiven(review.getDateGiven());

        return reviewRepository.save(reviewOptional.get());

    }

    /**
     * Method for deleting a Review.
     * @param requestedId for deleting.
     * @throws RuntimeException if the provided Review does not exist.
     * @return deleted review.
     */
    public Review DeleteReview(Long requestedId){
        Optional<Review> review = reviewRepository.findById(requestedId);
        if(review.isEmpty())
            throw new RuntimeException("Such review does not exist in H2!");
         reviewRepository.deleteById(requestedId);
         return review.get();
    }

}




