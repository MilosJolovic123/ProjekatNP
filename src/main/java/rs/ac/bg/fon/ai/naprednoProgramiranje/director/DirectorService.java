package rs.ac.bg.fon.ai.naprednoProgramiranje.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;


    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

}
