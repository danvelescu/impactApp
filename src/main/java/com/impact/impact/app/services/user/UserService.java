package com.impact.impact.app.services.user;

import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;

public interface UserService {
    public User saveUser(UserDto userDto);
}
