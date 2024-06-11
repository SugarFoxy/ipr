package perf.ipr;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "config.ui")
public class PropertiesConfiguration {
    private String url;
}
