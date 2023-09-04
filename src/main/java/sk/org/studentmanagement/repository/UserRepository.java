package sk.org.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.org.studentmanagement.entity.User;


public interface UserRepository extends JpaRepository<User,Long>
{
    User findByEmail(String email);
}
