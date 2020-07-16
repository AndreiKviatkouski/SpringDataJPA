package tms.lesson39.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.lesson39.domain.Address;
import tms.lesson39.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    List<User> findAllByName(String name);
    User findAllByAddress(String address);
}
