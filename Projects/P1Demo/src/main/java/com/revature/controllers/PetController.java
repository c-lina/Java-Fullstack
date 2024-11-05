package com.revature.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.DAOs.PetDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.services.PetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Combines @Controller and @ResponseBody
@RequestMapping("/pets") //any HTTP request with "/pets" will go here
public class PetController {

    //Autowire a petService (with constructor injection) to use its method
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    //A method that inserts a new Pet into the DB
    @PostMapping //POST requests to /pets will come here
    public ResponseEntity<Pet> insertPet(@RequestBody IncomingPetDTO petDTO) {
        //send the Pet data to the service, and save the result in a Pet object
        Pet p = petService.addPet(petDTO);

        //send the new Pet back to the client with 201 - created
        return ResponseEntity.status(201).body(p);
    }

    //This method gets all pets from the DB
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        //let's return the Pets all in one line
        return ResponseEntity.ok(petService.getAllPets());
    }

    //Exception Handler for IllegalArgumentException - stole for UserController
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> HandleIllegalArgument(IllegalArgumentException e) {
        //Returns a 400 (BAD REQUEST) status code with the exception message
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //A method to get all pets by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Pet>> getPetsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(petService.getPetsByUserId(userId));
    }

}
