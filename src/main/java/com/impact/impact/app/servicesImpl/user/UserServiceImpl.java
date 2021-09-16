package com.impact.impact.app.servicesImpl.user;

import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;
import com.impact.impact.app.repositories.user.UserRepository;
import com.impact.impact.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    @Override
    public User saveUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(newUser);

        return newUser;
    }
}
