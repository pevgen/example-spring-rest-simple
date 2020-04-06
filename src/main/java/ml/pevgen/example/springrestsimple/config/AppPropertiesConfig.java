package ml.pevgen.example.springrestsimple.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ml.pevgen.example.springrestsimple")
@Data
public class AppPropertiesConfig {

    private String simpleProperty = "defaultValue";

}
