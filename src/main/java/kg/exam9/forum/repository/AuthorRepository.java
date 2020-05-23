package kg.exam9.forum.repository;

import kg.exam9.forum.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    boolean existsByEmail(String email);
    Optional<Author> findByEmail(String email);
}

