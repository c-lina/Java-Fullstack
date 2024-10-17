package com.revature.DAOs;

//This DAO will handle login (select where employee_id = ? and first_name = ?)
//We should have had username/password columns in the employees table,
    //but Ben didn't think we would get this far in week 3 and Ben doesn't want to do a major refactor

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {
    public Employee login(int employee_id, String first_name) {
        try(Connection conn = ConnectionUtil.getConnection()) {

            //Create our SQL String
            String sql = "SELECT * FROM EMPLOYEES WHERE employee_id = ? and first_name = ?";

            //PrepareStatement and fill in the blanks
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, employee_id);
            ps.setString(2, first_name);

            ResultSet rs = ps.executeQuery();

            //Instantiate a RoleDAO to get the getRoleById method

            if(rs.next()) {
                RoleDAO rDAO = new RoleDAO();

                Employee emp = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rDAO.getRoleById(rs.getInt("role_id_fk"))
                );
                return emp;
            }


        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't login user");
        }

        return null;
    }
}
