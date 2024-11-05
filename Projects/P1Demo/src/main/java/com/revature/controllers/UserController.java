package com.revature.controllers;

import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This combines @Controller (makes a class a bean) @ResponseBean(HTTP response body -> JSON)
@RequestMapping("/users") //All HTTP Requests make to /users will hit this Controller
public class UserController {
    //TODO: We need access to the UserService

    private UserService userService;

    @Autowired //This tells Spring to dependency inject UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Post request to insert a new User
    @PostMapping //POST request to /users will come here
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        //RequestBody tells Spring to convert the JSON in the Request to a User object

        User u = userService.register(newUser);

        return ResponseEntity.ok(u); //Returns the saved User with a 200 status code - OK
    }

    //Exception Handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> HandleIllegalArgument(IllegalArgumentException e) {
        //Returns a 400 (BAD REQUEST) status code with the exception message
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //GET request to all Users
    @GetMapping //GET request to all Users
    public ResponseEntity<List<OutgoingUserDTO>> getAllUsers() {
        //not much error handling needed in a get all
        List<OutgoingUserDTO> allUsers = userService.getAllUsers();

        //send the users back with a 200 status code
        return ResponseEntity.ok(allUsers);
    }

    //GET request to get a single User by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        //Return the found User with a 200 status code
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PatchMapping("/{UserId}")
    public ResponseEntity<User> updateUserRole(@PathVariable int UserId, @RequestBody String newRole) {

        return ResponseEntity.status(202).body(userService.updateUserRole(UserId, newRole));
    }

    //Exception Handlers

    //Exception Handler for IllegalArgumentException
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        //Return a 400 Bad request
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable int userId) {
        return ResponseEntity.ok(userService.deleteByUserId(userId));
    }



}
