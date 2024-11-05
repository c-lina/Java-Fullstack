package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    //No more Javalin! Which means no more endpoint handlers. It's all done in the controller

    //Let's make a method that return a list of cars from a fake database

    @GetMapping //This annotation takes in any HTTP GET request ending in /cars
    public ResponseEntity<String> getAllCars() {
        return ResponseEntity.status(200).body("Jeep, Acura, Car, Another Car");
    }

    //Now here's a method that returns a single car with a hypothetical ID passed as a path variable
    @GetMapping("/{id}") //This annotation takes in any HTTP GET Requests ending in /cars/{some ID}
    //@PathVariable lets you extract variables from the URL path
    public ResponseEntity<String> getCarById(@PathVariable int id){

        //TODO: could check for datatype mismatch in the path variable
        //catch MethodArgumentTypeMismatchException and return 400 etc.

        //We can easily error handle using ResponseEntity!

        if(id <= 0){
            return ResponseEntity.status(400).body("ID must be greater than 0");
        }

        //If the user send in a number > 0, send them back their car and a 200
        return ResponseEntity.ok("Returned car number " + id );
        //^using shorthand for ResponseEntity.status(200).body("blah blah")
    }

    //This method will take in car data and insert it into our fake database
    @PostMapping //This annotation takes in any HTTP POST Requests ending in /cars
    public ResponseEntity<String> insertCar(@RequestBody String car){

        //TODO: make sure the car is valid
        //NOTE: no need to handle input datatype mismatches since we already have an ExceptionHandler below

        //If the car is valid, send a 201 (Created) status code
        return ResponseEntity.status(201).body("Added car: " + car);

    }

    //This method will take in car data to send to some other user
    @PostMapping("/toUser")
    public ResponseEntity<String> sendCar(@RequestBody String car){

        //TODO: make sure the car valid checks

        return ResponseEntity.ok("Sent car: " + car + " to the customer");

    }


}
