package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Olimpiad;
import object.Task;
import dbo.DbService;
import sun.rmi.server.Dispatcher;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/olimpiadController")

public class olimpiadController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String LIST_OLIMPIAD = "listOlimpiad.jsp";
	private static String LIST_TASK = "listTask.jsp";
	private DbService dbs;

	private static Logger logger = Logger.getLogger(olimpiadController.class);

	
    public olimpiadController() {
        super();
        dbs= new DbService();
        logger.info("Connect to database");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("olimpId"));
		session.setAttribute("olimpId", id);
		
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("olimps", dbs.getAllOlimpiad());
        view.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Olimpiad olimpiad = new Olimpiad();
		
		olimpiad.setId(Integer.parseInt(request.getParameter("id")));
		olimpiad.setName(request.getParameter("name"));
		olimpiad.setStart(new Date());
		olimpiad.setEnd(new Date());
		

            dbs.addOlimpiad(olimpiad);
            
        RequestDispatcher view = request.getRequestDispatcher(LIST_OLIMPIAD);
        request.setAttribute("olimps", dbs.getAllOlimpiad());
        view.forward(request, response);
	}	

}