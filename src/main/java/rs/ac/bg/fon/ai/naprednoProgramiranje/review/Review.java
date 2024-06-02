package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.actor.Actor;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;

import java.sql.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;
    private String comment;
    private int grade;
    private Date dateGiven;
    @ManyToOne
    @JoinColumn(name="idFilm")
    @JsonIgnore
    private Film film;
    @ManyToOne
    @JoinColumn(name="id_user")
    @JsonIgnore
    private AppUser user;


}
