package rs.ac.bg.fon.ai.naprednoProgramiranje.film;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import rs.ac.bg.fon.ai.naprednoProgramiranje.genre.Genre;
import rs.ac.bg.fon.ai.naprednoProgramiranje.director.Director;
import rs.ac.bg.fon.ai.naprednoProgramiranje.review.Review;
import rs.ac.bg.fon.ai.naprednoProgramiranje.role.Role;

import jakarta.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;
/**
 *  * Film domain class that encapsulates the usage of Films for the platform.
 *  * It is mapped out in a table Film in H2 in-memory database.
 * @author jolovic
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Film {
    /**
     * Generated value - unique identifier of Film class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;
    /**
     * Date film was released.
     */
    private Date dateReleased;
    /**
     * Title of the Film represented as a String value.
     */
    @NonNull
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    /**
     *  Description of the Film represented as a String value.
     */
    @NonNull
    @Size(min = 10, max = 500, message = "Description must be between 0 and 500 characters")
    private String description;
    /**
     * Film land of origin represented as a String value.
     */
    @NonNull
    @Size(min = 5, max = 50, message = "Land of origin must be between 5 and 50 characters")
    private String landOfOrigin;
    /**
     * Reference to the film Director.
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idDirector")
    private Director film_director;
    /**
     * Reference to the film genre.
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="idGenre")
    private Genre film_genre;
    /**
     * Reference to roles of actors in a film.
     */
    @OneToMany(mappedBy = "idRole")
    private Set<Role> roleSet;
    /**
     * Reference to the reviews of the films.
     */
    @OneToMany(mappedBy = "idReview")
    private Set<Review> reviews;

}
