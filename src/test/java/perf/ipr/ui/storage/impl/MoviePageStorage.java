package perf.ipr.ui.storage.impl;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;
import perf.ipr.ui.storage.ElementStorage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

@Component
public class MoviePageStorage implements ElementStorage {

    @Override
    public Map<String, SelenideElement> getElements() {
        Map<String, SelenideElement> elements = new HashMap<>();
        elements.put("Кин-дза-дза! (1986)", $x("//*[@id=\"__next\"]/div[1]/div[2]/main/div[1]/div[2]/div/" +
                "div[3]/div/div/div[1]/div[1]/div/div[1]/h1/span"));
        return elements;
    }
}
