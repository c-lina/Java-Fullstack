package com.revature.controllers;

import com.revature.DAOs.RoleDAO;
import com.revature.models.Role;
import io.javalin.http.Handler;

public class RoleController {

    //We need a RoleDAO to use it's methods

    RoleDAO rDAO = new RoleDAO();

    //This Handler will handle GET requests to /roles/{id}
    //NOTE: param
    public Handler getRoleByIdHandler = ctx -> {
        //TODO: make sure the id the user sent in is > 0

        //extract the path parameter from the HTTP Request URL
        //Note: pathParam() returns a String, but we need it as an int
        int role_id = Integer.parseInt(ctx.pathParam("id"));

        //instantiate a Role that holds the data from the specific role ID
        Role role = rDAO.getRoleById(role_id);

        //TODO: make sure that the Role that came back isn't null, and maybe some other checks
        if (role_id <= 0) {
            ctx.result("Role ID must be greater than zero!");
            ctx.status(400);
        }
        else if(role == null) {
            ctx.result("Role ID: " + role_id + " not found!");
            ctx.status(404);
        }
        else {
            //send the Role back in the client in an HTTP Response
            ctx.json(role);
            ctx.status(200); //200 - ok
        }

    };

    //This Handler will handler PATCH requests to roles/{id} and we'll get the new salary in the body
    public Handler updateRoleSalary = ctx -> {
        //The user will include the Role id in the path parameter
        //And they'll include the new salary in the Request body
        int role_id = Integer.parseInt(ctx.pathParam("id"));
        int salary = Integer.parseInt(ctx.body());
        //NOTE: remember, we use body() for single variables and bodyAsClass for Objects

        //TODO: user input checks

        if(salary < 20000) {
            ctx.result("Salary must be greater than 20,000");
            ctx.status(400);
        }
        else if(salary > 1000000) {
            ctx.result("Salary must be less than 1,000,000");
            ctx.status(400);
        }
        else {
            //Call the DAO, try to save the new salary in an int
            int newSalary = rDAO.updateRoleSalary(role_id, salary);

            ctx.result("Role ID: " + role_id + " salary updated to " + newSalary);
            ctx.status(200);
        }

    };
}
