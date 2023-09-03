package sk.org.studentmanagement.service;

import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.StudentDto;

import java.util.List;

@Service
public interface StudentService
{
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudent(Long studentId);
}
