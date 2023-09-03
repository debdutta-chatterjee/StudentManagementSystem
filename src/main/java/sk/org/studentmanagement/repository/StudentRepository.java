package sk.org.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.org.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
