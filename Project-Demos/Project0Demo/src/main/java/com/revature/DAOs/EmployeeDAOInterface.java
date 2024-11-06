package com.revature.DAOs;

//Remember interfaces are good for laying out what methods a Class should implement

import com.revature.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOInterface {
    //A method to insert a new employee
    Employee insertNewEmployee(Employee emp);
    //A method to get all employees
    ArrayList<Employee> getAllEmployees();

    //TODO: We could do delete too, but I'll leave that for you to figure out
    //(If you know how to do Update, you can do Delete)
}
