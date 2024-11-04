package com.revature.controllers;

import com.revature.DTOs.OutgoingUserDTO;
import com.revature.models.Ticket;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public ResponseEntity<List<OutgoingUserDTO>> getAllUsers() {
        List<OutgoingUserDTO> userList = userService.getUsers();
        return ResponseEntity.ok().body(userList);
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.status(201).body(newUser);
    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
