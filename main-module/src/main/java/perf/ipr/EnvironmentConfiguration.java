package perf.ipr;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EnvironmentConfiguration {
    //TODO переменные среды
    String url = "http://localhost:9090";
}
//POSTGRES_DB=shareit;
// POSTGRES_USER=root;
// POSTGRES_PASSWORD=root;
// DB_HOST=localhost;
// DB_PORT=5434;
// DB_NAME=shareit;
// PORT_SERVER=9090
