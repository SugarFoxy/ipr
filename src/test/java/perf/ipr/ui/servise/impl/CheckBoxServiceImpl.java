package perf.ipr.ui.servise.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.servise.CheckBoxService;
import perf.ipr.ui.storage.CheckBoxStorage;

@Service
public class CheckBoxServiceImpl implements CheckBoxService {

    @Autowired
    private CheckBoxStorage checkBoxStorage;

    @Override
    public void checkCheckBox(String name){
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
