<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Add Student</title>
</head>
<body>
<p align="left"><a href="/home"> Home</a></p>
<center>
			<h3>${succes }</h3>

		<h4>Enter Student Details</h4>
		<form:form modelAttribute="student">
			<form:errors path="${Email}" />
			
				<form:label path="firstName">First Name:</form:label> 
				<form:input path="firstName" placeholder="First Name" />
				<form:errors path="firstName"/> <br/>
			
			
			
				<form:label path="lastName">Last Name:</form:label> 
				<form:input path="lastName" placeholder="Last Name" />
				<form:errors path="lastName"/><br/>
			
			
				
			
				<form:label path="fatherName">Father Name:</form:label> 
				<form:input path="fatherName" placeholder="Father Name" />
				<form:errors path="fatherName"/><br/>
			
		
			
				<form:label path="email">Email:</form:label> 
				<form:input path="email" placeholder="Email" />
				<form:errors path="email"/><br/>
			

		
				<form:label path="studentClass">Class:</form:label>
				<form:input path="studentClass" max="12" min="1" placeholder="Class"  />
				<form:errors path="studentClass"/><br/> 
		
			
			
				<form:label path="studentAge">Age:</form:label>
				<form:input path="studentAge" max="12" min="1" placeholder="Age"  />
				<form:errors path="studentAge"/> <br/>
			
			<button type="submit">Add Student</button> 
			
		</form:form>
</center>
</body>

</html>