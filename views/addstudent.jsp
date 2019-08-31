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
<%
	if(request.getAttribute("message")!=null){
%>
<center><h2><%=request.getAttribute("message").toString() %><h2><center>
<%} %>
<center>
<form action = "AddStudent" method = "post">
<h2><b>Enter Student Details</b></h2>
<pre>
<label>Roll NO 	:	</label>	<input type="text" pattern="[0-9]*" name = "rollno" required>
<label>First Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "fname" required>
<label>Last Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "lname" required>
<label>Father Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "fathername" required>
<label>Email		:		</label><input type="email" name="email" required>
<label>Class		:		</label><input type="number	" name="class" required>
<label>Age		:		</label><input type="number" name="age" required>

		       <input type="submit" name="submit" value="Add Student" >
</pre>
</form>
</center>
</body>
</html>