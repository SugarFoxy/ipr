package perf.ipr.ui.service.impl;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.service.ElementService;
import perf.ipr.ui.storage.ElementStorage;

@Service
public class ElementServiceImpl implements ElementService {
    @Autowired
    private ElementStorage elementStorage;

    @Override
    @Step("Проверить текст элемента \"{nameElement}\" и его наличие на странице")
    public void checkElement(String nameElement) {
        elementStorage.getElements().get(nameElement)
                .shouldBe(Condition.exactText(nameElement))
                .shouldBe(Condition.visible);
    }
}
