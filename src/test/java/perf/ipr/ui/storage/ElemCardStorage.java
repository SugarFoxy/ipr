package perf.ipr.ui.storage;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;
import java.util.Map;

public interface ElemCardStorage {
    Map<String, List<String>> getTextElems();
    ElementsCollection getTile();
}
