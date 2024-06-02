package rs.ac.bg.fon.ai.naprednoProgramiranje.role;

import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.Actor;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;
    private String description;
    @ManyToOne
    @JoinColumn(name="idActor")
    private Actor actor;
    @ManyToOne
    @JoinColumn(name="idFilm")
    private Film film;

}
