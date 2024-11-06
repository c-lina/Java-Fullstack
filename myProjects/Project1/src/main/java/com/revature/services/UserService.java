package com.revature.services;

import com.revature.DAOs.TicketDAO;
import com.revature.DAOs.UserDAO;
import com.revature.DTOs.OutgoingUserDTO;
import com.revature.models.Ticket;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<OutgoingUserDTO> getUsers() {
        List<OutgoingUserDTO> outgoingUsers = new ArrayList<>();
        List<User> userlist = userDAO.findAll();
        for(User user: userlist) {
            outgoingUsers.add(new OutgoingUserDTO(user.getFirstName(), user.getLastName(), user.getUsername()));
        }

        return outgoingUsers;
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

    public String deleteUser(int id) {
        Optional<User> user = userDAO.findById(id);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("Cannot find employee id: " + id);
        }
        userDAO.deleteById(id);

        return user.get().getUsername() + " has been deleted";
    }



}
