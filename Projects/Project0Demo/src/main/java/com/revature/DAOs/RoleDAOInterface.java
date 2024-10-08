package com.revature.DAOs;

import com.revature.models.Role;

import java.util.List;

/*

This interface will lay out all of the methods that RoleDao must implement
Why take this extra step? This is a great way to document what method are found in RoleDao
Imagine a DAO Class with 100 JDBC methods. - That would be really long. This is a good quick reference
 */
public interface RoleDAOInterface {
    //A method that will get Roles with their id
    Role getRoleById(int id);

    //A method to update a Role salary
    int updateRoleSalary(int id, int newSalary);

    //a hypothetical method that would return all the Roles in the database
        //List<Role> getAllRoles();

    //a hypothetical method that would inset a new Role
        //Role insertRole(Role e)
}
