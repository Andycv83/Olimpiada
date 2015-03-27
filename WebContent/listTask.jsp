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

  	<form method="GET" action='taskController' name="EDIT">
  	
    <table border=1>
       
            <tr>
                <th>id</th>
                <th>description</th>
                <th>olimpiadId</th>
                <th colspan=1>Action</th>
                <th colspan=1>Action</th>                
            </tr>
 <%		
	DbService dbs = new DbService() ;
	Set<Task> tasks = dbs.getAllTask();
%>	
<%		for(Task t : tasks){ %>
			 <tr>	
                <th><%=t.getId() %></th>
                <th><%=t.getDescription()%></th>
                <th><%=t.getOlimpId()%></th>
                <td><a href="taskController?action=edit&id=<%= t.getId() %>"/>Edit</a></td>
                <td><a href="taskController?action=delete&id=<%=t.getId() %>"/>Delete</a></td>
             </tr>
               <% }%>
      </table>
      		<tr> </tr>
      		 <p><a href="taskController?action=insert">Add Task</a></p>
	
</body>
</html>