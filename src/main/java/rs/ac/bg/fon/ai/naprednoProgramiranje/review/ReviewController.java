package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/{requestedId}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable Long requestedId){
        return ResponseEntity.ok(reviewService.getReview(requestedId));
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviews(){
        return ResponseEntity.ok(reviewService.getReviews());
    }
    @PostMapping("/reviews/add/{filmId}/{userId}")
    public ResponseEntity<Review> addReview(@RequestBody Review review,@PathVariable Long filmId,@PathVariable Long userId){
        return ResponseEntity.ok(reviewService.saveReview(review,filmId,userId));
    }
    @PutMapping("/reviews/update/{requestedId}/{filmId}/{userId}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review,@PathVariable Long requestedId,@PathVariable Long filmId,@PathVariable Long userId){
        return ResponseEntity.ok(reviewService.updateReview(review,requestedId,userId,filmId));
    }
    @DeleteMapping("/reviews/delete/{requestedId}")
    public ResponseEntity<Integer> deleteReview(@PathVariable Long requestedId){
        reviewService.DeleteReview(requestedId);
        return ResponseEntity.ok(200);
    }
}
