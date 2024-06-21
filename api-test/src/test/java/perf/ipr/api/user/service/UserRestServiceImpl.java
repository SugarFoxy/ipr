package perf.ipr.api.user.service;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.api.core.RestRequest;
import perf.ipr.api.user.dto.UserDto;

import java.util.Map;

@Service
public class UserRestServiceImpl implements UserRestService {

    @Override
    @Step("Создать нового пользователя POST /users")
    public Response createUser(UserDto userDto) {
        return RestRequest.executePostRequest("/users",
                userDto);
    }

    @Override
    @Step("Обновить данные пользователя PATCH /users/{userId}")
    public Response updateUser(UserDto userDto) {
        return RestRequest.executePatchRequestWithPathParam("/users/{userId}",
                userDto,
                Map.of("userId", userDto.getId().toString()));
    }

    @Override
    @Step("Получить данные пользователя GET /users/{userId}")
    public Response getUserById(Long id) {
        return RestRequest.executeGetRequestWithPathParam("/users/{userId}",
                Map.of("userId", id.toString()));
    }

    @Override
    @Step("Удалить данные пользователя DELETE /users/{userId}")
    public Response deleteUserById(Long id) {
        return RestRequest.executeDeleteRequestWithPathParam("/users/{userId}",
                Map.of("userId", id.toString()));
    }


}
