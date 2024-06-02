package rs.ac.bg.fon.ai.naprednoProgramiranje.user;

import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.ai.naprednoProgramiranje.newsletter.Newsletter;
import rs.ac.bg.fon.ai.naprednoProgramiranje.review.Review;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "AppUser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String NameAndLastName;
    private String username;
    private String password;
    @OneToMany(mappedBy = "newsletter_user")
    private Set<Newsletter> newsletterSet;
    @OneToMany(mappedBy = "idReview")
    private Set<Review> reviews;
}
