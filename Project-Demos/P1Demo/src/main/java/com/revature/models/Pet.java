package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity //This Class will be a DB table thanks to Spring Data JPA
@Table(name = "pets") //This lets us change the name our DB table
@Component //1 of the 4 stereotype annotations. Registers this Class as a Spring Bean
public class Pet {
    @Id //This is the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Makes a aerial incrementing PK
    private int pet_id;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String name;

    /*

    Primary Key / Foreign Key relationship (Many to One)

    fetch - defines whether the Dependency (User) is eagerly or lazily loaded
        -eager = loads dependency as soon as the app starts
        -lazy = loads dependency only when it's called

    @JoinColumn - defines the column that will be used to link these tables (PK of User)
        -We have to supply the name of the PK field that this FK is referring too

     */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId") //this links our FK to the PK in User (name names the column!)
    private User user;

    //boilerplate code----------------------------


    public Pet() {
    }

    public Pet(int pet_id, String species, String name, User user) {
        this.pet_id = pet_id;
        this.species = species;
        this.name = name;
        this.user = user;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pet_id=" + pet_id +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
