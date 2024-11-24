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

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private RequestDispatcher dispatcher;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	 try {
       
         String id = req.getParameter("id");

        
         if (id == null || id.isEmpty()) {
             throw new NumberFormatException("Invalid or missing employee ID.");
         }

        
         int empId = Integer.parseInt(id);

       
         EmpService service = new EmpService();
         int result = service.deleteEmp(empId);

        
         resp.setContentType("text/html");
         PrintWriter print = resp.getWriter();

         if (result > 0) {
            
             dispatcher = req.getRequestDispatcher("display"); 
             dispatcher.forward(req, resp);
         } else {
             
             print.write("<h1>Employee not found. No data deleted.</h1>");
         }
     } catch (NumberFormatException e) {
         e.printStackTrace();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}

