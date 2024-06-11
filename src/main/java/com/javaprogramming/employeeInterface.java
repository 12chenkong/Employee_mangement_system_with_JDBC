package com.javaprogramming;

public interface employeeInterface {
    //create employee
    public void createEmployee(employee em);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnId(int id);
    //update employee
    public  void updateEmployee(int id,String name);
    // delete employee
    public  void deleteEmployee(int id);
}
