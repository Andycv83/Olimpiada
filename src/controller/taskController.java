package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/control")
public class taskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public taskController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter writer = response.getWriter();
			writer.println("<html><head><title>Hello</title></head><body>");
			writer.println("<p>Hello World!</p>");
			writer.println("<p>Current time: " + new Date(0) + "</p>");
			writer.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
