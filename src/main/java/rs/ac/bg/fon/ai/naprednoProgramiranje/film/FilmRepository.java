package rs.ac.bg.fon.ai.naprednoProgramiranje.film;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class that extends @JpaRepository, ensures all CRUD ops with Film class.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
