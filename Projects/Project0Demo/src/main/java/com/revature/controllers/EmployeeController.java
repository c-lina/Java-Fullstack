package com.revature.controllers;

/*

The Controller Layer is where HTTP requests get sent after Javalin directs them from main() *?
It's in this layer that JSON comes in and gets translated to Java and vice versa
We'll be taking in HTTP Requests from the client, and sending back HTTP Responses
The Controller's job is to process HTTP Requests and respond to them appropriately

*/

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;

import java.util.ArrayList;
import io.javalin.http.Handler;

public class EmployeeController {
    //We need an EmployeeDAO to use the JDBC methods (get all employees, insert employee)
    EmployeeDAO eDAO = new EmployeeDAO();

    //This Handler will handle GET requests to employees
    public Handler getEmployeeaHandler = ctx -> {
        // Populate an ArrayList of Employee objects from the DAO!
        ArrayList<Employee> employees = eDAO.getAllEmployees();

        ctx.json(employees);
        ctx.status(200);
    };

    //This Handler will handle POST requests to /employees
    public Handler insertNewEmployeeHandler = ctx -> {
        //ctx.body() accesses the request body

        //We'll have JSON coming in (we're sending an Employee object through Postman)
        //We'll need to convert that JSON into a Java object before we can send it to the DAO
        //We can use ctx.bodyAsClass to do this (HTTP Request body -> Java object)
        Employee newEmployee = ctx.bodyAsClass(Employee.class);

        //Let's show off some error handling - make sure the new Employee has a first and last name
        //.trim() takes out whitespace from the beginning and end of the string
        //.isEmpty() checks to see if the string is empty
        //.isBlank() checks to see if the String is empty AND takes out whitespace
        if((newEmployee.getFirst_name() == null) || (newEmployee.getFirst_name().isBlank())) {
            ctx.result("First name cannot be empty");
            ctx.status(400); //Bad Request - the user needs to include a first name!
        }
        else if((newEmployee.getLast_name() == null) || (newEmployee.getLast_name().isBlank())) {
            ctx.result("Last name cannot be empty");
            ctx.status(400); //Bad Request - the user needs to include a last name!
        }
        else {
            //NOTE: This error handling will actually get stuffed into the Service layer

            //if the "if"s don't trigger - then the inputted Employee is good!
            Employee insertedEmployee = eDAO.insertNewEmployee(newEmployee);
            ctx.status(201); //Created - we created some data in the DB successfully
            ctx.json(insertedEmployee);
        }
    };
}
