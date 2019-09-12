<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mvc" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
</head>
<body>
<a href="home">HOME</a>
<table align="center">
	<tr>
		<th>Name</th>
		<th>Father Name</th>
		<th>Email</th>
		<th>Class</th>
		<th>Age</th>
	</tr>
	<mvc:forEach var="student_list" items="${student_list}">
	<tr>
		<td>${student_list.first_name} ${student_list.last_name}</td>
		<td>${student_list.father_name}</td>
		<td>${student_list.email}</td>
		<td>${student_list.student_class}</td>
		<td>${student_list.age}</td>
	</tr>
	</mvc:forEach>
</table>
	<center><mvc:if test="${empty student_list}">
		<h4>No Records Found</h4>
	</mvc:if>
</center>
</body>
</html>