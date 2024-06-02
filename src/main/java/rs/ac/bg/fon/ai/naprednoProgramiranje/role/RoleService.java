package rs.ac.bg.fon.ai.naprednoProgramiranje.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.Actor;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.ActorRepository;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.FilmRepository;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActorRepository actorRepository;

    public Role saveRole(Role role, Long filmId, Long actorId){

        Optional<Film> film = filmRepository.findById(filmId);
        Optional<Actor> actor = actorRepository.findById(actorId);

        role.setFilm(film.get());
        role.setActor(actor.get());

        return roleRepository.save(role);
    }

}
