<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<title>Home page</title>
</head>
<body>
<center>
<pre>
		<h2>${message }</h2>
		 
  		<h4>${loggedin }</h4>
  		
  		<h3>${denied }</h3>
 
     
 <a href="addstudent">Add Student</a>  <a href="showStudent">Show Student</a>  <a href="searchStudent">Search Student</a>
</pre>
</center>
</body>

</html>