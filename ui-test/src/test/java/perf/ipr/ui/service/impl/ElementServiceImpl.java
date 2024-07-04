package perf.ipr.ui.service.impl;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import perf.ipr.ui.service.ElementService;
import perf.ipr.ui.storage.ElementStorage;


public class ElementServiceImpl implements ElementService {
    private final ElementStorage elementStorage;

    public ElementServiceImpl(ElementStorage elementStorage){
        this.elementStorage = elementStorage;
    }

    @Override
    @Step("Проверить текст элемента \"{nameElement}\" и его наличие на странице")
    public void checkElement(String nameElement) {
        elementStorage.getElements().get(nameElement)
                .shouldBe(Condition.exactText(nameElement))
                .shouldBe(Condition.visible);
    }
}
