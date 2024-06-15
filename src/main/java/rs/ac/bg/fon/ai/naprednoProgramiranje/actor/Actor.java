package rs.ac.bg.fon.ai.naprednoProgramiranje.actor;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.role.Role;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author jolovic
 * Actor domain class that encapsulates the usage of Actors in Films for the platform.
 * It is mapped out in a table Actor in H2 in-memory database.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Actor {
    /**
     * Unique genrated identification value for Actor objects both in API and db usage.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idActor;
    /**
     * Name of an Actor represented like a String value.
     */
    @NonNull
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    /**
     * Lastname of an Actor represented like a String value.
     */
    @NonNull
    @Size(min = 3, max = 20, message = "Lastname must be between 3 and 20 characters")
    private String lastName;

    /**
     * Number of Oscar awards that Actor gained as an Integer.
     */

    private int noOfOscars;
    /**
     * Role set that represents a connection to films in which actor had Roles.
     */
    @OneToMany(mappedBy = "idRole")
    private Set<Role> filmSet;
}



