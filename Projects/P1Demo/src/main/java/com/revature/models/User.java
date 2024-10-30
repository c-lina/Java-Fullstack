package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //This class will be registered as a Spring Bean
@Entity //This class wil be created as a table in the database (In other words, a DB ENTITY)
@Table(name = "users") //@Table lets us set properties like table name. THIS IS NOT WHAT MAKES IT A TABLE
public class User {
    @Id //This makes the field the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our PK auto-increment
    private int userId;

    /*

    @Column isn't necessary UNLESS you want to set a name or set constraints
        -nullable = NOT NULL constraint
        -unique = UNIQUE constraint
        -columnDefinition = lets you define more complex constraints (check, default)

     */

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)//set default role to user
    private String role;

    /*

    One to Many relationship (goes hand in hand with the @Many to One in pet)

    mappedBy: This refers to the @ManyToOne in Pet that maps this relationship (user)

    fetch: eager = loads dependency as soon as the app starts

    cascade: This lets us define what operations cascade down to dependent records
        -Cascade type;

     */

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> pets;


    //boilerplate-------------------------------no args, all args, getter/setter/ toString
    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
        this.role = "user";
    }

    public User(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public List<User> getPets() {
        return pets;
    }

    public void setPets(List<User> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
