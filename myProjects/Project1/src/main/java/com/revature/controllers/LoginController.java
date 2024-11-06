package com.revature.controllers;

import com.revature.DTOs.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok().body(loginService.login(loginDTO));
    }

    //Exception Handling
    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
