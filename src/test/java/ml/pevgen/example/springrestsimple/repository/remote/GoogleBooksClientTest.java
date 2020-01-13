package ml.pevgen.example.springrestsimple.repository.remote;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class GoogleBooksClientTest {

    @Autowired
    GoogleBooksClient googleBooksClient;

    @Test
    void findBookByISBN() {
        Results res = googleBooksClient.findBookByQuery("isbn:9780321356680");
        Assertions.assertThat(res).isNotNull();
    }
}