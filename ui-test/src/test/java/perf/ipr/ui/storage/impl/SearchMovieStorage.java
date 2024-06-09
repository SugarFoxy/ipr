package perf.ipr.ui.storage.impl;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Service;
import perf.ipr.ui.storage.*;

import java.util.*;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Service
public class SearchMovieStorage implements ButtonStorage, ElemCardStorage, InputStorage, SelectStorage, CheckBoxStorage {
    @Override
    public Map<String, SelenideElement> getButtons() {
        Map<String, SelenideElement> buttons = new HashMap<>();
        buttons.put("Расширеный поиск", $x("//a[@aria-label=\"Расширенный поиск\"]"));
        buttons.put("Поиск подробный поиск", $x("//*[@id=\"formSearchMain\"]/input[11]"));
        return buttons;
    }

    @Override
    public Map<String, List<String>> getTextElems() {
        Map<String, List<String>> texts = new HashMap<>();
        texts.put("Искать фильм", Arrays.asList("Искать фильм:",
                "полное или частичное название фильма",
                "+ год:",
                "...или интервал:",
                "c",
                "по",
                "+ страна:",
                "+ жанр:",
                "+ прокатчик:",
                "+ MPAA:",
                "+ актер:",
                "+ создатели:",
                "актер/актриса",
                "режиссер/продюсер/сценарист...",
                "+ премьера:",
                "в",
                "+ сборы:",
                "$",
                "млн.",
                "в",
                "что искать?"
        ));
        return texts;
    }

    @Override
    public ElementsCollection getTile() {
        return $$x("//form[@name=\"film_search\"]");
    }

    @Override
    public Map<String, SelenideElement> getInputs() {
        Map<String, SelenideElement> inputs = new HashMap<>();
        inputs.put("название", $x("//input[@name=\"m_act[find]\"]"));
        inputs.put("год", $x("//input[@name=\"m_act[year]\"]"));
        inputs.put("актёр", $x("//input[@name=\"m_act[actor]\"]"));
        inputs.put("создатели", $x("//input[@name=\"m_act[cast]\"]"));
        inputs.put("сборы сумма", $x("//input[@name=\"m_act[box]\"]"));
        return inputs;
    }

    @Override
    public Map<String, SelenideElement> getSelects() {
        Map<String, SelenideElement> selects = new HashMap<>();
        selects.put("год интервал с", $x("//select[@id=\"from_year\"]"));
        selects.put("год интервал до", $x("//select[@id=\"to_year\"]"));
        selects.put("страна", $x("//select[@id=\"country\"]"));
        selects.put("прокатчик", $x("//select[@id=\"company\"]"));
        selects.put("MPAA", $x("//select[@name=\"m_act[mpaa]\"]"));
        selects.put("жанры", $x("//select[@id=\"m_act[genre]\"]"));
        selects.put("премьера месяц", $x("//select[@id=\"prem_month\"]"));
        selects.put("премьера год", $x("//select[@id=\"prem_year\"]"));
        selects.put("премьера страна", $x("//select[@id=\"prem_type\"]"));
        selects.put("сборы сравнение", $x("//select[@name=\"m_act[box_vector]\"]"));
        selects.put("сборы страна", $x("//select[@name=\"m_act[box_type]\"]"));
        selects.put("категория", $x("//select[@name=\"m_act[content_find]\"]"));
        return selects;
    }

    @Override
    public Map<String, List<String>> getSelectOptions() {
        Map<String, List<String>> selectOptions = new HashMap<>();
        selectOptions.put("год интервал с", getYearsOptions(1890,2025));
        selectOptions.put("год интервал до", getYearsOptions(1890,2025));
        selectOptions.put("страна", getCountriesOptions());
        selectOptions.put("прокатчик", getCompaniesOptions());
        selectOptions.put("MPAA", getMpaaOptions());
        selectOptions.put("жанры", getGenresOptions());
        selectOptions.put("премьера месяц", getMonthsOptions());
        selectOptions.put("премьера год", getYearsOptions(1895,2025));
        selectOptions.put("премьера страна", getCountriesShortOptions());
        selectOptions.put("сборы сравнение", getComparisonOptions());
        selectOptions.put("сборы страна", getCountriesShortOptions());
        selectOptions.put("категория", getTypesOptions());
        return selectOptions;
    }

    @Override
    public Map<String, SelenideElement> getCheckBoxes() {
        Map<String, SelenideElement> checkBoxes = new HashMap<>();
        checkBoxes.put("чекбокс жанра", $x("//input[@id=\"m_act[genre_and]\"]"));
        return checkBoxes;
    }

    private List<String> getYearsOptions(int from, int to) {
        List<String> yearsInterval = new ArrayList<>();
        for (int i = from; i <= to; i++) yearsInterval.add(String.valueOf(i));
        yearsInterval.add("-");
        return yearsInterval;
    }

    private static List<String> getCountriesOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "Россия", "США", "СССР", "Австралия", "Австрия", "Азербайджан", "Албания", "Алжир",
                "Американское Самоа", "Ангола", "Андорра", "Антарктида", "Антигуа и Барбуда", "Антильские Острова",
                "Аргентина", "Армения", "Аруба", "Афганистан", "Багамы", "Бангладеш", "Барбадос", "Бахрейн", "Беларусь",
                "Белиз", "Бельгия", "Бенин", "Берег Слоновой кости", "Бермуды", "Бирма", "Болгария", "Боливия", "Босния",
                "Босния и Герцеговина", "Ботсвана", "Бразилия", "Бруней-Даруссалам", "Буркина-Фасо", "Бурунди", "Бутан",
                "Вануату", "Ватикан", "Великобритания", "Венгрия", "Венесуэла", "Виргинские Острова (Великобритания)",
                "Виргинские Острова (США)", "Внешние малые острова США", "Вьетнам", "Вьетнам Северный", "Габон", "Гаити",
                "Гайана", "Гамбия", "Гана", "Гваделупа", "Гватемала", "Гвинея", "Гвинея-Бисау", "Германия", "Германия (ГДР)",
                "Германия (ФРГ)", "Гибралтар", "Гондурас", "Гонконг", "Гренада", "Гренландия", "Греция", "Грузия", "Гуам",
                "Дания", "Джибути", "Доминика", "Доминикана", "Египет", "Заир", "Замбия", "Западная Сахара", "Зимбабве",
                "Израиль", "Индия", "Индонезия", "Иордания", "Ирак", "Иран", "Ирландия", "Исландия", "Испания", "Италия",
                "Йемен", "Кабо-Верде", "Казахстан", "Каймановы острова", "Камбоджа", "Камерун", "Канада", "Катар", "Кения",
                "Кипр", "Кирибати", "Китай", "Колумбия", "Коморы", "Конго", "Конго (ДРК)", "Корея", "Корея Северная",
                "Корея Южная", "Косово", "Коста-Рика", "Кот-д’Ивуар", "Куба", "Кувейт", "Кыргызстан", "Лаос", "Латвия",
                "Лесото", "Либерия", "Ливан", "Ливия", "Литва", "Лихтенштейн", "Люксембург", "Маврикий", "Мавритания",
                "Мадагаскар", "Макао", "Македония", "Малави", "Малайзия", "Мали", "Мальдивы", "Мальта", "Марокко", "Мартиника",
                "Маршалловы острова", "Масаи", "Мексика", "Мелкие отдаленные острова США", "Мозамбик", "Молдова", "Монако",
                "Монголия", "Монтсеррат", "Мьянма", "Намибия", "Непал", "Нигер", "Нигерия", "Нидерланды", "Никарагуа",
                "Новая Зеландия", "Новая Каледония", "Норвегия", "ОАЭ", "Оккупированная Палестинская территория", "Оман",
                "Остров Мэн", "Остров Святой Елены", "Острова Кука", "острова Теркс и Кайкос", "Пакистан", "Палау",
                "Палестина", "Панама", "Папуа - Новая Гвинея", "Парагвай", "Перу", "Польша", "Португалия", "Пуэрто Рико",
                "Реюньон", "Российская империя", "Россия", "Руанда", "Румыния", "Сальвадор", "Самоа", "Сан-Марино",
                "Сан-Томе и Принсипи", "Саудовская Аравия", "Свазиленд", "Северная Македония", "Сейшельские острова",
                "Сенегал", "Сент-Винсент и Гренадины", "Сент-Китс и Невис", "Сент-Люсия", "Сербия", "Сербия и Черногория",
                "Сиам", "Сингапур", "Сирия", "Словакия", "Словения", "Соломоновы Острова", "Сомали", "СССР", "Судан", "Суринам",
                "США", "Сьерра-Леоне", "Таджикистан", "Таиланд", "Тайвань", "Танзания", "Тимор-Лесте", "Того", "Тонга",
                "Тринидад и Тобаго", "Тувалу", "Тунис", "Туркменистан", "Турция", "Уганда", "Узбекистан", "Украина",
                "Уоллис и Футуна", "Уругвай", "Фарерские острова", "Федеративные Штаты Микронезии", "Фиджи", "Филиппины",
                "Финляндия", "Фолклендские острова", "Франция", "Французская Гвиана", "Французская Полинезия", "Хорватия",
                "ЦАР", "Чад", "Черногория", "Чехия", "Чехословакия", "Чили", "Швейцария", "Швеция", "Шпицберген и Ян-Майен",
                "Шри-Ланка", "Эквадор", "Экваториальная Гвинея", "Эритрея", "Эстония", "Эфиопия", "ЮАР", "Югославия",
                "Югославия (ФР)", "Ямайка", "Япония");
    }

    private static List<String> getCountriesShortOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "США", "России", "Мире");
    }
    private static List<String> getComparisonOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "больше", "меньше");
    }

    private static List<String> getGenresOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "аниме", "биография", "боевик", "вестерн", "военный", "детектив", "детский", "для взрослых",
                "документальный", "драма", "игра", "история", "комедия", "концерт", "короткометражка", "криминал", "мелодрама",
                "музыка", "мультфильм", "мюзикл", "новости", "приключения", "реальное ТВ", "семейный", "спорт", "ток-шоу",
                "триллер", "ужасы", "фантастика", "фильм-нуар", "фэнтези", "церемония");
    }

    private static List<String> getMpaaOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "G", "GP", "PG", "PG-13", "R", "NC-17");
    }

    private static List<String> getTypesOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-","фильм","сериал","обои","фотографии","постеры","трейлеры", "DVD");
    }

    private static List<String> getMonthsOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
    }

    private static List<String> getCompaniesOptions() {
        List<String> values = new ArrayList<>();
        return Arrays.asList("-", "любой", "#ARTPOKAZ", "100 film", "24_DOC", "25th Floor Film", "A Company",
                "A-Gonchukov", "A-One Films", "A.I. Production Film Company", "AKP Moscow", "Aleko-Film", "All Media",
                "Almazfilm", "Alti Films", "Amigos Film", "ANO SITA", "Apollo Film", "Aprel MIG Pictures", "Arena",
                "Argus-SV", "Arna Media", "Art Film Distribution", "Art Movie Entertainment", "Art Pictures", "Arthaus",
                "Artmainstream", "Artscience Distribution", "Astrafilm", "ATgroup", "ATK-Studio", "Atmosfera kino",
                "Aurora Media", "Aurora-servis", "AVK`PRO", "Avrora", "Base Development", "BaykalKino",
                "Bazelevs Distribution", "Beat Films", "BFM", "BulldozerFilms", "BVSPR", "BVSPR Disney", "BVSPR Sony",
                "Capella Film", "CD LAND", "Chaka Production", "Cine Image", "Cinedoc", "Cinema Park Distribution",
                "Cinema Prestige", "Cinema Vision", "Cinemaus Studio", "Cineticle Films", "Continent", "CoolConnections",
                "CP Classic", "CP Digital", "Dalmatian Film", "Disney Studios", "DMG", "DokFilmDok", "DreamTeam",
                "Drimtim Media", "Drugoe kino", "DVD Group", "Eksponenta", "Exponenta Horror", "Fank", "Felicita Cinema",
                "Film +", "FOF Company", "Fond Myhaila Kalatozova", "Garage", "GFF Rossii", "Global Film", "Gorad",
                "GP Group", "Grani kino", "HHG", "Human Films", "IC", "Illuzion Kino", "IMAX", "In Moushn", "Indian Films",
                "Inferno prokat", "INSIDE DSTR", "Interfest", "Irish Week", "Kamerton", "Karavella DDC", "Karmen-Premier",
                "Karo", "Kazak Film", "Kentavr", "Kino.Art.Pro", "Kinoa", "KinoBaraban", "KinoClub", "KinoDetstvo",
                "Kinodistribution", "Kinografiya", "KINOKIA", "Kinokontact", "Kinolife World", "Kinologistika", "Kinomir",
                "Kinoprom", "Kinostudiya im. Gorkogo", "Kinotime", "Krasnaya Shapka Films", "Krem-Rekords", "Kremlin Filmz",
                "Kvartal-95", "Legkie Ludi", "Lenfilm", "Leva", "Liniya Kino", "Livandiya Enterteinment", "Lizard Cinema",
                "LoonaFilm", "Lubiteli", "Lussi Film", "Lux Cinema", "Magic Film Company", "Mallory Film",
                "Master Distribushn", "Master Sinema", "Masterskaya Pavla Lungina", "Mechta", "Media-Telekom",
                "Megabox Plus M", "MEGOGO Distribution", "MEGOGO Studios", "Meloman Entertainment", "Mika Film",
                "Mirazh", "Misteriya Zvuka", "Molodyozhnye initsiativy", "Most-media", "Most-Sinematograf",
                "Motor Interteintment", "Mult v kino", "Must See Magic Film", "Nadezhda", "New Cinema Marketing",
                "NMG Kinoprokat", "Non-Stop Prodakshn", "Nonstop MEDIA", "Ogni Urala", "OperaHD", "Organic Films",
                "ORT", "P&I Films", "Pioner", "Plan B", "Plan2Real", "Premier Zal", "Premier-Kinoprokat",
                "Prior Distribution", "Project Manometr", "Proline-media", "PROvzglyad", "Pushkin Pictures",
                "Pyatoe iyunya", "Raketa Relizing", "Reanimedia", "Reflexion Films", "RFG Distribution", "RFILMSTUDIO",
                "Rok", "ROSPOFilm", "RUSCICO", "Russian Film Group", "Russian World Vision", "RWS", "Salvador-D",
                "Samokat", "SAN Media", "SaundMF", "Seaview company", "SEF-Kinoton", "SFI-Distribution", "Shans",
                "Sine Fantom", "Solar Distribution", "Sony Pictures Production and Releasing", "Sovencher",
                "SP «Mosimedia»", "Starlet Media", "Starlet-Media", "Storm Cinema", "Studiya Passazhir", "Studiya Slon",
                "STV", "Survive Entertainment", "Svoi pocherk", "Teatralnaya kompaniya Vadima Dubrovitskogo",
                "Telekompaniya Semya", "Ten Letters", "TheatreHD", "TO Ekran", "TO Klass", "Top Film Distribution",
                "Tree Films", "Tretyakovka", "TSDK", "Tsentral Partnership Classic", "TsentrFilm", "Twister", "UIP",
                "UMS Film", "Universal Distribution", "UPI", "Utopia Pictures", "Videoimpuls", "Vox Video", "Voyage",
                "Vverkh", "VVP Alyans", "WDSSPR", "West", "White Nights", "World Pictures", "Yellow, Black & White",
                "Zolotoy vek", "АбсолютФильм", "АКМ", "Алекс Фильм", "Алхимия-Фильм", "Амадеус", "Амедия", "Аргумент Кино",
                "Арена-Интертейнмент", "Арс-Н", "Артворкс Фильм", "Аталанта", "Б-2", "Варяг", "Василиса", "Видеосервис",
                "Видеофильм", "Возвращение - XX век", "ВолгаКиноЛокейшн", "Волшебный фонарь", "Вольга", "Высокие широты",
                "ГАМС", "ГАУ МО «Мособлкино»", "Гельварс", "Гемини", "Гемини Киномир", "Грэком", "ГУП `Московское кино`",
                "Двадцатый Век Фокс СНГ", "Диалог с миром", "дистрибьютор: студия", "Екатеринбург Арт", "Задорное КИНО",
                "Захаровский Благотворительный Пушкинский фонд `Истоки`", "Золотой Век", "Ибрус", "Инвада Фильм",
                "Иноекино", "Интермедия", "Интерсинема-Арт", "Искусство кино", "Ист-Вест", "Камер-Тон",
                "Камер-Тон Интернэйшнл", "Камер-Тон-Фильм-Русь", "Карбуш", "Кармен", "Кармен Фильм", "Каро-Премьер",
                "КарроПрокат", "Каскад фильм", "Кино без границ", "Кино Сити Прокат", "Кинобюро №1", "Кинокомпания СТВ",
                "Кинолэнд", "Кинопанорама", "КиноПоиск", "Кинопрограмма XXI век", "Киностудия Горького", "Киносфера",
                "Киноцентр", "Корпорация кино", "Космопол ФД", "Кредо-Аспек", "ЛА Продакшн", "Легион-фильм", "ЛеопАрт",
                "Леополис", "Люксор", "Магнетик ЛАБ", "Магнум Пикчерз", "Макс", "Мания кино", "Мастер", "Маурис Филм", "МВК",
                "МГП Киновидеопрокат", "Милена-фильм", "Москвич", "Московское Кино", "Мосфильм", "Мосфильм-Мастер",
                "Мотор! Фильм", "Нарти Мувиз", "Настроение", "Наше Кино", "НД Плэй", "НеваФильм Emotion", "Никола-фильм",
                "Новые Люди", "НТВ-Профит", "Пан Терра", "Панорама", "Панорама Кино", "Парадиз", "Парадиз 2000",
                "Партнер Видео Фильм", "Первое Кино", "Пигмалион Продакшн", "ПилотКино", "Пирамида", "План 9", "План Проект",
                "План-Проект", "Планета Информ", "Полигон", "Премиум Фильм", "Престиж Кино", "Проба Медиа Продакшн",
                "прокат", "Профит Синема Интернешнл", "Роскинопрокат", "Русский Репортаж", "СБ Фильм", "Свои 2000",
                "Севкавбанк", "Совэкспортфильм", "Союз", "Среда Фетисов Филмс", "Стелла", "Стелла-Релиз", "Студия `САС`",
                "ТПО ТДФ", "ТриТэ", "Фильм Аккорд", "Фильмэкспорт", "Фокс/Гемини", "Фора-фильм", "Форте Синема",
                "Центр Национального Фильма", "Центр-Скип-Фильм", "Централ Партнершип");
    }
}
