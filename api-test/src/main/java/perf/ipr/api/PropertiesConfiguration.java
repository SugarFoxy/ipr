package perf.ipr.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "config.api")
public class PropertiesConfiguration {
    private String apiServerUrl;
}
