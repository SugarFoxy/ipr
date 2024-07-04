package perf.ipr.api.user.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class StatusChecker {
    @Step("Проверить код ответа {status}")
    public static void checkStatus(Integer status, Response response) {
        Integer statusCode = response.getStatusCode();
        log.info(response.getBody().print());
        assertEquals(statusCode, status,
                String.format("Ожидался к`од - %d, пришел - %d", status, statusCode));
    }
}
