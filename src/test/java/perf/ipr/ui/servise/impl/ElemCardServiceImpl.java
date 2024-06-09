package perf.ipr.ui.servise.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perf.ipr.ui.servise.ElemCardService;
import perf.ipr.ui.storage.ElemCardStorage;

@Component
public class ElemCardServiceImpl implements ElemCardService {
    @Autowired
    private ElemCardStorage elemStorage;

    @Override
    @Step("Проверить наличие элементов на \"{nameElem}\"")
    public void checkTextElements(String nameElem) {
        ElementsCollection tile = elemStorage.getTile();
        for (String text : elemStorage.getTextElems().get(nameElem)){
            tile.findBy(Condition.text(text)).shouldBe(Condition.visible);
        }

    }
}
