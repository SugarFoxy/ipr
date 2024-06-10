package perf.ipr.api.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perf.ipr.api.user.model.User;

@Repository()
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    boolean existsByEmail(String email);
}
