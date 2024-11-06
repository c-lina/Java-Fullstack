package com.revature.DAOs;

import com.revature.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetDAO extends JpaRepository<Pet, Integer> {
    //Find all Pets by userId
    //This custom method goes into the user object to get the userId
    List<Pet> findByUserUserId(int userId);

    //"UserUserId"??
    //This property expression tells Spring to dig into the User object to find the User Id
}
