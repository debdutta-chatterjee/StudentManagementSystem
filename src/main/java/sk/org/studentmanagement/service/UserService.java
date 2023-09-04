package sk.org.studentmanagement.service;

import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.User;

@Service
public interface UserService
{
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
