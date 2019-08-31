<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ead3.Student" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="left"><a href="index.html">Home</a></p>	
<center><h3>Search Students</h3>
<pre>
<form action="Search" method="post">
<input type="text" name="value" required>
<label><input type="radio" name="column" value="firstname" checked="checked">First Name</label><label><input type="radio" name="column" value="lastname">Last Name</label>
<input type="submit" name="search" value="SEARCH">
<select name="ordered">
<option value=""></option>
<option value="class">Class Wise</option>
<option value="age">Age</option>
</select>
</form>
</pre>
<table align="center" border="1"> 
<tr>
	<th align="center">Name</th>
	<th align="center">Father Name</th>
	<th align="center">Email</th>
	<th align="center">Class</th>
	<th align="center">Age</th>
</tr>
<%
	if(request.getAttribute("student_list")!=null){
		Student st = new Student();
		ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("student_list");
		for(Student student : list){
%>
	<tr>
	<td align="center"><%=student.getFirst_name() %> <%=student.getLast_name() %></td>
	<td align="center"><%=student.getFname() %></td>
	<td align="center"><%=student.getEmail() %></td>
	<td align="center"><%=student.getClass_name() %></td>
	<td align="center"><%=student.getAge() %></td>
	</tr>
<%
		}
		} %>
</table>
</center>
</body>
</html>