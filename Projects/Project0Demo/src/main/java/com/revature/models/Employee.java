package com.revature.models;

//Remember, our model classes should directly mirror our DB tables
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    /*

    Employees will contain entire role objects instead of an int foreign key
    an int FK is less useful to us than an entire Role object
    If we have an entire Role object, we have access to all of the Role's DATA as well (not just int)

    */
    private Role role;

    //Another role field - just the id this time
    //This will be useful when inserting a new Employee - we can skip making a Role object when inserting employees
    private int role_id_fk;

    //boilerplate code ---------------------------

    public Employee() {

    }

    //all-args (should NOT have the FK field)

    public Employee(int employee_id, String first_name, String last_name, Role role) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //all-args minus id (SHOULD have the FK field instead of the Role object)
    //We'll be using this constructor to insert Employees only!!!!
        //no ID since it's serial. The DB will generate it for us
    public Employee(String first_name, String last_name, int role_id_fk) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role=" + role +
                ", role_id_fk=" + role_id_fk +
                '}';
    }
}
