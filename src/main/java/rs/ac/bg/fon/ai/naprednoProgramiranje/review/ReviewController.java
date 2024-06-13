package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    //takodje mogu da vide svi na requested ID
    @PreAuthorize("hasRole('ADMIN')||hasRole('USER')")
    @GetMapping("/reviews/{requestedId}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable Long requestedId){
        return ResponseEntity.ok(reviewService.getReview(requestedId));
    }
    //mogu svi da vide sve review - e
    @PreAuthorize("hasRole('ADMIN')||hasRole('USER')")
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviews(){
        return ResponseEntity.ok(reviewService.getReviews());
    }
    //moze da doda i user i admin
    @PreAuthorize("hasRole('ADMIN')||hasRole('USER')")
    @PostMapping("/reviews/add/{filmId}")
    public ResponseEntity<Review> addReview(@RequestBody Review review, @PathVariable Long filmId, @AuthenticationPrincipal UserDetails loggedUser){
        return ResponseEntity.ok(reviewService.saveReview(review,filmId,loggedUser));
    }
    //moze da izmeni samo user koji je napravio review!
    @PostAuthorize("returnObject.user.username == authentication.name")
    @PutMapping("/reviews/update/{requestedId}")
    public Review updateReview(@RequestBody Review review,@PathVariable Long requestedId){
        return reviewService.updateReview(review,requestedId);
    }
    //moze da obrise admin ili user koji je dodao!


    @PostAuthorize("hasRole('ADMIN')||returnObject.user.username == authentication.name")
    @DeleteMapping("/reviews/delete/{requestedId}")
    public Review deleteReview(@PathVariable Long requestedId){
        return reviewService.DeleteReview(requestedId);
    }
}
