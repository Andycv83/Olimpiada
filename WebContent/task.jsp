<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %> 
<%@ page import="dbo.DbService" %> 
<%@ page import="object.*" %>
<%@ page import="org.sqlite.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Task</title>
</head>
<body>   

    <form method="POST" action='taskController' name="Add Task">
    
        Task ID : <input type="text" name="id"  value=<%="" %> > <br > 
        Description : <input type="text" name="description" value=<%= "" %> > <br /> 
        Olimp Id : <input type="text" name="olimpId" value=<%=""%> > <br /> 
             <input type="submit" value="Submit" />
           
    </form>
	
</body>
</html>