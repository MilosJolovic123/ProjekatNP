package rs.ac.bg.fon.ai.naprednoProgramiranje.film;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.genre.Genre;
import rs.ac.bg.fon.ai.naprednoProgramiranje.director.Director;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;
    private Date dateReleased;
    private String title;
    private String description;
    private String landOfOrigin;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idDirector")
    private Director film_director;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="idGenre")
    private Genre film_genre;
}