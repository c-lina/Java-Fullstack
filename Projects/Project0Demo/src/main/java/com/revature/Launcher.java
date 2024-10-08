package com.revature;

import com.revature.DAOs.EmployeeDAO;
import com.revature.DAOs.RoleDAO;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        /*

        This is a "try with resources" block

        A resource is opened up within the parenthesis of the try block
        If the resource successfully creates, then the rest of the try block will run
        A big benefit of this, is that the resource will then CLOSE after the try block finishes
        This is helpful for code cleanup and preventing memory leaks

         */
        try(Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :D");
        }
        catch(SQLException e) {
            e.printStackTrace(); //this is what tells us our error message (the red text)
            System.out.println("CONNECTION FAILED D:");
        }

        //Testing my DAO methods ----------------------
        RoleDAO rDAO = new RoleDAO();
        EmployeeDAO eDAO = new EmployeeDAO();

        //test out Get Role By Id
        Role r = rDAO.getRoleById(2);
        System.out.println(r);

        //test out Insert Employee
        Employee e = new Employee("Vishnu", "Sprinivasan", 1);
        System.out.println(eDAO.insertNewEmployee(e));
        System.out.println(eDAO.getAllEmployees() + "\n");

        ArrayList<Employee> emps = eDAO.getAllEmployees();
        for(Employee emp: emps) {
            System.out.println(emp);
        }


    }
}
