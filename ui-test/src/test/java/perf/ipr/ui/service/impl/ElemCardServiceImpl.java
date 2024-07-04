package perf.ipr.ui.service.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import perf.ipr.ui.service.ElemCardService;
import perf.ipr.ui.storage.ElemCardStorage;


public class ElemCardServiceImpl implements ElemCardService {
    private final ElemCardStorage elemCardStorage;

    public ElemCardServiceImpl(ElemCardStorage elemCardStorage) {
        this.elemCardStorage = elemCardStorage;
    }

    @Override
    @Step("Проверить наличие элементов на \"{nameElem}\"")
    public void checkTextElements(String nameElem) {
        ElementsCollection tile = elemCardStorage.getTile();
        for (String text : elemCardStorage.getTextElems().get(nameElem)) {
            tile.findBy(Condition.text(text)).shouldBe(Condition.visible);
        }

    }
}
