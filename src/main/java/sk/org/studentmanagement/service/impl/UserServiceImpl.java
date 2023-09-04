package sk.org.studentmanagement.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.Role;
import sk.org.studentmanagement.entity.User;
import sk.org.studentmanagement.mapper.UserMapper;
import sk.org.studentmanagement.repository.RoleRepository;
import sk.org.studentmanagement.repository.UserRepository;
import sk.org.studentmanagement.service.UserService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void saveUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        Role role =roleRepository.findByName("ROLE_ADMIN");
        if(role==null)
            role = isRoleExist();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Role isRoleExist()
    {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
