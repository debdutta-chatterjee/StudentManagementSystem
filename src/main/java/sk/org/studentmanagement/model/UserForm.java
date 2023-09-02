package sk.org.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm
{
    private String name;
    private String email;
    private String address;
    private String password;
    private String gender;
    private boolean married;
    private String profession;
}
