package com.revature.services;

//Check UserService for general notes on Services

import com.revature.DAOs.PetDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    //Autowire the petDAO with constructor injection so we can use PetDAO methods

    private PetDAO pDAO;
    private UserDAO uDAO;

    @Autowired
    public PetService(PetDAO pDAO, UserDAO uDAO) {
        this.pDAO = pDAO;
        this.uDAO = uDAO;
    }

    //This method takes in a new Pet object and inserts it into the DB
    public Pet addPet(IncomingPetDTO petDTO) {
        //Another important role of the Service layer: data processing -
        //Turn the PetDTO into a Pet to send to the DAO (DAO takes Pet objects, not PetDTOs)

        //PetId will be generated (so 0 is just a placeholder)
        //species and name come from the DTO
        //user will be set with the userId in the DTO
        Pet newPet = new Pet(0, petDTO.getSpecies(), petDTO.getName(), null);

        //User the UserDAO to get a User by Id
        Optional<User> u = uDAO.findById(petDTO.getUserId());

        /*

        findById return an OPTIONAL.... What does that mean?
        It will either hold the value requested, or it won't. This helps us avoid NullPointerExceptions
        BECAUSE... we can't access the data if we don't use the .get() method
        Check out how it helps us write error handling functionality

         */

        if(u.isEmpty()) {
            throw new IllegalArgumentException("No user found with id: " + petDTO.getUserId());
        }
        else {
            //set the user object in the new Pet
            newPet.setUser(u.get());

            //save the pet to the DAO
            return pDAO.save(newPet);
        }
    }

    //Get all pets
    public List<Pet> getAllPets() {
        return pDAO.findAll();
    }

    //This method gets pets by userId
    public List<Pet> getPetsByUserId(int userId) {
        //TODO: error handling - incoming id, make sure userId exists, make sure > 0 pets returned

        return pDAO.findByUserUserId(userId);
    }
}
