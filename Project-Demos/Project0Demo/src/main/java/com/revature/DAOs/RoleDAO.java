package com.revature.DAOs;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {

        //Try to open a Connection to the DB
        try(Connection conn = ConnectionUtil.getConnection()) {
            //A string that represents our SQL query
            //Note the '?', which means it's a variable we need to fill in
            String sql = "SELECT * FROM roles WHERE role_id = ?";

            //We need a PreparedStatement to fill in the variable (id)
            //It takes the SQL string we made above
            PreparedStatement ps = conn.prepareStatement(sql);

            //We can now use the id parameter to set the variable with ps.set() methods
            //parameterIndex means the first ? in the string (which ? do you want to set)
            ps.setInt(1,id);

            //Execute the query, save the results in ResultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the PreparedStatement

            //Extract the data from the ResultSet into a Role object
            //"if there is a value in the next index of the results set..."

            if(rs.next()) {
                //Extract the data into Java Role object! Using the all-args constructor
                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );
                //Return the new role!
                return role;

            }

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't get Role by ID");
        }

        return null;
    }

    @Override
    public int updateRoleSalary(int id, int newSalary) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            //SQL statement
            String sql = "UPDATE roles SET role_salary = ? WHERE role_id = ?";

            //Create a PreparedStatement to fill in the variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //ps.set() to set the variable values
            ps.setInt(1, newSalary);
            ps.setInt(2, id);

            //execute the update
            ps.executeUpdate();

            //return the new salary
            return newSalary;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update salary");
        }
        return 0;
    }
}
