package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.LoginDTO;
import com.revature.models.User;
import jakarta.servlet.http.HttpSession;
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

    public User login(LoginDTO loginDTO) {
        Optional<User> user = userDAO.findByUsername(loginDTO.getUsername());
        if(user.isEmpty()) {
            throw new IllegalArgumentException("You cannot leave the username empty!");
        }

        if(user.get().getPassword().equals(loginDTO.getPassword())) {
            return user.get();
        }
        else {
            throw new IllegalArgumentException("Your username or password is incorrect!");
        }
    }
}
