package com.emp.com.man.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.com.man.entity.Employee;
import com.emp.com.man.service.EmpService;

@WebServlet("/display")
public class Display extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	EmpService service=new EmpService();
	List<Employee> e1=service.getAll();
	
	resp.setContentType("html");
	PrintWriter print=resp.getWriter();
	
	 print.print("<!DOCTYPE html>");
     print.print("<html>");
     print.print("<head>");
     print.print("<meta charset='UTF-8'>");
     print.print("<title>Employee List</title>");
     print.print("<style>");
     print.print("table { width: 80%; margin: 20px auto; border-collapse: collapse; text-align: left; }");
     print.print("th, td { border: 1px solid #ddd; padding: 10px; }");
     print.print("th { background-color: #f4f4f4; }");
     print.print("tr:nth-child(even) { background-color: #f9f9f9; }");
     print.print("</style>");
     print.print("</head>");
     print.print("<body>");
     
     print.print("<h2 style='text-align:center;'>Employee List</h2>");
     
     // Start of Table
     print.print("<table>");
     print.print("<thead>");
     print.print("<tr>");
     print.print("<th>ID</th>");
     print.print("<th>Name</th>");
     print.print("<th>Age</th>");
     print.print("<th>Email</th>");
     print.print("<th>Salary</th>");
     print.print("<th>Actions</th>");
     print.print("</tr>");
     print.print("</thead>");
     print.print("<tbody>");
     
	
	for(Employee employee:e1) {
		int id=employee.getId();
		String name=employee.getName();
		int age=employee.getAge();
		String email=employee.getEmail();
		double salary=employee.getSalary();
		 print.print("<tr>");
         print.print("<td>" + id + "</td>");
         print.print("<td>" + name + "</td>");
         print.print("<td>" + age + "</td>");
         print.print("<td>" + email + "</td>");
         print.print("<td>" + salary + "</td>");
         print.print("<td>");
         print.print("<a href='update.html'>Edit</a> | ");
         print.print("<form action=\"delete.html\" method=\"get\">" +
                 "<button type=\"submit\">Delete</button>" +
                 "</form>");
         print.print("</td>");
         print.print("</tr>");
     }
     
     print.print("</tbody>");
     print.print("</table>");
     
     print.print("</body>");
     print.print("</html>");
     
     // Close the writer
     print.close();	}
	
	
}

