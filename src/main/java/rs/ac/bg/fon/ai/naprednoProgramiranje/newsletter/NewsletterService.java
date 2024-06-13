package rs.ac.bg.fon.ai.naprednoProgramiranje.newsletter;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.UserDetailService.JpaUserDetailsService;
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


    public Newsletter save(UserDetails loggedUser, Newsletter newsletter) {

        String username = loggedUser.getUsername();

        Optional<AppUser> user = userRepository.findByUsername(username);
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
