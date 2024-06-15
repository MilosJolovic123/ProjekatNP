package rs.ac.bg.fon.ai.naprednoProgramiranje.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.Actor;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.ActorRepository;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.FilmRepository;

import java.util.Optional;

/**
 * Service layer class that handles all business logic on Role class.
 */
@Service
public class RoleService {
    /**
     * Autowired field that is a reference to Role repo.
     */
    @Autowired
    private RoleRepository roleRepository;
    /**
     * Autowired field that is a reference to Film repo.
     */
    @Autowired
    private FilmRepository filmRepository;
    /**
     * Autowired field that is a reference to Actor repo.
     */
    @Autowired
    private ActorRepository actorRepository;

    /**
     * Method for saving the Role.
     * @param role to be saved.
     * @param filmId to be saved onto.
     * @param actorId which acted that role.
     * @throws RuntimeException if provided film of actor does not exist in H2.
     * @return role saved.
     */
    public Role saveRole(Role role, Long filmId, Long actorId){

        Optional<Film> film = filmRepository.findById(filmId);
        Optional<Actor> actor = actorRepository.findById(actorId);
        if(film.isEmpty() || actor.isEmpty())
            throw new RuntimeException("Provided actor or film does not exist in H2.");
        role.setFilm(film.get());
        role.setActor(actor.get());

        return roleRepository.save(role);
    }

}
