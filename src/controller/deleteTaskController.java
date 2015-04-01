package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Task;
import dbo.DbService;

/**
 * Servlet implementation class deleteTaskController
 */
@WebServlet("/deleteTaskController")
public class deleteTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private DbService dbs;
       
    public deleteTaskController() {
        super();
        dbs=new DbService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		Task task = new Task();
			
			int id= (Integer.parseInt(request.getParameter("taskId")));
            task.setId(id);
  */           int olimpId = (Integer.parseInt(request.getParameter("olimpId")));
            
           
				dbs.deleteTask(Integer.parseInt(request.getParameter("taskId")));
	
/*       }
       else {
            forward = LIST_TASK;
        }
 */         RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
 			request.setAttribute("tasks", dbs.getAllTask(Integer.parseInt(request.getParameter("olimpId"))));
 			view.forward(request, response);
	}

}
