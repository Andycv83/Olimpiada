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

@WebServlet(urlPatterns="/taskController")
public class taskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private static String INSERT_OR_EDIT = "/task.jsp";
	private DbService dbs;
	
    public taskController() {
        super();
        dbs=new DbService();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("DELETE")){
            int id = Integer.parseInt(request.getParameter("id"));
            try {
				dbs.deleteTask(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            forward = LIST_TASK;
            request.setAttribute("tasks", dbs.getAllTask());
            
            
        } else if (action.equalsIgnoreCase("EDIT")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Task task = dbs.getTaskById(id);
            request.setAttribute("task", task);
        } 
        else {
            forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Task task = new Task();
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("description"));
        System.out.println(request.getParameter("OlimpId"));
        
        task.setId(Integer.parseInt(request.getParameter("id")));
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(Integer.parseInt(request.getParameter("olimpId")));
        
        int id = Integer.parseInt(request.getParameter("id"));
        if(id == 0)
        {
            dbs.addTask(task);
        }
        else
        {
            task.setId(id);
            dbs.updateTask(task);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask());
        view.forward(request, response);
    }
}


