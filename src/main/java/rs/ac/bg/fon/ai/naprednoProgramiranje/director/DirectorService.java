package rs.ac.bg.fon.ai.naprednoProgramiranje.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;


    public Director saveDirector(Director director) {
        if(director ==null)
            throw new NullPointerException("Director is null!");
        if(director.getNoOfOscars()<0)
            throw new IllegalArgumentException("Number of oscars for a director must be higher than 0!");
        return directorRepository.save(director);
    }



}
