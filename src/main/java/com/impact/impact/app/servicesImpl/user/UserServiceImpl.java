package com.impact.impact.app.servicesImpl.user;

import com.impact.impact.app.models.Role;
import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;

import com.impact.impact.app.repositories.user.UserRepository;
import com.impact.impact.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public User saveUser(UserDto userDto) throws Exception {

        if(userRepository.getUserByUsername(userDto.getUsername()).isPresent()){
            System.out.println(userDto.getPassword());
            throw new Exception("Username "+userDto.getUsername()+" already exists");
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleService.getRoleById(2l);
        List<Role> roles = new ArrayList<>();


        roles.add(role);
        newUser.setUserRoles(roles);

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        return userRepository.getUserByUsername(username).orElseThrow(
                () -> new Exception("User with username  " + username +" not exists")
        );
    }
}
