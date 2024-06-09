package perf.ipr.api.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import perf.ipr.api.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}
