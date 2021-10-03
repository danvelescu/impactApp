package com.impact.impact.app.controllers;

import com.impact.impact.app.models.User;
import com.impact.impact.app.models.dtos.UserDtoInfo;
import com.impact.impact.app.services.user.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<UserDtoInfo> getAuthUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new ResponseEntity("user not logged", HttpStatus.FORBIDDEN);
        }
        Object principal = authentication.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        if (user != null) {
            User userDb = this.userService.getUserByUsername(user.getUsername());
            return Objects.nonNull(user) ? new ResponseEntity(new UserDtoInfo(userDb.getUsername(), userDb.getUserRoles()), HttpStatus.OK) :
                    new ResponseEntity("user not logged", HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity("user not logged", HttpStatus.FORBIDDEN);
        }
    }
}
