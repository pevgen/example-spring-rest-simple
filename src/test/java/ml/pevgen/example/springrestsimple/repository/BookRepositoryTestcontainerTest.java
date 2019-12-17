package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.domain.Book;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("testcontainers")
public class BookRepositoryTestcontainerTest {

    @ClassRule
    public static MySQLContainer MY_SQL_CONTAINER = new MySQLContainer()
            .withDatabaseName("testDb")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void before() {
        assertThat(bookRepository).isNotNull();
        Book book = new Book();
        book.setIsbn("isbn-123");
        book.setTitle("title-123");
        bookRepository.save(book);
    }

    @Test
    public void findById() {
        List<Book> bookList = bookRepository.findAll();
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isEqualTo(1);
        assertThat(bookList.get(0)).isNotNull();
        assertThat(bookList.get(0).getId()).isEqualTo(1L);
        assertThat(bookList.get(0).getIsbn()).isEqualTo("isbn-123");
        assertThat(bookList.get(0).getTitle()).isEqualTo("title-123");
    }

}
