package rs.ac.bg.fon.ai.naprednoProgramiranje.director;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;

import javax.validation.constraints.Size;
import java.util.Set;

/**
 *  * Director domain class that encapsulates the usage of Directors of  Films for the platform.
 *  * It is mapped out in a table Director in H2 in-memory database.
 * @author jolovic
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director {
    /**
     * Generated value - unique identifier of Director class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirector;
    /**
     * Name of a Director represented as a String value.
     */
    @NonNull
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    /**
     * Lastname of a Director represented as a String value.
     */
    @NonNull
    @Size(min = 3, max = 20, message = "Lastname must be between 3 and 20 characters")
    private String lastName;
    /**
     * Number of Oscars that Director gained throughout his career, as an Integer value.
     */

    private int noOfOscars;
    /**
     * Set of Films that Director directed, reference to Film H2 database table.
     */
    @OneToMany(mappedBy = "film_director")
    private Set<Film> filmSet;


}
