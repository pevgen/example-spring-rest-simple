package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
