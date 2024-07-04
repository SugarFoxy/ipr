# Модульный тестовый Фреймворк IPR

IPR - это тестовый фреймворк для тестирования функциональности сервиса share-it ( https://github.com/SugarFoxy/java-shareit ) и карточки поиска фильмов на КиноПоиске. Стек технологий включает в себя postgreSQL, spring boot, hibernate, junit5, lombok, rest assured, gson, allure, selenide и SQL.

Модули api и db тестируют сервис share-it. Само тестируемое приложение в запакованном виде находится непосредственно в репозитории (shareit/shareit-server.jar). Модуль api тестирует страницу поиска фильмов Кинопоиска (<https://www.kinopoisk.ru/s/>).

 Все модули и сервис запускаются в докер-контейнерах. Реализован pipeline CI/CD для запуска тестируемого приложения и тестового фреймворка в контейнерах и вывода отчета allure на GitHub Pages ([https://sugarfoxy.github.io/ipr/](https://sugarfoxy.github.io/ipr/ "https://sugarfoxy.github.io/ipr/")).

### Модули

* #### Модуль api (ipr/api)

* #### Модуль ui (ipr/ui)

* #### Модуль db (ipr/db)

# Модуль api

Тестирует rest-api сервис share-it. 

Используемый модулем стек технологий : postgresql,spring boot, hibernate, junit5, lombok, rest assured, gson, allure

### Реализованы следующие тесты:

* создание пользователя
* создание дубликата пользователя
* обновление пользователя
* получение пользователя
* удаление пользователя

# Модуль db

Модуль db демонстрирует возможность тестирования с использованием прямых SQL-запросов.

Используемый модулем стек технологий : postgresql, spring boot, junit5, allure

# Модуль ui

Модуль ui тестирует карточку поиска фильмов на КиноПоиске.

Стек технологий включает в себя: spring boot, selenide, junit5, lombok, allure

Структура придумана и разработана лично мной. Она включает в себя сервисы для работы с элементами страницы, которые в свою очередь хранятся в реализации хранилищ, необходимых для работы со страницей или карточкой.

## CI/CD

В GitHub реализован pipeline CI/CD для запуска тестового фреймворка, вывода результатов работы в отчет allure и публикации отчета на GitHub Pages.

Pipeline состоит из 3 этапов:

* build-and-test: Выполняет сборку/запуск приложения и тестов в контейнерах Docker с использованием docker-compose. После завершения работы контейнеров, результаты тестов извлекаются и сохраняются с использованием github-artifacts для следующих этапов в артефакт “allure-results”.
   Все модули и сервис запускаются с использованием docker-compose в 3 контейнерах в следующем порядке:  “postgresql” =\> “shareit” =\>  “db - api - ui”.

* build-allure-report: Извлекает отчеты Allure из артефакта “allure-results”, генерирует отчет Allure и выгружает его в артефакт “_site”.

* publish-report:  Извлекает сгенерированный отчет Allure из артефакта “_site” и публикует его на GitHub Pages.
