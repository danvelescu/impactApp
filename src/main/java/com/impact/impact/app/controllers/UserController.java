package com.impact.impact.app.controllers;

import com.impact.impact.app.models.dtos.UserDto;
import com.impact.impact.app.services.user.UserService;
import com.impact.impact.app.servicesImpl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/registration",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
               return new ResponseEntity<>("success", HttpStatus.OK);
    }
}