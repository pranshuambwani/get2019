<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center" style="color:green">

	Employee Id : 	${emp.emp_id}<br>
	Name		:	${ emp.name}<br>
	Email		:	${emp.email}<br>
	Contact		:	${emp.contact}<br>
</div>


</body>
</html>