package perf.ipr.ui.servise;

public interface SelectService {
    void checkMultiSelect(String name, String value);

    void checkSelect(String name, String value);

    void clickSelect(String name);

    void checkOpenedSelectOptions(String name);

    void selectElement(String name, String value);

    void checkSelectedElement(String name, String value);
}
