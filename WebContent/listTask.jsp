<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %> 
<%@ page import="dbo.DbService" %> 
<%@ page import="object.*" %>
<%@ page import="org.sqlite.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Collection Task</title>
</head>
<body>

  	<form >
  	
    <table border=1>
       
            <tr>
                <th>id</th>
                <th>description</th>
                <th>olimpiadId</th>
                <th></th>
    <!--             <th colspan=1></th>      -->           
            </tr>
 <%		
	DbService dbs = new DbService() ;
 HttpSession session2 = request.getSession(false);
 int id = (Integer) session2.getAttribute("olimpId");
	Set<Task> tasks = dbs.getAllTask(id);
	
%>	
<%	for(Task t : tasks){ %>
		<tr>	
             <td><%=t.getId() %></td>
             <td><%=t.getDescription()%></td>
             <td><%=t.getOlimpId()%></td>
             <td>
             	<form action="/editTask.jsp">             
            
             		<input type="hidden" name="olimpId" value=<%=t.getOlimpId()%>>
        			 <input type=hidden name="taskId" value="<%=t.getId() %>">
					<input type="submit" value="edit">
			   		
				</form>	
				<form action ="/deleteTaskController" method = "GET" >  	
					
					<input type="hidden" name="taskId" value="<%=t.getId()%>">		
				    <input type="submit"  value="Delete"> 			 					    
					
                </form>	
             </td>
             			
                         
              
                   	
             
                  
       </tr>
               <% }%>
      </table>
	</form>
			<form action="addTask.jsp" method="POST" name= "Add Task">
					 <p><a href="addTask.jsp">Add Task</a></p>
			</form>
</body>
</html>