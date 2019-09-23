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
<div align="center" style="color:blue">

<center>

<table align="center">
<tr>
<td>Friend Name :<td>
<td>${friend.friend_name}</td>
</tr>

<tr>
<td>Vehicle Number :<td>
<td>${friend.vehicle_number}</td>
</tr>

<tr>
<td>Email :<td>
<td>${friend.email}</td>
</tr>

<tr>
<td>Contact :<td>
<td>${friend.contact}</td>
</tr> 

</table>
</center>
</div>
</body>
</html>