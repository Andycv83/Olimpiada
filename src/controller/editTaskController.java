package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Task;
import dbo.DbService;

@WebServlet(urlPatterns="/editTaskController")
public class editTaskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private static String EDIT = "/editTask.jsp";
	private DbService dbs;
	
    public editTaskController() {
        super();
        dbs=new DbService();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       	
		
		Task task = new Task();
		
		int id = Integer.parseInt(request.getParameter("idTask"));        
        task.setId(id);
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(Integer.parseInt(request.getParameter("olimpId")));

       request.setAttribute("task", task); 
        
        dbs.updateTask(task);
            
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask());
        view.forward(request, response);
	}
        
    }



