package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
