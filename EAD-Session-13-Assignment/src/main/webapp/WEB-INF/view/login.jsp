<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
  <h2>Student Login form</h2>
  <h3>${error }</h3>
   <form:form action="perform_login" method="post">
      <label for="email">Email:</label>
      <input type="text" placeholder="Enter email" name="username"><br/>
      <label for="pwd">Password:</label>
      <input type="password" placeholder="Enter password" name="password"><br/>
    <button type="submit">Submit</button>
 </form:form>
 </center>
</body>
</html>