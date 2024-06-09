package perf.ipr.ui.servise.impl;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perf.ipr.ui.servise.ButtonService;
import perf.ipr.ui.storage.ButtonStorage;
@Component
public class ButtonServiceImpl implements ButtonService {
    @Autowired
    private ButtonStorage buttonStorage;
    @Override
    @Step("Нажать на кнопку - \"{nameButton}\"")
    public void clickButton(String nameButton) {
        buttonStorage.getButtons().get(nameButton).click();
    }

    @Override
    @Step("Проверить что кнопка \"{nameButton}\" не активна")
    public void checkDisabledButton(String nameButton) {
        buttonStorage.getButtons().get(nameButton).shouldBe(Condition.disabled);
    }

    @Override
    @Step("Проверить что кнопка \"{nameButton}\" активна")
    public void checkEnabledButton(String nameButton) {
        buttonStorage.getButtons().get(nameButton).shouldBe(Condition.enabled);
    }
}
