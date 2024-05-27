package com.employmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeClass implements EmployeeInterface {
	
	Connection con;

	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		con=DBConnection.createDBConnection();
		String query="insert into employee values(?,?,?)";
		try {
			PreparedStatement pt=con.prepareStatement(query);
			pt.setInt(1, emp.getId());
			pt.setString(2, emp.getName());
			pt.setDouble(3, emp.getSalary());
			int cnt=pt.executeUpdate();
			if(cnt!=0) {
				System.out.println("Emplpoyee Inserted Successfully");
			}
	
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		
		con=DBConnection.createDBConnection();
		String query="select * from employee";
		
		try {
			
			Statement st=con.createStatement();
			ResultSet result=st.executeQuery(query);
			while(result.next()) {
				int id = result.getInt("id");
                String name = result.getString("name");
                String salary = result.getString("salary");
                // Use correct format specifiers
                System.out.printf("ID: %d, Name: %s, Salary: %s%n", id, name, salary);
                
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void showEmployeeBasedonId(int id) {
		// TODO Auto-generated method stub
		
		con=DBConnection.createDBConnection();
		String query="select * from employee where id="+id;
		
		try {
			Statement st=con.createStatement();
			ResultSet result=st.executeQuery(query);
			
			while(result.next()) {
				int emid = result.getInt("id");
                String name = result.getString("name");
                String salary = result.getString("salary");
                // Use correct format specifiers
                System.out.printf("ID: %d, Name: %s, Salary: %s%n", emid, name, salary);
                
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="update employee set name=? where id=?";
		try {
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1,name);
			pt.setInt(2, id);
			int cnt=pt.executeUpdate();
			if(cnt!=0)
				System.out.println("Employee Details updated successfully");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		con=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		
		try {
			PreparedStatement pt=con.prepareStatement(query);
			pt.setInt(1, id);
			int cnt=pt.executeUpdate();
			if(cnt!=0){
				
				System.out.println("Employee deleted successfully"+id);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
