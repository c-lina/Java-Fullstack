package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

What is the Service Layer?? It's also known as the "Business Logic Layer" because...
        -This is where we do any data processing/error handling that DOESN'T have to do with the DB or HTTP
        -DAO handles DB operations
        -Controller handles HTTP requests/responses
    -EVERYTHING in between should live in the service layer!

 */

@Service //1 of the 4 stereotype annotations. It registers the class as a Spring Bean
public class UserService {

    //We can't instantiate Interfaces like Classes... how do we get access to our DAO methods
    //DEPENDENCY INJECTION!
    private UserDAO userDAO;

    //THIS IS CONSTRUCTOR INJECTION (not setter injection, not field injection)

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //This method inserts new users into the database
    public User register(User newUser) {

        //TODO: Check that the username is unique (get user by username, see if it's null)

        //User = findByUsername(newUser.findByUsername());
        //If u is not null, throw the exception cause the username is already taken

        //Make sure that the username is present in the new User (TODO: password too)
        if(newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            //It will be the Controller's job to handle this exception
            throw new IllegalArgumentException("Username cannot be empty!");
        }

        //.save() is the JPA method to insert data into the DB. We can also use this for updates
        //It also returns the saved object, so we can just return the method call
        return userDAO.save(newUser);
    }

    //This methods gets all users from the DB
    public List<User> getAllUsers() {
        //findALL() is a JPA method that returns all records in a table
        return userDAO.findAll();

        //Not much error handing in a get all... maybe checking to see if it's empty
    }

    //This methods get a user by username
    public User getUserByUsername(String username) {

        //a little error handling
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("Please search for a valid username!");
        }

        //findByUsername is a method WE DEFINED in the UserDAO (we didn't have to implement)
        return userDAO.findByUsername(username);
    }

    //This method updates a user's role in the DB (need to supply user id and new role)
    public User updateUserRole(int userId, String newRole) {

        //TODO: error handling - make sure the role is valid (non-empty)

        //get the user by ID - if it exists, update the role, otherwise IllegalArgumentException
        User u = userDAO.findById(userId).orElseThrow(() ->
            new IllegalArgumentException("No user found with id: " + userId));
        u.setRole(newRole);

        //Save the updated user (this will go in an update, since the user id already exists)
        userDAO.save(u);

        //Return the newest version of the user object! Send it to the controller
        return u;
    }


}
