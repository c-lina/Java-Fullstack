package com.revature.DAOs;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements  EmployeeDAOInterface{
    @Override
    public Employee insertNewEmployee(Employee emp) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            //create our SQL statement
            String sql = "INSERT INTO employees(first_name, last_name, role_id_fk) VALUES(?, ?, ?)";

            //use PreparedStatement to fill in the values of our variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //use the .set() methods to fill in the values
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getRole_id_fk());

            //Now that we've filled in the values, we can send the command to the DB
            ps.executeUpdate();
            //NOTE: executeUpdate is used with INSERTS, UPDATES, and DELETES
                // ...while executeQuery is used with SELECTS

            //We can then return the new Employee object (we can just use the method parameter)
            return emp;

            //TODO: you could get the emp from the DB but it would be a bit more work
            //we would need some other getBy__ method for employees, then return that
        }
        catch(SQLException e) {
            e.printStackTrace(); //tells us what went wrong
            System.out.println("Couldn't insert employee");
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        //We need to open a connection to the DB
        try(Connection conn = ConnectionUtil.getConnection()) {
            //SQL Spring - this one is easier since there are no variables
            String sql = "SELECT * FROM employees";

            //We can use a Statement object instead of PreparedStatement since there are no variables
            Statement s = conn.createStatement();

            //Execute the query, saving the results in a ResultList
            ResultSet rs = s.executeQuery(sql);

            //We need an ArrayList to store our employees
            ArrayList<Employee> employees = new ArrayList<>();

            //Loop through ResultSet with rs.next()
            //rs.next() will return false when there are no more rows in the ResultList (breaks our loop)
            while(rs.next()) {

                //For every Employee found, add it to ArrayList
                //We will need to instantiate a new Employee object for each row in the ResultSet
                //We can get each piece of Employee data with rs.get____ methods

                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        null //TODO: we can use our getRoleByID method to fill this Role object!
                );

                //let's use RoleDAO.getRoleById() to add the Role to our employee
                RoleDAO rDAO = new RoleDAO();
                Role role = rDAO.getRoleById(rs.getInt("role_id_fk"));
                //"Get a new Role by using the role_id_fk from the DB"

                //Now that we have the Role, we can set it in our Employee
                e.setRole(role);

                //Now, we can finally add the Employee to our ArrayList
                employees.add(e);

            } // end of while loop

            //when the while loops break, we can finally return the full ArrayList
            return employees;
        }
        catch(SQLException e) {
            e.printStackTrace(); //tells us what went wrong
            System.out.println("Couldn't get an array of all employees");
        }
        return null;
    }
}
