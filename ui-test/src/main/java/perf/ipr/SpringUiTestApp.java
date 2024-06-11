package perf.ipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfiguration.class)
public class SpringUiTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringUiTestApp.class, args);
    }

}