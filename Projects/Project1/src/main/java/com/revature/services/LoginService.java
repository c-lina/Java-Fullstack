package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.DTOs.LoginDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private UserDAO userDAO;

    @Autowired
    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String login(LoginDTO loginDTO) {
        Optional<User> user = userDAO.findByUsername(loginDTO.getUsername());
        System.out.println(loginDTO);
        System.out.println(user);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("You cannot leave the username empty!");
        }

        if(user.get().getPassword().equals(loginDTO.getPassword())) {
            return("Login Successful! Welcome " + user.get().getFirstName() + " " + user.get().getLastName());
        }
        else {
            throw new IllegalArgumentException("Incorrect username or password!");
        }

    }
}