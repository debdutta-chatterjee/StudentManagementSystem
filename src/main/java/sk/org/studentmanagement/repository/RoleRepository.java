package sk.org.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.org.studentmanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>
{
    Role findByName(String name);
}
