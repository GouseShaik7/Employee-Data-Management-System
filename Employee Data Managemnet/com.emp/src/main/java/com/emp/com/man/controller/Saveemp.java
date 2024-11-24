package com.emp.com.man.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.com.man.entity.Employee;
import com.emp.com.man.service.EmpService;
@WebServlet("/save")
public class Saveemp extends HttpServlet {
	private RequestDispatcher dispatcher;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String email=req.getParameter("email");
		String salary=req.getParameter("salary");
		
		int ids=Integer.parseInt(id);
		int ages=Integer.parseInt(age);
		double sal=Double.parseDouble(salary);
		
		Employee e1=new Employee(ids,name,ages,email,sal);
		
		EmpService service=new EmpService();
		int no=service.saveemp(e1);
		if(no!=0) {
		dispatcher=req.getRequestDispatcher("welcome.html");
		dispatcher.forward(req, resp);
		System.out.println("data saved");
		}
		else {
			PrintWriter print=resp.getWriter();
			print.write("<h1>Data not saved</h1>");
			}
	}
}