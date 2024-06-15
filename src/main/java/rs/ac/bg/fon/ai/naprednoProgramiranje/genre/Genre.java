package rs.ac.bg.fon.ai.naprednoProgramiranje.genre;

import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;

import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Domain class of Genre to be associated to Film. Mapped out into Genre table in H2 db.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    /**
     * Unique generated value of Genre class.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idGenre;
    /**
     * Description of a film genre represented as a String.
     */
    @NonNull
    @Size(min = 5, max = 500, message = "Genre description that must be between 5 and 500 chars long.")
    private String genreDesctiption;
    /**
     * Film set that contains the given genre, reference to the table Film in H2 db.
     */
    @OneToMany(mappedBy = "film_genre")
    private Set<Film> filmSet;


}
