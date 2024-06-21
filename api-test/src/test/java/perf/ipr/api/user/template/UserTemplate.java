package perf.ipr.api.user.template;

import org.springframework.stereotype.Component;
import perf.ipr.api.user.dto.UserDto;

import java.time.LocalDateTime;

@Component
public class UserTemplate {
    public static UserDto getCorrectUserData(){
        return UserDto.builder()
                .email(LocalDateTime.now() +"user@mail.ru")
                .name("Трус")
                .build();
    }

    public static UserDto getDuplicateUserEmail(String email) {
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
