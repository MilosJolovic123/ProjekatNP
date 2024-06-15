package rs.ac.bg.fon.ai.naprednoProgramiranje.newsletter;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.UserDetailService.JpaUserDetailsService;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.UserRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service layer that handles all business logic with Newsletter class.
 */
@Service
public class NewsletterService {
    /**
     * Autowired field reference to the User repo.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Autowired field reference to the Newsletter repo.
     */
    @Autowired
    private NewsletterRepository newsletterRepository;

    /**
     * Method for saving a specific Newsletter passed through method parameter into H2 db.
     * @param loggedUser currently logged user
     * @param newsletter to be saved
     * @return saved newsletter
     * @throws RuntimeException if user is not to be found in db.
     * @throws IllegalArgumentException if date is after now.
     */
    public Newsletter save(UserDetails loggedUser, Newsletter newsletter) {

        String username = loggedUser.getUsername();

        Optional<AppUser> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }
        if(newsletter.getNewsletter_date().toLocalDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Date can't be after current date!");
        newsletter.setNewsletter_user(user.get());
        return newsletterRepository.save(newsletter);
    }

    /**
     * Method that finds specific Newsletter.
     * @param id of a specific Newsletter.
     * @return found Newsletter
     * @throws RuntimeException if newsletter is not to be found.
     */
    public Optional<Newsletter> findOne(Long id) {
        Optional<Newsletter> newsletter = newsletterRepository.findById(id);
        if(newsletter.isEmpty())
            throw new RuntimeException("Newsletter not found!");
       return newsletter;
    }

    /**
     * Returns all newsletters from H2 db.
     * @return all newsletters from H2 db.
     */
    public List<Newsletter> findAll(){
        return newsletterRepository.findAll();
    }
}
