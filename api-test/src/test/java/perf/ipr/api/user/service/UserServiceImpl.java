package perf.ipr.api.user.service;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.api.core.RestRequest;
import perf.ipr.api.user.dto.UserDto;
import perf.ipr.api.user.template.UserTemplate;
import perf.ipr.api.util.GeneratorJson;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestRequest request;
    private static UserDto userDto;
    private static String id;

    @Override
    @Step("Создать нового пользователя POST /users")
    public void createUser() {
        UserServiceImpl.userDto = UserTemplate.getCorrectUserData();
        creteResponse(userDto);
        setId();
    }

    @Override
    public void createDuplicateUser() {
        creteResponse(UserTemplate.getDuplicateUserData());
    }

    @Override
    @Step("Обновить данные пользователя PATCH /users/{userId}")
    public void updateUser() {
        UserServiceImpl.userDto = UserTemplate.getUpdateUserData();
        request.executePatchRequestWithPathParam("/users/{userId}",
                GeneratorJson.toJson(userDto),
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
        var resp = RestRequest.getResponse().as(UserDto.class);
        id = resp.getId().toString();
    }
    public static String getId() {
        return id;
    }

    private void creteResponse(UserDto userDto) {
        request.executePostRequest("/users",
                GeneratorJson.toJson(userDto));
    }
}
