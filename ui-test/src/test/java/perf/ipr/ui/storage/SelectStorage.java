package perf.ipr.ui.storage;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Map;

public interface SelectStorage {
    Map<String, SelenideElement> getSelects();
    Map<String, List<String>> getSelectOptions();
}
