package rs.ac.bg.fon.ai.naprednoProgramiranje.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repo that extends JpaRepository and ensures all CRUD ops for AppUser.
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    /**
     * Method for retrieval of a User.
     * @param username of a user to be retrieved.
     * @return User retrieved.
     */
    Optional<AppUser> findByUsername(String username);

}
