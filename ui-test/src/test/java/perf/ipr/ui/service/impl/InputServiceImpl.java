package perf.ipr.ui.service.impl;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.service.InputService;
import perf.ipr.ui.storage.InputStorage;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@Service
public class InputServiceImpl implements InputService {
    @Autowired
    private InputStorage inputStorage;


    @Override
    public void fillAndCheck(String name, String value) {
        fillInput(name,value);
        checkFilledInput(name,value);
    }

    @Override
    @Step("Заполнить строку ввода \"{name}\" - \"{value}\"")
    public void fillInput(String name, String value) {
        inputStorage.getInputs().get(name).setValue(value);
    }

    @Override
    @Step("Проверить заполнение строки ввода \"{name}\" - \"{value}\"")
    public void checkFilledInput(String name, String value) {
        assertEquals("Значение остутствует",inputStorage.getInputs().get(name).getValue(),value);
    }

}