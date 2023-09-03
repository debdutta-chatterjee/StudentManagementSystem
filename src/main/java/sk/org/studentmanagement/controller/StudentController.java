package sk.org.studentmanagement.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.org.studentmanagement.dto.StudentDto;
import sk.org.studentmanagement.service.StudentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController
{
    StudentService studentService;

    //http://localhost:8080/students
    @GetMapping("/students")
    public String getAllStudents(Model model)
    {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        model.addAttribute("students",studentDtos);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model)
    {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(
            @Valid @ModelAttribute("student")StudentDto studentDto,
            BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("student",studentDto);
            return "create-student";
        }
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String newStudent(@PathVariable("studentId")Long
                                         studentId,Model model)
    {
        StudentDto studentDto = studentService.
                getStudentById(studentId);

        model.addAttribute("student",studentDto);
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId")Long
                                     studentId,
                                @ModelAttribute StudentDto studentDto,
                                BindingResult result,
                                Model model
                                )
    {
        if(result.hasErrors())
        {
            model.addAttribute("student",studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId")Long
                                     studentId)
    {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId")Long
                                        studentId,Model model)
    {
       StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("student",studentDto);
        return "view_student";
    }
}
