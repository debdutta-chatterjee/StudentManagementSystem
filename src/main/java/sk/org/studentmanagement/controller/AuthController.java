package sk.org.studentmanagement.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.User;
import sk.org.studentmanagement.service.UserService;

@Controller
@AllArgsConstructor
public class AuthController
{
    private UserService userService;

    @GetMapping("/index")
    public String home()
    {
        return "index";
    }

    @GetMapping("/registerUser")
    public String showRegistrationForm(Model model)
    {
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "registerUser";
    }

    @PostMapping("/registerUser/save")
    public String registration(
            @ModelAttribute("user") @Valid UserDto userDto,
            BindingResult result, Model model
            )
    {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser!= null &&existingUser.getEmail()!=null && !existingUser.getEmail().isEmpty())
        {
            result.rejectValue("email","","Account exists for the email.");
        }

        if(result.hasErrors())
        {
            model.addAttribute("user",userDto);
            return "/registerUser";
        }

        userService.saveUser(userDto);
        return  "redirect:/registerUser?success";
    }
}

