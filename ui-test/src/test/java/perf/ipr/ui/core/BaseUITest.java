package perf.ipr.ui.core;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import perf.ipr.PropertiesConfiguration;

import static perf.ipr.ui.core.BrowserConfig.configure;


public abstract class BaseUITest {

    @Autowired
    PropertiesConfiguration configuration;

    @BeforeEach
    public void init(){
        configure(configuration);
        Selenide.open("/");
    }
    @AfterEach
    public void close(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
