package perf.ipr.api.user.common;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import perf.ipr.api.core.RestRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class StatusChecker {
    @Step("Проверить код ответа {status}")
    public static void checkStatus(Integer status) {
        Integer statusCode = RestRequest.response.getStatusCode();
        log.info(RestRequest.response.getBody().print());
        assertEquals(statusCode, status,
                String.format("Ожидался код - %d, пришел - %d", status, statusCode));
    }
}
