package perf.ipr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ContextConfiguration()
public class SpringApiTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiTestApp.class, args);
    }

}