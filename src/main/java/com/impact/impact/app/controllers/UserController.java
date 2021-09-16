package com.impact.impact.app.controllers;

import com.impact.impact.app.models.dtos.UserDto;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @PostMapping("/registration")
    public Response registerUser(@RequestBody UserDto userDto){

    }
}
