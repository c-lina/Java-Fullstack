package com.revature;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.RoleController;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LauncherNEW {
    public static void main(String[] args) {

        //Typical Javalin setup Syntax

        Javalin app = Javalin.create().start(7700);

        /*

        We need create() to begin the instantiation of our Javalin object
        We need start() to actually start our Javalin app on a port of our choosing
        You can choose any port, but make sure it's a port that isn't being used like (5432)
        A port is like a parking space, a place for your app to sit where other apps can find it

         */

        //Very basic callable resource just for fun
        //NOTE: we sent a response from the launcher here, but Responses will really be in the Controller
        app.get("/", ctx -> ctx.result("Hello Javalin and Postman!"));

        //TODO: Instantiate Controllers
        EmployeeController ec = new EmployeeController();
        RoleController rc = new RoleController();

        //Get All Employees
        /*

        app.get is the Javalin Handler method that takes in GET requests
        In this case, it's calling the getEmployeeHandler of the EmployeeController
        So when we get a GET request to localhost:7000/employees it gets routed here

         */
        app.get("/employees", ec.getEmployeeaHandler);

        //Insert Employee
        /*

        app.post is the Javalin Handler method that takes in POST requests
        Why are we allowed to have 2 handlers that end in /employees? They have different verbs!

         */
        app.post("/employees", ec.insertNewEmployeeHandler);

        //Get Role By ID
        /*

        What is {id}? It is the path parameter.

         */
        app.get("/roles/{id}", rc.getRoleByIdHandler);

        //Update role salary
        app.patch("/roles/{id}", rc.updateRoleSalary);
    }
}
