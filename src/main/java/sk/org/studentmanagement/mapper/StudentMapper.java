package sk.org.studentmanagement.mapper;

import sk.org.studentmanagement.dto.StudentDto;
import sk.org.studentmanagement.entity.Student;

public class StudentMapper
{
    public static Student mapToStudent(StudentDto studentDto)
    {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }

    public static StudentDto mapToStudentDto(Student student)
    {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

}

