package rs.ac.bg.fon.ai.naprednoProgramiranje.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsletterController {
    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter/{requestedId}")
    public Optional<Newsletter> getNewsletter(@PathVariable Long requestedId) {
        return newsletterService.findOne(requestedId);
    }
    @GetMapping("/newsletters")
    public List<Newsletter> getAllNewsletters() {
        return newsletterService.findAll();
    }

    @PostMapping("/newsletter/add/{requestedId}")
    public ResponseEntity<Newsletter> save(@PathVariable(required = false) Long requestedId,@RequestBody Newsletter newsletter) {
        return ResponseEntity.ok(newsletterService.save(newsletter,requestedId));
    }

}
