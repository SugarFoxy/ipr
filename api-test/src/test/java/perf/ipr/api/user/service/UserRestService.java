package perf.ipr.api.user.service;


import io.restassured.response.Response;
import perf.ipr.api.user.dto.UserDto;

public interface UserRestService {

    Response createUser(UserDto userDto);
    Response updateUser(UserDto userDto);

    Response getUserById(Long id);

    Response deleteUserById(Long id);
}
