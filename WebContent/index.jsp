<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="java.util.*" %> 
<%@ page import="dbo.DbService" %> 
<%@ page import="object.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head><title>Olimpiads</title></head>
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

//		Set<Olimpiad> allOlimpiad = dbs.getAllOlimpiad();
		Olimpiad a1 = new Olimpiad();
		Olimpiad a2 = new Olimpiad();
		a1.setName("olimp1");
		a1.setId(1);
		a1.setStart(new Date());
		a1.setEnd(new Date());
		a2.setName("olimp2");
		a2.setId(2);
		a2.setStart(new Date());
		a2.setEnd(new Date());
		Set<Olimpiad> allOlimpiad = new LinkedHashSet();
		allOlimpiad.add(a1);
		allOlimpiad.add(a2);
		
%>
	
<%	for(Olimpiad o : allOlimpiad){ %>
			 <tr>	
               <td><%=o.getId() %></td>
                <th><%=o.getName()%></th>
                <th><%=o.getStart()%></th>
                <th><%=o.getEnd()%></th>
                <th colspan=1>Action</th></tr>
               <% }%>
            
               	
	</body>
</html>