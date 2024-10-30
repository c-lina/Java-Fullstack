package com.revature.services;

import com.revature.DAOs.TicketDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }

    public User addUser(User newUser) {
        if(newUser.getFirstName() == null || newUser.getFirstName().isBlank()) {
            throw new IllegalArgumentException("Please enter a valid first name!");
        }
        else if (newUser.getLastName() == null || newUser.getLastName().isBlank()) {
            throw new IllegalArgumentException("Please enter a valid last name!");
        }
        else if(newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            throw new IllegalArgumentException("Please enter a valid username!");
        }
        else if(newUser.getPassword() == null || newUser.getPassword().isBlank()) {
            throw new IllegalArgumentException("Please enter a valid password!");
        }
        userDAO.save(newUser);
        return newUser;
    }



}