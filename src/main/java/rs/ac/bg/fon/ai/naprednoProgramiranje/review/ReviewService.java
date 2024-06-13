package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.FilmRepository;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FilmRepository filmRepository;

    public ReviewDTO getReview(Long requiredId){
        Review r= reviewRepository.findById(requiredId).get();
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setComment(r.getComment());
        reviewDTO.setGrade(r.getGrade());
        return reviewDTO;
    }

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
    public Review saveReview(Review review,Long userId,Long filmId){

        Optional<Film> filmOptional = filmRepository.findById(filmId);
        Optional<AppUser> userOptional = userRepository.findById(userId);

        review.setFilm(filmOptional.get());
        review.setUser(userOptional.get());

        return reviewRepository.save(review);
    }
    public Review updateReview(Review review, Long requestedId,Long userId,Long filmId){
        Optional<Review> reviewOptional = reviewRepository.findById(requestedId);
        Optional<Film> filmOptional = filmRepository.findById(filmId);
        Optional<AppUser> userOptional = userRepository.findById(userId);

        //reviewOptional.get().setFilm(filmOptional.get());
        //reviewOptional.get().setUser(userOptional.get());
        reviewOptional.get().setComment(review.getComment());
        reviewOptional.get().setGrade(review.getGrade());
        reviewOptional.get().setDateGiven(review.getDateGiven());

        return reviewRepository.save(reviewOptional.get());

    }
    public Review DeleteReview(Long requestedId){
        Optional<Review> review = reviewRepository.findById(requestedId);
         reviewRepository.deleteById(requestedId);
         return review.get();
    }

}




