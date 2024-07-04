package perf.ipr.ui.service.impl;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import perf.ipr.ui.service.ButtonService;
import perf.ipr.ui.storage.ButtonStorage;


public class ButtonServiceImpl implements ButtonService {
    private final ButtonStorage buttonStorage;

    public ButtonServiceImpl(ButtonStorage buttonStorage) {
        this.buttonStorage = buttonStorage;
    }

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
