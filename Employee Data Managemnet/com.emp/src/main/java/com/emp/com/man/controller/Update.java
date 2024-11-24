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

@WebServlet("/update")
public class Update extends HttpServlet {
	private RequestDispatcher dispatcher;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        // Retrieve parameters from the request
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String salary = req.getParameter("salary");

        // Parse values
        int ids = Integer.parseInt(id);
        int ages = Integer.parseInt(age);
        double sal = Double.parseDouble(salary);

     
        Employee e1 = new Employee(ids, name, ages, email, sal);

      
        EmpService service = new EmpService();
        int no = service.updateEmp(e1);

        if (no > 0) {
            dispatcher = req.getRequestDispatcher("display"); 
            dispatcher.forward(req, resp);
        } else {
            PrintWriter print = resp.getWriter();
            print.write("<h1>Data not updated. Employee ID might not exist.</h1>");
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

















//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	// TODO Auto-generated method stub
////	super.doGet(req, resp);
//	String id=req.getParameter("id");
//	String name=req.getParameter("name");
//	String age=req.getParameter("age");
//	String email=req.getParameter("email");
//	String salary=req.getParameter("salary");
//	
//	int ids=Integer.parseInt(id);
//	int ages=Integer.parseInt(salary);
//	double sal=Double.parseDouble(salary);
//	
//	Employee e2=new Employee(ids,name,ages,email,sal);
//	EmpService service=new EmpService();
//	int no=service.updateEmp(e2);
//	if(no!=0) {
//		dispatcher=req.getRequestDispatcher("update.html");
//		dispatcher.forward(req, resp);
//		System.out.println("data updated");
//		}
//		else {
//			PrintWriter print=resp.getWriter();
//			print.write("<h1>Data not updated</h1>");
//			}
//	
//}
}
