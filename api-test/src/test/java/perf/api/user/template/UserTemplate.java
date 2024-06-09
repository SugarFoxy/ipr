package perf.api.user.template;

import org.springframework.stereotype.Component;
import perf.api.user.dto.UserDto;

import java.time.LocalDateTime;

@Component
public class UserTemplate {
    private static String email;
    public static UserDto getCorrectUserData(){
        email = LocalDateTime.now() + "user@mail.ru";
        return UserDto.builder()
                .email(email)
                .name("Трус")
                .build();
    }

    public static UserDto getDuplicateUserData() {
        return UserDto.builder()
                .email(email)
                .name("Балбес")
                .build();
    }

    public static UserDto getNullUserData() {
        return UserDto.builder()
                .build();
    }

    public static UserDto getUpdateUserData() {
        return UserDto.builder()
                .email(LocalDateTime.now() + "user@mail.ru")
                .name("Бывалый")
                .build();
    }
}
