package sk.org.studentmanagement.mapper;

import sk.org.studentmanagement.dto.StudentDto;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.Student;
import sk.org.studentmanagement.entity.User;

public class UserMapper
{
    public static User mapToUser(UserDto userDto)
    {
        return new User(
                userDto.getId(),
                userDto.getFirstName() +" "+userDto.getFirstName(),
                userDto.getEmail(),
                userDto.getPassword(),
                null
        );
    }

    public static UserDto mapToUserDto(User user)
    {
        return new UserDto(
                user.getId(),
                user.getName().split(" ")[0],
                user.getName().split(" ")[1],
                user.getEmail(),
                user.getPassword()
        );
    }

}

