package perf.ipr.api.user;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perf.ipr.api.user.dto.UserDto;
import perf.ipr.api.user.service.UserDbService;
import perf.ipr.api.user.service.UserRestService;
import perf.ipr.api.user.template.UserTemplate;

import static perf.ipr.api.user.common.StatusChecker.checkStatus;

@Owner("Авилова")
@SpringBootTest
public class UserStepTest {
    @Autowired
    private UserRestService userRestService;
    @Autowired
    private UserDbService userDbService;
    private UserDto userDto;
    private Response response;

    @BeforeEach
    public void init() {
        userDto = UserTemplate.getCorrectUserData();
        response = userRestService.createUser(userDto);
        userDto.setId(response.as(UserDto.class).getId());
        checkStatus(200, response);
    }

    @Test
    @Description("Проверка создания пользователя")
    public void checkCreateUser() {
        userDto.setId(userDto.getId());
        userDbService.checkUserData(userDto);
    }

    @Test
    @Description("Проверить создание дубликата")
    public void checkCreateDuplicateUser() {
        UserDto duplicate = UserTemplate.getDuplicateUserEmail(userDto.getEmail());
        response = userRestService.createUser(duplicate);
        checkStatus(409, response);
        userDbService.checkUserData(userDto);
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkUpdateUser() {
        UserDto updateUserDto = UserTemplate.getUpdateUserData();
        updateUserDto.setId(userDto.getId());
        response = userRestService.updateUser(updateUserDto);
        checkStatus(200, response);
        userDbService.checkUserData(updateUserDto);
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkGetUserById() {
        response = userRestService.getUserById(userDto.getId());
        checkStatus(200, response);
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkDeleteUserById() {
        response = userRestService.deleteUserById(userDto.getId());
        checkStatus(200, response);
        userDbService.checkDeletedUserData(userDto.getEmail());
    }
}
