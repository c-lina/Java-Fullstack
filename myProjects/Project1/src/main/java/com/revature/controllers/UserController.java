package com.revature.controllers;

import com.revature.aspects.ManagerOnly;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.DTOs.PasswordChangeDTO;
import com.revature.models.User;
import com.revature.services.UserService;
import org.apache.coyote.Response;
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

    @ManagerOnly
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

    @ManagerOnly
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PatchMapping("/update/password/{id}")
    public ResponseEntity<String> changePassword(@PathVariable int id, @RequestBody PasswordChangeDTO newPassword) {
        return ResponseEntity.ok(userService.changePassword(id, newPassword));
    }


    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
