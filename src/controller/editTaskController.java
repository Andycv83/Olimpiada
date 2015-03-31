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
/*
        String forward="";
        String action = request.getParameter("action");

        	if (action.equalsIgnoreCase("EDIT")){
        		
            forward = EDIT;
            
            int id = Integer.parseInt(request.getParameter("id"));
            Task task = dbs.getTaskById(id);
            request.setAttribute("task", task);
        }
        
        else {
            forward = EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
*/        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
/*		String forward="";
        String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("EDIT")){
    		
            forward = EDIT;
            
            int id = Integer.parseInt(request.getParameter("id"));
            Task task = dbs.getTaskById(id);
            request.setAttribute("task", task);
		}else {
            forward = EDIT;
        }
		
		
		
		Task task = new Task();
		
        task.setId(Integer.parseInt(request.getParameter("id")));
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(Integer.parseInt(request.getParameter("olimpId")));
        
        String taskId = request.getParameter("id");
        
 
        	task.setId(Integer.parseInt(taskId));
            dbs.updateTask(task);
           
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask());
        view.forward(request, response);
        
*/        	
		Task task = new Task();
		
        task.setId(Integer.parseInt(request.getParameter("id")));
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(Integer.parseInt(request.getParameter("olimpId")));

            dbs.updateTask(task);
            
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask());
        view.forward(request, response);
	}
        
    }



