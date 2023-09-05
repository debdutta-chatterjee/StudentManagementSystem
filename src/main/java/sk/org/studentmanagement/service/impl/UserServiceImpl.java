package sk.org.studentmanagement.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.org.studentmanagement.dto.UserDto;
import sk.org.studentmanagement.entity.Role;
import sk.org.studentmanagement.entity.User;
import sk.org.studentmanagement.mapper.UserMapper;
import sk.org.studentmanagement.repository.RoleRepository;
import sk.org.studentmanagement.repository.UserRepository;
import sk.org.studentmanagement.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {

//        String pwd =userDto.getPassword();
//        userDto.setPassword(passwordEncoder.encode(pwd));
//        User user = UserMapper.mapToUser(userDto);
//        Role role =roleRepository.findByName("ROLE_ADMIN");
//        if(role==null)
//            role = isRoleExist();
//        List<Role> roles = new ArrayList<>();
//        roles.add(role);
//        user.setRoles(roles);
//        userRepository.save(user);
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> userDtos = userRepository.findAll()
                .stream().map
                        (u -> UserMapper.mapToUserDto(u))
                .collect(Collectors.toList());
        return userDtos;
    }

    private Role isRoleExist()
    {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
