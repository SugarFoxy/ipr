package perf.ipr.ui.servise.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.servise.SelectService;
import perf.ipr.ui.storage.SelectStorage;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectStorage selectStorage;


    @Override
    public void checkMultiSelect(String name, String value){
        this.checkOpenedSelectOptions(name);
        this.selectElement(name,value);
        this.checkSelectedElement(name,value);
    }

    @Override
    public void checkSelect(String name, String value){
        this.clickSelect(name);
        this.checkOpenedSelectOptions(name);
        this.selectElement(name,value);
        this.checkSelectedElement(name,value);
    }


    @Step("Проверить нажатие на select \"{name}\"")
    @Override
    public void clickSelect(String name) {
        SelenideElement select = selectStorage.getSelects().get(name);
        select.shouldBe(Condition.visible);
        select.click();
    }

    @Step("Проверить что список \"{name}\" открыт и содержит нужные элементы")
    @Override
    public void checkOpenedSelectOptions(String name) {
        SelenideElement selects = selectStorage.getSelects().get(name);
        List<String> optionsExpectValues = selectStorage.getSelectOptions().get(name);
        ElementsCollection options = selects.$$("option");
        options.forEach(option -> option.shouldBe(Condition.visible));
        List<String> optionsActualValues = options.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        assertTrue(optionsExpectValues.containsAll(optionsActualValues) && optionsActualValues.containsAll(optionsExpectValues),"Списки не соответствуют"+optionsExpectValues+" bat was " +optionsActualValues);

    }

    @Step("Выбрать элемент в списке \"{name}\" - \"{value}\"")
    @Override
    public void selectElement(String name, String value) {
        SelenideElement select = selectStorage.getSelects().get(name);
        select.selectOption(value);
    }

    @Step("Проверить что выбран элемент \"{name}\" - \"{value}\"")
    @Override
    public void checkSelectedElement(String name, String value) {
        SelenideElement select = selectStorage.getSelects().get(name);
        select.getSelectedOption().shouldBe(Condition.exactText(value));
    }
}
