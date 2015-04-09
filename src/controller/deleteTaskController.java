package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Task;
import dbo.HibernateService;

/**
 * Servlet implementation class deleteTaskController
 */
@WebServlet("/deleteTaskController")
public class deleteTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private HibernateService dbs;
       
    public deleteTaskController() {
        super();
        dbs = new HibernateService(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
		 HttpSession session2 = request.getSession(false);
		 int id = (Integer) session2.getAttribute("olimpId");
		    
		 Task task = new Task();			
		  	int taskId= (Integer.parseInt(request.getParameter("taskId")));                        
			dbs.deleteTask(taskId);
			forward =LIST_TASK ;
			request.setAttribute("tasks", dbs.getAllTask(id)); 
			    
            RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
 			view.forward(request, response);
	}

}
