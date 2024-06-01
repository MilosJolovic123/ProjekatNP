package rs.ac.bg.fon.ai.naprednoProgramiranje.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.naprednoProgramiranje.director.Director;
import rs.ac.bg.fon.ai.naprednoProgramiranje.director.DirectorRepository;
import rs.ac.bg.fon.ai.naprednoProgramiranje.genre.Genre;
import rs.ac.bg.fon.ai.naprednoProgramiranje.genre.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private GenreRepository genreRepository;

    public List<Film> getFilmList() {
        return filmRepository.findAll();
    }
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).get();
    }
    public Film saveFilm(Film film,Long requestedDirector, Long requestedGenre) {

        Optional<Director> directorOptional = directorRepository.findById(requestedDirector);
        Optional<Genre> genreOptional = genreRepository.findById(requestedGenre);


        film.setFilm_director(directorOptional.get());
        film.setFilm_genre(genreOptional.get());

        return filmRepository.save(film);
    }



}