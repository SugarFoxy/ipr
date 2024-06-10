package perf.ipr.ui.core;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static perf.ipr.ui.core.BrowserConfig.configure;

public class BaseUITest {
    @BeforeEach
    public void init(){
        configure();
        Selenide.open("/");
    }
    @AfterEach
    public void close(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
