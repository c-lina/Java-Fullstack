package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.controllers.LoginController;
import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
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

    public User login(LoginDTO loginDTO, HttpSession session) {
        Optional<User> user = userDAO.findByUsername(loginDTO.getUsername());
        if(user.isEmpty()) {
            throw new IllegalArgumentException("Your username or password is incorrect!");
        }

        if(user.get().getPassword().equals(loginDTO.getPassword())) {
            LoginController.session = session;
            LoginController.session.setAttribute("userId", user.get().getUserId());
            LoginController.session.setAttribute("firstName", user.get().getFirstName());
            LoginController.session.setAttribute("lastName", user.get().getLastName());
            LoginController.session.setAttribute("password", user.get().getPassword());
            LoginController.session.setAttribute("role", user.get().getRole());
            LoginController.session.setAttribute("ticketList", user.get().getTicketList());
            return user.get();
        }
        else {
            throw new IllegalArgumentException("Your username or password is incorrect!");
        }
    }
}
