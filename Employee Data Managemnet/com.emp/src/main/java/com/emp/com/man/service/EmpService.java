package com.emp.com.man.service;

import java.sql.Connection;
//import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emp.com.man.entity.Employee;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
//import com.mysql.cj.xdevapi.Statement;

public class EmpService {
	
	private static String url = "jdbc:mysql://localhost:3306/emp";
	private static String user="root";
	private static String password="root";

	  private static Connection getConnection() throws SQLException, ClassNotFoundException {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(url, user, password);
	    }

		
	public int saveemp(Employee employee) {
		int no=0;
		String sql="insert into employee values(?,?,?,?,?)";
		 try {Connection con = getConnection(); 
	          PreparedStatement pstm = con.prepareStatement(sql);
	          pstm.setInt(1, employee.getId());
				pstm.setString(2, employee.getName());
				pstm.setInt(3, employee.getAge());
				pstm.setString(4, employee.getEmail());
				pstm.setDouble(5, employee.getSalary());
				 no = pstm.executeUpdate();
				 con.close();
		 }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return no;
		
		
	}
	
	
	public List<Employee> getAll() {
		List<Employee> l1=new ArrayList<Employee>();
		String sql="select * from employee";
		try {
			Connection con = getConnection();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				double salary=rs.getDouble(5);
				l1.add(new Employee(id,name,age,email,salary));
			}
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return l1;
	}
	
	
	
	
	public int updateEmp(Employee employee) {
	    int no = 0;
	    String sql = "UPDATE employee SET name = ?, age = ?, email = ?, salary = ? WHERE id = ?";
	    try {
	        Connection con = getConnection(); 
	        PreparedStatement pstm = con.prepareStatement(sql);
	        
	       
	        pstm.setString(1, employee.getName());
	        pstm.setInt(2, employee.getAge());
	        pstm.setString(3, employee.getEmail());
	        pstm.setDouble(4, employee.getSalary());
	        pstm.setInt(5, employee.getId()); 
	        
	       
	        no = pstm.executeUpdate();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return no; 
	}

	
	
	public int deleteEmp(int id) {
	    int no = 0;
	    String sql = "DELETE FROM employee WHERE id = ?";
	    try {
	        Connection con = getConnection(); // Assumes getConnection() is implemented correctly
	        PreparedStatement pstm = con.prepareStatement(sql);
	        
	        // Set the ID parameter
	        pstm.setInt(1, id);
	        
	        // Execute the delete query
	        no = pstm.executeUpdate();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log exception
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace(); // Log exception if JDBC driver is not found
	    }
	    return no; // Returns number of rows deleted
	}



	

	
	
	
}
