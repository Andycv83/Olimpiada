<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="object.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <form method="GET" action="/editTaskController">
    		
Task ID :     <input type ="text" readonly="readonly" name = "idTask" value="<%= request.getParameter("idTask")%>" > <br > 
Description : <input type="text" name="description" > <br /> 
Olimp Id :    <input type="text" name="olimpId"> <br /> 
               <input type="submit" value="Submit" />         
    </form>
</body>
</html>