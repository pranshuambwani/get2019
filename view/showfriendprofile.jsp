<%@page import="com.metacube.services.Friend"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="LogOut"><button>Log Out</button></a></div>
<p align="left"><a href="Home">Home</a></p>
<center>
<% Friend friend = (Friend)request.getAttribute("friend"); %>
<table align="center">
<tr>
<td>Friend Name :<td>
<td><%=friend.getFriend_name() %></td>
</tr>

<tr>
<td>Vehicle Number :<td>
<td><%=friend.getVehicle_number() %></td>
</tr>

<tr>
<td>Email :<td>
<td><%=friend.getEmail() %></td>
</tr>

<tr>
<td>Contact :<td>
<td><%=friend.getContact() %></td>
</tr> 

</table>
</center>
</body>
</html>