package com.impact.impact.app.services.user;

import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     User saveUser(UserDto userDto);
}
