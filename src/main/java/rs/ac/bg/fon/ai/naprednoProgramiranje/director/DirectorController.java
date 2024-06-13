package rs.ac.bg.fon.ai.naprednoProgramiranje.director;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/directors/save")
    public Director addDirector(@RequestBody Director director){
        return directorRepository.save(director);
    }
}
