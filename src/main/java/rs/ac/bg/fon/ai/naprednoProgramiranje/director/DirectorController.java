package rs.ac.bg.fon.ai.naprednoProgramiranje.director;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author jolovic
 * Rest Controller ensuring our POST endpoint for saving directors in H2 database.
 */
@RestController
public class DirectorController {
    /**
     * Private field that ensures reference to Service class which is business logic for
     * saving Directors in H2 db.
     */
    private final DirectorRepository directorRepository;

    /**
     * Constructor injection of @DirectorRepository class.
     * @param directorRepository reference to the @DirectorClass.
     */
    @Autowired
    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    /**
     * * A HTTP POST method that ensures adding a director passed through JSON request body in H2 db.
     *
     * @param director to be persisted in H2 db.
     * @return director we are persisting.
     * @throws IllegalArgumentException for NO. of Oscars less than 0.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/directors/save")
    public Director addDirector(@RequestBody Director director){
        if(director.getNoOfOscars()<0)
            throw new IllegalArgumentException("NO. of Oscars must be greater or equal to 0.");
        return directorRepository.save(director);
    }
}
