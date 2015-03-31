package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.DbService;
import object.Task;

@WebServlet("/AddTaskController")
public class AddTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_TASK = "/listTask.jsp";
	private DbService dbs;

    public AddTaskController() {
        super();
        dbs=new DbService();     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Task task = new Task();
		
        task.setId(Integer.parseInt(request.getParameter("id")));
        task.setDescription(request.getParameter("description"));
        task.setOlimpId(Integer.parseInt(request.getParameter("olimpId")));

            dbs.addTask(task);
            
        RequestDispatcher view = request.getRequestDispatcher(LIST_TASK);
        request.setAttribute("tasks", dbs.getAllTask());
        view.forward(request, response);
	}

}
