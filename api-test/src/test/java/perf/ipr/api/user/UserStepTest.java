package perf.api.user;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perf.api.user.service.UserDbService;
import perf.api.user.service.UserService;
import perf.ipr.MySpringTestFrameworkApp;

import static perf.api.user.common.StatusChecker.checkStatus;

@Owner("Авилова")
@SpringBootTest(classes = MySpringTestFrameworkApp.class)
public class UserStepTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDbService userDbService;

    @Test
    @Description("Проверка создания пользователя")
    public void checkCreateUser() {
        userService.createUser();
        checkStatus(200);
        userDbService.checkUserData();
    }

    @Test
    @Description("Проверить создание дубликата")
    public void checkCreateDuplicateUser() {
        userService.createUser();
        checkStatus(200);
        userService.createDuplicateUser();
        checkStatus(409);
        userDbService.checkUserData();
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkUpdateUser() {
        userService.createUser();
        checkStatus(200);
        userService.updateUser();
        checkStatus(200);
        userDbService.checkUserData();
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkGetUserById() {
        userService.createUser();
        checkStatus(200);
        userService.getUserById();
        checkStatus(200);
    }

    @Test
    @Description("Проверить изменение пользователя")
    public void checkDeleteUserById() {
        userService.createUser();
        checkStatus(200);
        userService.deleteUserById();
        checkStatus(200);
        userDbService.checkDeletedUserData();
    }
}
