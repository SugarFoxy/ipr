package perf.ipr.ui.steps;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perf.ipr.ui.core.BaseUITest;
import perf.ipr.ui.pages.MoviePage;
import perf.ipr.ui.pages.SearchMoviePage;

@SpringBootTest
public class SearchMovieTest extends BaseUITest {
    @Autowired
    private MoviePage moviePage;
    @Autowired
    private SearchMoviePage searchMoviePage;

    @BeforeEach
    public void init() {
        super.init();
        searchMoviePage.buttonService.clickButton("Расширеный поиск");
    }

    @Test
    @Description("Проверка страницы поиска.")
    public void checkCardSearchMovie() {
        searchMoviePage.buttonService.checkDisabledButton("Поиск подробный поиск");
        searchMoviePage.elemCardService.checkTextElements("Искать фильм");
        searchMoviePage.inputService.fillAndCheck("название", "Кин-дза-дза!");
        searchMoviePage.buttonService.checkEnabledButton("Поиск подробный поиск");
        searchMoviePage.inputService.fillAndCheck("год", "1986");
        searchMoviePage.inputService.fillAndCheck("актёр", "Евгений Леонов");
        searchMoviePage.inputService.fillAndCheck("создатели", "Георгий Данелия");
        searchMoviePage.selectService.checkSelect("год интервал с", "1980");
        searchMoviePage.selectService.checkSelect("год интервал до", "1990");
        searchMoviePage.selectService.checkSelect("страна", "СССР");
        //selectService.checkSelect("прокатчик", "любой");
        //selectService.checkSelect("прокатчик", "-");
        searchMoviePage.selectService.checkSelect("MPAA", "PG-13");
        searchMoviePage.selectService.checkMultiSelect("жанры", "фантастика");
        searchMoviePage.selectService.checkMultiSelect("премьера месяц", "Декабрь");
        searchMoviePage.selectService.checkMultiSelect("премьера год", "1986");
        searchMoviePage.selectService.checkMultiSelect("премьера страна", "Мире");
        searchMoviePage.selectService.checkMultiSelect("сборы сравнение", "больше");
        searchMoviePage.inputService.fillAndCheck("сборы сумма", "10000");
        searchMoviePage.selectService.checkMultiSelect("сборы страна", "России");
        searchMoviePage.selectService.checkMultiSelect("категория", "фильм");
        searchMoviePage.checkBoxService.clickCheckBox("чекбокс жанра");
        searchMoviePage.checkBoxService.checkSelectedCheckBox("чекбокс жанра");
        searchMoviePage.checkBoxService.clickCheckBox("чекбокс жанра");
        searchMoviePage.buttonService.clickButton("Поиск подробный поиск");
        moviePage.elementsService.checkElement("Кин-дза-дза! (1986)");
    }
}
