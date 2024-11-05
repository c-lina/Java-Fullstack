--I want to create two tables with a relationship
--I can accomplish this with primary keys and foreign keys
--TODO: another note about FKs and relationship establishment

--This schema will track employees and their roles

--roles table
CREATE TABLE roles(
  role_id serial PRIMARY KEY, --the primary key UNIQUELY IDENTIFIES each record in the table 
  --serial is an auto-incrementing int datatype - perfect for primary keys which must be uniquedemo
  --whenever we inserat a new record, the primary key will be automoatically generated and incremented for us
  
  role_title TEXT unique, --now, every role record must have a UNIQUE value for role_title
  role_salary int check(role_salary > 20000) --thanks to the check constraint, salaries cannot be < 20,000
  
  );
  
  --employees table (has a FOREIGN KEY to the roles table!) "Every Employee has a Role"
    
  CREATE TABLE employees(
    
    employee_id serial PRIMARY KEY, --remember, the PK is like a unique identifier for a record
    first_name TEXT NOT NULL, --every employee must have a value for for first name
    last_name TEXT not null,
    role_id_fk int REFERENCES roles(role_id) --This is a FOREIGN KEY. (note the "references" keyword)
    --THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN TABLES. Now every Employee has a role
    --Every Employee must have a Role, but Role doesn't necessarily depend on Employee
);


--Data Manipulation Language (DML)

--SELECT, INSERT, UPDATE, DELETE

/*

Insert some data into my tables

We specify what table and column we're inserting data into
We don't need to add values for any auto-incrementing fields (like serial primary keys)

Each paid of parathensis will be a different record in the table

*/

INSERT INTO roles(role_title, role_salary)
values('Manager', 100000), ('Cashier', 40000), ('Fry Cook', 35000), ('Marketing Director', 100000);

Select * From roles;

Insert into employees(first_name, last_name, role_id_fk)
VALUES('Spongebob', 'Squarepants', 3), ('Squidward', 'Tentacles', 2), ('Eugene', 'Krabs',1), ('Sheldon', 'Plankton', 4);

select * from employees;

update roles set role_salary = '45000' where role_title = 'Cashier';

Select * From roles;

--Select all roles where the salary is less than 100000
select * from roles where role_salary < 100000;

--This is a SUBQUERY - "Select all roles where the salary is less than the manager's salary"
select * from roles where role_salary < (select role_salary from roles where role_title = 'Manager');

--all roles with a salary between 40,0000 and 90,0000
select * from roles where role_salary > 40000 and role_salary < 90000;

--all employees with names starting with 'S' (LIKE & %)
select * from employees where first_name like '%S%';

--The % can be used to denote values that don't matter
--all employees with an 'e' in their first name
select * from employees where first_name like '%e%';

--Employees named Eugene or Sheldon (OR)
select * from employees where first_name = 'Sheldon' or first_name = 'Eugene';

--Same thing as above, but using the IN operator instead (which could be shorter, depending on # of checks)
select * from employees where first_name in ('Sheldon', 'Eugene');

--we can sat "desc" for descending order
select * from roles order by role_salary desc;

--Functions----------------------------

--scalar functions can take in up to one value, and they return one value
select now();
select upper('this text will be return in uppercase')

--Aggregate functions can take in multiple values and return one value
select avg(role_salary) from roles --gets the average
select sum(role_salary) from roles --gets the sum of all the numbers in the column
select max(role_salary) from roles --gets the max
select count(employee_id) from employees --gives us the number of records that are returned
select count(employee_id) from employees where role_id_fk = 1

--GROUP BY will merge rows together based on matching column values
select count(*) from roles group by role_salary;

--Maybe I want the role_salary as well, so the ResultSet is more clear
select role_salary, count(*) from roles group by role_salary;

--HAVING is like a WHERE clause, but it can only be used after a GROUP BY
--WHERE will not work after GROUP BY
select role_salary, count(*) from roles group by role_salary having role_salary = 100000;

--This is because the WHERE clause only works after a selection from tables (only works on raw table data)
--WHERE does NOT work on values that have been aggregated by GROUP BY - nice QC line?

--UDPATE---------------------------------

--We can use UPDATE to update records - let's say cashiers get a raise
update roles set role_salary = 45000 where role_title = 'Cashier';

--Note: the WHERE clause is very important here, otherwise we'd set every role to have the same salary

select * from roles; --NOTE; we could just run the previous select from above

--We can use DELETE to delete records - Squidward is making too much money now so we gotta fire him
delete from employees where first_name = 'Squidward';

select * from employees;

--Let's try to delete a Role (and see why it doesn't work)
delete from roles where role_title = 'Manager';
--Can't do it
--If you try to delete records or tables that are reference by other records or tables, you can't

/*
 
  Why can't we delete?
  
  This is a built in rule, to promote REFERENTIAL INTEGRITY
  "We can't have records that refer to other records that doesn't exist" - those are called orphan records
  
  
  In order for this delete ro work, we would have to say "ON DELETE CASCADE" in our foreign key column
  observe below: (not actually going to run this table creation)
    
 */

CREATE TABLE employees(
    
    employee_id serial PRIMARY KEY, 
    first_name TEXT NOT NULL, 
    last_name TEXT not null,
    role_id_fk int REFERENCES roles(role_id) on delete cascade --this also works for on update CASCADE
    
);

--we could have also done ONE DELETE SET NULL if we want to delete it but preserve it