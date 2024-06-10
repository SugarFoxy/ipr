package perf.api.user.service;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import perf.api.user.dto.UserDto;
import perf.api.user.model.User;
import perf.api.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static perf.api.user.mapper.UserMapper.toUserDto;
import static perf.api.user.service.UserServiceImpl.getId;
import static perf.api.user.service.UserServiceImpl.getUserDto;

@Service
public class UserDbServiceImpl implements UserDbService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Step("Проверить наличие пользователя в базе")
    public void checkUserData() {
        UserDto responseDto = getUserDto();
        responseDto.setId(Long.parseLong(getId()));
        User user = userRepository.findUserByEmail(responseDto.getEmail());
        UserDto dbDto = toUserDto(user);
        assertEquals(responseDto, dbDto, "Пользователь сохранился не верно");
    }

    @Override
    @Step("Проверить отсутствие пользователя в базе")
    public void checkDeletedUserData() {
        assertFalse(userRepository.existsByEmail(getUserDto().getEmail()), "Пользователь должен быть удален");
    }
}
