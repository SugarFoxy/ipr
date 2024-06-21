package perf.ipr.api.user.service;

import perf.ipr.api.user.dto.UserDto;

public interface UserDbService {
    void checkUserData(UserDto checkingUser);
    void checkDeletedUserData(String email);
}
