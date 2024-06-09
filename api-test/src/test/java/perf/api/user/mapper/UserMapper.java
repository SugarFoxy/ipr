package perf.api.user.mapper;

import perf.api.user.dto.UserDto;
import perf.api.user.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
