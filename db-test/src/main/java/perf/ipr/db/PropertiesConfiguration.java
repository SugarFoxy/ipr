package perf.ipr.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "config.db")
public class PropertiesConfiguration {
    private String dbHost;
    private String dbName;
    private String dbPort;
    private String dbUser;
    private String dbPassword;
}
