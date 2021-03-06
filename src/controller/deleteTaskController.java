package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String forward="";
        String action = request.getParameter("action");

     //   if (action.equalsIgnoreCase("DELETE")){
            int id = Integer.parseInt(request.getParameter("taskId"));
            try {
				dbs.deleteTask(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            forward = LIST_TASK;
            request.setAttribute("tasks", dbs.getAllTask());
/*       }
       else {
            forward = LIST_TASK;
        }
 */       RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

}
