package ml.pevgen.example.springrestsimple;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SpringRestSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestSimpleApplication.class, args);
    }

    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
