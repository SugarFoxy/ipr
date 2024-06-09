package perf.api.user.service;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perf.api.core.RestRequest;
import perf.api.user.dto.UserDto;

import java.util.Map;

import static perf.api.user.template.UserTemplate.*;
import static perf.api.util.GeneratorJson.toJson;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private RestRequest request;
    private static UserDto userDto;
    private static String id;

    @Override
    @Step("Создать нового пользователя POST /users")
    public void createUser() {
        UserServiceImpl.userDto = getCorrectUserData();
        creteResponse(userDto);
        setId();
    }

    @Override
    public void createDuplicateUser() {
        creteResponse(getDuplicateUserData());
    }

    @Override
    @Step("Обновить данные пользователя PATCH /users/{userId}")
    public void updateUser() {
        UserServiceImpl.userDto = getUpdateUserData();
        request.executePatchRequestWithPathParam("/users/{userId}",
                toJson(userDto),
                Map.of("userId", id));
    }

    @Override
    @Step("Получить данные пользователя GET /users/{userId}")
    public void getUserById() {
        request.executeGetRequestWithPathParam("/users/{userId}",
                Map.of("userId", id));
    }

    @Override
    @Step("Удалить данные пользователя DELETE /users/{userId}")
    public void deleteUserById() {
        request.executeDeleteRequestWithPathParam("/users/{userId}",
                Map.of("userId", id));
    }

    public static UserDto getUserDto() {
        return userDto;
    }
    private static void setId(){
        id = RestRequest.getResponse().as(UserDto.class).getId().toString();
    }
    public static String getId() {
        return id;
    }

    private void creteResponse(UserDto userDto) {
        request.executePostRequest("/users",
                toJson(userDto));
    }
}
