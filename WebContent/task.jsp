<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Task</title>
</head>
<body>   
<%
	String login = request.getParameter("login");
	String password = request.getParameter("Password");
	String LoginIn = request.getParameter("enter");
	String register = request.getParameter("registration");
%>
	<p>Login <%=login %>  </p>
	<p>Password <%=password %>  </p>
	<p>button login <%=LoginIn %>  </p>
	<p>button register <%=register %>  </p>
	
</body>
</html>