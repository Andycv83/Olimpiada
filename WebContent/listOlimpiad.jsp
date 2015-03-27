<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %> 
<%@ page import="dbo.DbService" %> 
<%@ page import="object.*" %>
<%@ page import="org.sqlite.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Olimpiad </title>
</head>
<body>

	<body>	
		
    <table border=1>
       
            <tr>
                <th>id</th>
                <th>name</th>
                <th>start</th>
                <th>end</th>
                <th colspan=1>Action</th>              
            </tr>
 <%		
	DbService dbs = new DbService() ;
	Set<Olimpiad> allOlimpiad = dbs.getAllOlimpiad();
%>	
<%		for(Olimpiad o : allOlimpiad){ %>
			 <tr>	
                <th><%=o.getId() %></th>
                <th>	<a href="listTask.jsp"><%=o.getName()%></a></th>
                <th><%=o.getStart()%></th>
                <th><%=o.getEnd()%></th>
                <th colspan=1>EDIT</th>
             </tr>
               <% }%>
      <table/>
      		<tr> </tr>
             <INPUT TYPE="BUTTON" VALUE="Add new Olimpiad" ONCLICK="button1()">    	
          	<a href="http://google.com.ua">Link</a>
      

</body>
</html>