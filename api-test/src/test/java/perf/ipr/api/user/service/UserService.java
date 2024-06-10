package perf.api.user.service;


public interface UserService {

    void createUser();

    void createDuplicateUser();
    void updateUser();

    void getUserById();

    void deleteUserById();
}
