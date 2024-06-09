package perf.ipr.api.user.common;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static perf.ipr.api.core.RestRequest.response;
@Slf4j
public class StatusChecker {
    @Step("Проверить код ответа {status}")
    public static void checkStatus(Integer status) {
        Integer statusCode = response.getStatusCode();
        log.info(response.getBody().print());
        assertEquals(statusCode, status,
                String.format("Ожидался код - %d, пришел - %d", status, statusCode));
    }
}
