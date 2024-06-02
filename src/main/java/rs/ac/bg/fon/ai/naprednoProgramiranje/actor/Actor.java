package rs.ac.bg.fon.ai.naprednoProgramiranje.actor;

import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.role.Role;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idActor;
    private String name;
    private String lastName;
    private int noOfOscars;
    @OneToMany(mappedBy = "idRole")
    private Set<Role> filmSet;


}
