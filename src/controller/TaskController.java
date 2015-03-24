package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.DbService;

/**
 * Servlet implementation class TaskController
 */
@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String ADD_OR_EDIT = "/task.jsp";
    private static String LIST_USER = "/listTask.jsp";
    private static String LIST_OLIMPIAD = "/listOlimpiad.jsp";
    private DbService dbs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskController() {
        super();
        dbs= new DbService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward="";
        String action = request.getParameter("action");
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
