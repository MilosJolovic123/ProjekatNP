package rs.ac.bg.fon.ai.naprednoProgramiranje.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("film/{requestedId}")
    public ResponseEntity<Film> getFilm(@PathVariable("requestedId") Long requestedId) {
        return ResponseEntity.ok(filmService.getFilmById(requestedId));
    }

    @GetMapping("films")
    public ResponseEntity<List<Film>> getFilms() {
        return ResponseEntity.ok(filmService.getFilmList());
    }
    @PostMapping("film/save/{requestedDirector}/{requestedGenre}")
    public ResponseEntity<Film> saveFilm(@RequestBody Film film,@PathVariable Long requestedDirector,@PathVariable Long requestedGenre) {
        return ResponseEntity.ok(filmService.saveFilm(film,requestedDirector,requestedGenre));
    }
}
