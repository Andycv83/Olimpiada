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
                <th><%=o.getId()%></th>                 
                <th><%=o.getName()%></th>
                <th><%=o.getStart()%></th>
                <th><%=o.getEnd()%></th>                 
              	<th>
                	<form action="/olimpiadController" method="get">
						<input type=hidden name="olimpId" value="<%=o.getId()%>">
						<input type="submit" value="edit">					
					</form>
				</th> 
				<% }%>
			</tr>	 
      <table/>    
		 <form name="add" action= "/olimpiadController" method= "post">	
		 	
                <INPUT TYPE="BUTTON" VALUE="Add new Olimpiad" ONCLICK="">    	
        </form>    	  	
</body>
</html>