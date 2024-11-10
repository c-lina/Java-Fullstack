package com.revature.aspects;

import com.revature.controllers.LoginController;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Aspect
@Component
public class LoginAspect {
    @Before("execution(* com.revature.controllers.UserController.*(..)) " +
            "&& !execution(* com.revature.controllers.UserController.registerUser(..))")
    public void checkLogin() {
        if(LoginController.session == null) {
            throw new IllegalArgumentException("You must be logged to do this!");
        }
    }

    @Before("@annotation(com.revature.aspects.ManagerOnly)")
    public void checkManager() {
        if(!LoginController.session.getAttribute("role").equals("Manager")) {
            throw new IllegalArgumentException("You do not have permission to do this!");
        }
    }
}
