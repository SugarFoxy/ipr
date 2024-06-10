package perf.ipr.ui.steps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perf.ipr.ui.core.BaseUITest;
import perf.ipr.ui.service.*;

@SpringBootTest
public class SearchMovieTest extends BaseUITest {
    @Autowired
    private ElemCardService elemCardService;
    @Autowired
    private ElementService elementService;
    @Autowired
    private ButtonService buttonService;
    @Autowired
    private InputService inputService;
    @Autowired
    private SelectService selectService;
    @Autowired
    private CheckBoxService checkBoxService;


    @BeforeEach
    public void init() {
        super.init();
        buttonService.clickButton("Расширеный поиск");
    }


    @Test
    public void checkCardSearchMovie() {
        buttonService.checkDisabledButton("Поиск подробный поиск");
        elemCardService.checkTextElements("Искать фильм");
        inputService.fillAndCheck("название", "Кин-дза-дза!");
        buttonService.checkEnabledButton("Поиск подробный поиск");
        inputService.fillAndCheck("год", "1986");
        inputService.fillAndCheck("актёр", "Евгений Леонов");
        inputService.fillAndCheck("создатели", "Георгий Данелия");
        selectService.checkSelect("год интервал с", "1980");
        selectService.checkSelect("год интервал до", "1990");
        selectService.checkSelect("страна", "СССР");
        //selectService.checkSelect("прокатчик", "любой");
        //selectService.checkSelect("прокатчик", "-");
        selectService.checkSelect("MPAA", "PG-13");
        selectService.checkMultiSelect("жанры", "фантастика");
        selectService.checkMultiSelect("премьера месяц", "Декабрь");
        selectService.checkMultiSelect("премьера год", "1986");
        selectService.checkMultiSelect("премьера страна", "Мире");
        selectService.checkMultiSelect("сборы сравнение", "больше");
        inputService.fillAndCheck("сборы сумма", "10000");
        selectService.checkMultiSelect("сборы страна", "России");
        selectService.checkMultiSelect("категория", "фильм");
        checkBoxService.clickCheckBox("чекбокс жанра");
        checkBoxService.checkSelectedCheckBox("чекбокс жанра");
        checkBoxService.clickCheckBox("чекбокс жанра");
        buttonService.clickButton("Поиск подробный поиск");
        elementService.checkElement("Кин-дза-дза! (1986)");
    }
}
