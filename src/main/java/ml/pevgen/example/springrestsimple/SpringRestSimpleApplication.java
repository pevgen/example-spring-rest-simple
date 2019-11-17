package ml.pevgen.example.springrestsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SpringRestSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestSimpleApplication.class, args);
    }

}
