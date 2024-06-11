package perf.ipr.ui.core;

import com.codeborne.selenide.Configuration;
import perf.ipr.PropertiesConfiguration;


public class BrowserConfig {
    public static void configure(PropertiesConfiguration configuration) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = configuration.getUrl();
        Configuration.timeout = 10000;
    }
}
