package perf.ipr.ui.core;

import com.codeborne.selenide.Configuration;

public class BrowserConfig {
    public static void configure() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.kinopoisk.ru/";
        Configuration.timeout = 10000;
        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setBinary("/chromedriver.exe");
        //chromeOptions.setCapability("webdriver.chrome.driver", "/chromedriver.exe");
        Configuration.browserCapabilities = chromeOptions;;*/
    }
}
