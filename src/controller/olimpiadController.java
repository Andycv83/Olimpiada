package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

@WebServlet("/olimpiadController")

public class olimpiadController extends DispatcherServlet {
	private static final long serialVersionUID = 1L;


    public olimpiadController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("enter") !=null)super.forward("/task.jsp", request, response);
		else if(request.getParameter("registration") !=null)super.forward("/listTask.jsp", request, response);
	}

}
