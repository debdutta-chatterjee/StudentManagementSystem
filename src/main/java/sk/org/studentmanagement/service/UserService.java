package sk.org.studentmanagement.service;

import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.User;

import java.util.List;

@Service
public interface UserService
{
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
