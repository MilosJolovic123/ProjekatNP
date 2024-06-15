package rs.ac.bg.fon.ai.naprednoProgramiranje.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import rs.ac.bg.fon.ai.naprednoProgramiranje.film.Film;
import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;

import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Review domain class that is a review of single user on a single film.
 * Directly mapped out in Review table in H2 db.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    /**
     * Unique generated value that is identifier for Review class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;
    /**
     * Comment on the review given as a String representation.
     */
    @NonNull
    @Size(min = 5, max = 100, message = "Comment must be between 5 and 100 chars long!")
    private String comment;
    /**
     * Grade given to a Film on a Review, between 5 and 10 stars.
     */
    private int grade;
    /**
     * Date of the review.
     */
    @NonNull
    private Date dateGiven;
    /**
     * To which film is the review given, direct reference to the Film table in H2 db.
     */
    @ManyToOne
    @JoinColumn(name="idFilm")
    @JsonIgnore
    private Film film;
    /**
     *  To which user is the review given, direct reference to the User table in H2 db.
     */
    @ManyToOne
    @JoinColumn(name="id_user")
    @JsonIgnore
    private AppUser user;


}
