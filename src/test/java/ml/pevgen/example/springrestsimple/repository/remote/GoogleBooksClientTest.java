package ml.pevgen.example.springrestsimple.repository.remote;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootTest(classes = GoogleBooksClient.class)
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class})
class GoogleBooksClientTest {

    @Autowired
    GoogleBooksClient googleBooksClient;

    @Test
    void findBookByQuery_byISBN_ok() {
        Results res = googleBooksClient.findBookByQuery("isbn:9780321356680");
        Assertions.assertThat(res).isNotNull();
        Assertions.assertThat(res.getTotalItems()).isEqualTo(1);
    }

    @Test
    void findBookByQuery_byISBN_bookNotFound() {
        Results res = googleBooksClient.findBookByQuery("isbn:0101001010100");
        Assertions.assertThat(res).isNotNull();
        Assertions.assertThat(res.getTotalItems()).isEqualTo(0);
    }

}