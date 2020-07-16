package tms.lesson39.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tms.lesson39.domain.Phone;
import tms.lesson39.domain.User;

public interface PhoneRepository  extends JpaRepository<Phone,Long> {
    @Query(value = "from User  where id=id")
    User findById(@Param("id") long id);
}
