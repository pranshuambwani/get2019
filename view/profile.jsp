<%@page import="com.metacube.services.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<a href="Friends"><button>Show Friends</button></a><div align="right"><a href="LogOut"><button>Log Out</button></a></div>

<h3>Profile</h3>
<% Employee emp = (Employee) request.getAttribute("employeeDetail"); 
%>
	Employee Id : 	<%=emp.getEmp_id() %><br>
	Name		:	<%=emp.getName() %><br>
	Email		:	<%=emp.getEmail() %><br>
	Contact		:	<%=emp.getContact() %><br>
	<a href="UpdatePage"><button>Edit Profile</button></a>

</center>
</body>
</html>