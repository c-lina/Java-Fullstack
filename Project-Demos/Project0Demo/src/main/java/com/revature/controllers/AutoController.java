package com.revature.controllers;

import com.revature.DAOs.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

//This Controller is for handling authentication functionalities (like login/register)
//In the future, Register user would be here too, but for now we have is enough

public class AutoController {

    //Instantiate the AuthDAO so we can try to log in a user
    AuthDAO aDAO = new AuthDAO();

    //HttpSession object to store user info after successful login
    //This object will be initialized upon successful login, letting a user access the app

    public static HttpSession ses;

    //"Initialized"? JUst means it will be given a value

    //login will be a POST request, since we're sending a username and password (id and name for this)

    public Handler loginHandler = ctx -> {
        //Extract the Request body as a LoginDTO object
        LoginDTO lDTO = ctx.bodyAsClass(LoginDTO.class);

        //Use the LoginDTO data to send to the DAO and try to log in!
        Employee loggedInEmployee = aDAO.login(lDTO.getEmployee_id(), lDTO.getFirst_name());

        //The DAO will either return an Employee (login success!) or null (login fail!)
        if(loggedInEmployee != null) {
            //Create a session object
            ses = ctx.req().getSession();

            //Store user info in the Session with the setAttribute() Method
            ses.setAttribute("first_name", loggedInEmployee.getFirst_name());
            ses.setAttribute("last_name", loggedInEmployee.getLast_name());

            //NOTE: we could have stored any kind of info in the Session like this (id? role?)

            /*

            Foreshadowing for P1: Each Employee will have a role of employee or manager
            Managers will be able to do things that Employees can't
            Their identity as a manager or employee will be stored in their session after login
            Which will let us control what functionalities they can or can't access

             */

            //ok...how do we access the data we stored in a session? .getAttribute()
            System.out.println("Employee first name: " + ses.getAttribute("first_name"));

            //send a success message
            ctx.status(200);
            ctx.result("Login Successful! Welcome, " + ses.getAttribute("first_name") );

        }
        else {
            //If login fails, a good status code is 401 - Unauthorized
            ctx.status(401);
        }
    };

}
