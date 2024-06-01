package rs.ac.bg.fon.ai.naprednoProgramiranje.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("director/save")
    private ResponseEntity<Director> addDirector(@RequestBody Director director) {
       return ResponseEntity.ok(directorService.saveDirector(director));
    }

}
