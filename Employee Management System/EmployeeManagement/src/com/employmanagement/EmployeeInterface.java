package com.employmanagement;

public interface EmployeeInterface  {
	
	//create  employee
	
	public void createEmployee(Employee emp);
	//show all employee
	public void showAllEmployee();
	//show employee based on id
	public void showEmployeeBasedonId(int id);
	
	//update employee
	
	public void updateEmployee(int id,String name);
	//delete employee
	
	public void deleteEmployee(int id);

}