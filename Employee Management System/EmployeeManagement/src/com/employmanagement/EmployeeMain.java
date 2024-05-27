package com.employmanagement;

import java.util.Scanner;

public class EmployeeMain {
	
	public static void main(String args[]) {
		
		EmployeeInterface dao=new EmployeeClass();
		
		System.out.println("Welcome to Employee Management Application");
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("1.Add Employee");
			System.out.println("2.Show all Employee");
			System.out.println("3.Show Employee based on id");
			System.out.println("4.Update the employee");
			System.out.println("5.Delete the employee");
			
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Employee emp=new Employee();
				System.out.println("Enter ID:");
				int id=sc.nextInt();
				System.out.println("Enter name:");
				String name=sc.next();
				System.out.println("Enter salary:");
				double salary=sc.nextDouble();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				dao.createEmployee(emp);
				break;
				
			case 2:
				dao.showAllEmployee();
				break;
				
			case 3:
				System.out.println("Enter id to show the details:");
				int empid=sc.nextInt();
				dao.showEmployeeBasedonId(empid);
				break;
				
			case 4:
				System.out.println("Enter id to update the details");
				int eid=sc.nextInt();
				System.out.println("Enter name to update the details");
				String ename=sc.next();
				dao.updateEmployee(eid, ename);
				break;
				
			case 5:
				System.out.println("Enter the id to delete");
				id=sc.nextInt();
				dao.deleteEmployee(id);
				break;
				
			case 6:
				System.out.println("Thank you for using our Application");
				
				default:
					System.out.println("Enter valid choice!");
					break;
			
			}
		}
		while(true);
	}
	

}
