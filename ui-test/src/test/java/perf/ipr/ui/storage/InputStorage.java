package perf.ipr.ui.storage;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

public interface InputStorage {
    Map<String, SelenideElement> getInputs();
}
