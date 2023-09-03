package sk.org.studentmanagement.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.StudentDto;
import sk.org.studentmanagement.entity.Student;
import sk.org.studentmanagement.mapper.StudentMapper;
import sk.org.studentmanagement.repository.StudentRepository;
import sk.org.studentmanagement.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService
{
    StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(s  -> StudentMapper.mapToStudentDto(s))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto)
    {
        studentRepository.save(
                StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() ->
                        new RuntimeException(""));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).
                orElseThrow(() ->
                        new RuntimeException(""));
        Student savedStudent = studentRepository.save(
                StudentMapper.mapToStudent(studentDto));
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() ->
                        new RuntimeException(""));
        studentRepository.deleteById(studentId);
    }
}
