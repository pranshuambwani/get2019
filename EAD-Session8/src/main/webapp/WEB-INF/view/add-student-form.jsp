<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<a href="home">HOME</a>
<h3>Welcome, Enter The Student Details</h3>
	<mvc:form method="post" action="addstudentdetail" modelAttribute="student">
	<pre>
<label>First Name	:		<label><mvc:input path="first_name" /><mvc:errors path="first_name"></mvc:errors>
<label>Last Name	:		<label><mvc:input path="last_name" /><mvc:errors path="last_name"></mvc:errors>
<label>Father Name	:		</label><mvc:input path="father_name" /><mvc:errors path="father_name"></mvc:errors>
<label>Email		:		</label><mvc:input path="email" /><mvc:errors path="email"></mvc:errors>
<label>Class		:		</label><mvc:input path="student_class"/><mvc:errors path="student_class"></mvc:errors>
<label>Age		:		</label><mvc:input type="number" path="age" /><mvc:errors path="age"></mvc:errors>

		       <input type="submit" value="Add Student">
		      	<h4>${message}</h4>
</pre>

</mvc:form>
</body>
</html>