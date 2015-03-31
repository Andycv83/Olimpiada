<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

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
                <th colspan=1></th>
                <th colspan=1></th>                
            </tr>
 <%		
	DbService dbs = new DbService() ;
	Set<Task> tasks = dbs.getAllTask();
%>	
<%	for(Task t : tasks){ %>
		<tr>	
             <th><%=t.getId() %></th>
             <th><%=t.getDescription()%></th>
             <th><%=t.getOlimpId()%></th>			
				
			 <th>
			    <form action="/editTask.jsp">
					<input type=hidden name="idTask" value="<%=t.getId() %>">
					<input type="submit" value="edit">
				</form>				
              </th>
              
              <th>
                <form name="delete"  action ="/deleteTaskController" method = "GET" >  	
					<td> 
					<input name="taskId" type="hidden" value="<%=t.getId()%>">		
				    <input type="submit"  value="Delete"> 			 					    
					</td> 
                </form>	   	
             </th>	
                  
       </tr>
               <% }%>
      </table>
	</form>
			<form action="addTask.jsp" method="POST" name= "Add Task">
					 <p><a href="addTask.jsp">Add Task</a></p>
			</form>
</body>
</html>