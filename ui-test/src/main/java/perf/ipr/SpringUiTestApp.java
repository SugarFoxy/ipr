package perf.ipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ContextConfiguration()
public class MySpringTestFrameworkApp {

    public static void main(String[] args) {
        SpringApplication.run(MySpringTestFrameworkApp.class, args);
    }

}