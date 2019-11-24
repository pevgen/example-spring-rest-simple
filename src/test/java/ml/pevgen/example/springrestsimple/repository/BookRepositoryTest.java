package ml.pevgen.example.springrestsimple.repository;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Ignore
@Testcontainers
class BookRepositoryTest {
    @Container
    private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer();

    @Test
    void someTestMethod() {
        String url = MY_SQL_CONTAINER.getJdbcUrl();

        // create a connection and run test as normal
        Assert.fail("url:" + url);
    }
}