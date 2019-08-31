<%@page import="java.util.ArrayList"%>
<%@page import="ead3.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="left"><a href="index.html">Home</a></p>	
<center><h3>Students Details</h3></center>
<table align="center" border="1"> 
<tr>
	<th align="center">Roll No.</th>
	<th align="center">Name</th>
	<th align="center">Father Name</th>
	<th align="center">Email</th>
	<th align="center">Class</th>
	<th align="center">Age</th>
</tr>
<%
	if(request.getAttribute("student_list")!=null){
		Student st = new Student();
		ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("student_list");
		for(Student student : list){
%>
	<tr>
	<td align="center"><%=student.getId() %></td>
	<td align="center"><%=student.getFirst_name() %> <%=student.getLast_name() %></td>
	<td align="center"><%=student.getFname() %></td>
	<td align="center"><%=student.getEmail() %></td>
	<td align="center"><%=student.getClass_name() %></td>
	<td align="center"><%=student.getAge() %></td>
	<td align="center"><a href="UpdateRecord?id=<%=student.getId() %>" > Update</a></td>
	</tr>
<%
		}
		} %>
</table>
</body>
</html>