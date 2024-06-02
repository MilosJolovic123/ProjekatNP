package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review/{requestedId}")
    public ResponseEntity<Review> getReview(@PathVariable Long requestedId){
        return ResponseEntity.ok(reviewService.getReview(requestedId));
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(){
        return ResponseEntity.ok(reviewService.getReviews());
    }
    @PostMapping("/reviews/add/{filmId}/{userId}")
    public ResponseEntity<Review> addReview(@RequestBody Review review,@PathVariable Long filmId,@PathVariable Long userId){
        return ResponseEntity.ok(reviewService.saveReview(review,filmId,userId));
    }
}
