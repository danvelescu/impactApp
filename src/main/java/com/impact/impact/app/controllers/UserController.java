package com.impact.impact.app.controllers;

import com.impact.impact.app.models.Role;
import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDto;
import com.impact.impact.app.models.dtos.UserDtoInfo;
import com.impact.impact.app.services.user.UserService;
import com.impact.impact.app.servicesImpl.user.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/registration",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody UserDto userDto) throws Exception {
      User usr = userService.saveUser(userDto);
               return new ResponseEntity<>("success "+ usr.getUsername(), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) throws Exception {
        User user = userService.getUserByUsername(username);
        UserDtoInfo userDto = new UserDtoInfo(user.getUsername(), user.getUserRoles());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}