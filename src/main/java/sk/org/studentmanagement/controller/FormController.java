package sk.org.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.org.studentmanagement.model.UserForm;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController
{
    //http://localhost:8080/register
    @GetMapping("register")
    public String userRegistrationPage(Model model)
    {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);

        List<String> listProferssion = Arrays.asList("Developer","Tester","Architect");
        model.addAttribute("listProfession",listProferssion);
        return "register-form";
    }

    @PostMapping("register/save")
    public String submitForm(Model model,
        @ModelAttribute("userForm") UserForm form
    )
    {
        model.addAttribute("userForm",form);
        return "register-success";
    }
}
