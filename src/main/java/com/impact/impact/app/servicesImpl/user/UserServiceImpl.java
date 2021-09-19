package com.impact.impact.app.servicesImpl.user;

import com.impact.impact.app.models.Role;
import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;
import com.impact.impact.app.repositories.user.RoleRepository;
import com.impact.impact.app.repositories.user.UserRepository;
import com.impact.impact.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleService.getRoleById(1l);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        newUser.setUserRoles(roles);

        userRepository.save(newUser);

        return newUser;
    }
}
