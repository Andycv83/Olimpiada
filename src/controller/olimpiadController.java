package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Olimpiad;
import dbo.DbService;
import sun.rmi.server.Dispatcher;

@WebServlet(urlPatterns="/olimpiadController")

public class olimpiadController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String LIST_OLIMPIAD = "/listOlimpiad.jsp";
	private DbService dbs;


    public olimpiadController() {
        super();
        dbs= new DbService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("id");
		System.out.println("HELLO");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

	}
}