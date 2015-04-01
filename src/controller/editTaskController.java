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
import javax.servlet.http.HttpSession;

import object.Task;
import dbo.DbService;

@WebServlet(urlPatterns="/editTaskController")
public class editTaskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private DbService dbs;
	
    public editTaskController() {
        super();
        dbs=new DbService();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       	
		 String forward="";
		 HttpSession session2 = request.getSession(false);
		 int id = (Integer) session2.getAttribute("olimpId");
		 
		Task task = new Task();        
        task.setId(Integer.parseInt(request.getParameter("taskId")));
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(id);
        
        dbs.updateTask(task);
            
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask(id));
        view.forward(request, response);
	}
        
    }



