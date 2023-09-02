package sk.org.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.org.studentmanagement.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController
{
    //http://localhost:8080/variable-expression
    @GetMapping("variable-expression")
    public String variableExpression(Model model)
    {
        User user = new User("DC","DC@gmail.com",
                "ADMIN","M");
        model.addAttribute("user",user);
        return "variable-expression";
    }

    //http://localhost:8080/selection-expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model)
    {
        User user = new User("DC1","DC1@gmail.com",
                "ADMIN","M");
        model.addAttribute("user",user);
        return "selection-expression";
    }

    //http://localhost:8080/message-expression
    @GetMapping("message-expression")
    public String messageExpression()
    {
        return "message-expression";
    }

    //http://localhost:8080/link-expression
    @GetMapping("link-expression")
    public String linkExpression(Model model)
    {
        model.addAttribute("id",12);
        return "link-expression";
    }

    //http://localhost:8080/fragment-expression
    @GetMapping("fragment-expression")
    public String fragmentExpression()
    {
        return "fragment-expression";
    }

    //http://localhost:8080/users
    @GetMapping("/users")
    public String users(Model model)
    {
        User user1 = new User("DC1","DC1@gmail.com",
                "ADMIN","M");

        User user2 = new User("DC2","DC2@gmail.com",
                "ADMIN2","F");

        User user3 = new User("DC3","DC3@gmail.com",
                "ADMIN3","F");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users",users);

        return "users";
    }

    //http://localhost:8080/usersCondition
    @GetMapping("/usersCondition")
    public String idUnless(Model model)
    {
        User user1 = new User("DC1","DC1@gmail.com",
                "ADMIN","M");

        User user2 = new User("DC2","DC2@gmail.com",
                "USER","F");

        User user3 = new User("DC3","DC3@gmail.com",
                "ADMIN","F");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users",users);

        return "if-unless";
    }

    //http://localhost:8080/switch-case
    @GetMapping("/switch-case")
    public String switchCase(Model model)
    {
        User user1 = new User("DC1","DC1@gmail.com",
                "GUEST","M");


        model.addAttribute("user",user1);

        return "switch-case";
    }
}
