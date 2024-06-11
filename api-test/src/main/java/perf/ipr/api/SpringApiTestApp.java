package perf.ipr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfiguration.class)
public class SpringApiTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiTestApp.class, args);
    }

}