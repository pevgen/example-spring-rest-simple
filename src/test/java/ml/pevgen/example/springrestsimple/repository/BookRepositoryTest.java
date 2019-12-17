package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles({"test"})
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findById() {
        assertThat(bookRepository).isNotNull();
        Optional<Book> result = bookRepository.findById(1L);
        assertThat(result).isEmpty();
    }
}