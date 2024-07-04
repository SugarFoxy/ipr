package perf.ipr.ui.service.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import perf.ipr.ui.service.CheckBoxService;
import perf.ipr.ui.storage.CheckBoxStorage;

public class CheckBoxServiceImpl implements CheckBoxService {
    private final CheckBoxStorage checkBoxStorage;

    public CheckBoxServiceImpl(CheckBoxStorage checkBoxStorage) {
        this.checkBoxStorage = checkBoxStorage;
    }

    @Override
    public void checkCheckBox(String name) {
        this.clickCheckBox(name);
        this.checkSelectedCheckBox(name);
    }

    @Override
    @Step("Нажать на чекбокс \"{name}\"")
    public void clickCheckBox(String name) {
        SelenideElement checkbox = checkBoxStorage.getCheckBoxes().get(name);
        checkbox.click();
    }

    @Override
    @Step("Проверить что значение true \"{name}\"")
    public void checkSelectedCheckBox(String name) {
        SelenideElement checkbox = checkBoxStorage.getCheckBoxes().get(name);
        checkbox.shouldBe(Condition.selected);
    }
}
