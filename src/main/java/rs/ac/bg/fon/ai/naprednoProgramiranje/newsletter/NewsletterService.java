package rs.ac.bg.fon.ai.naprednoProgramiranje.newsletter;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsletterRepository newsletterRepository;

    public Newsletter save(Newsletter newsletter,Long userId) {
        Optional<AppUser> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }
        newsletter.setNewsletter_user(user.get());
        return newsletterRepository.save(newsletter);
    }

    public Optional<Newsletter> findOne(Long id) {
       return newsletterRepository.findById(id);
    }

    public List<Newsletter> findAll(){
        return newsletterRepository.findAll();
    }
}
