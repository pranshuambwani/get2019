<%@page import="java.util.List"%>
<%@page import="com.metacube.services.Friend"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="left"><a href="Home">Home</a></p><div align="right"><a href="LogOut"><button>Log Out</button></a></div>
<center>
<h3>Friends</h3>
<% List<Friend> frnd_list = (ArrayList<Friend>)request.getAttribute("frnd_list"); 
	if(!frnd_list.isEmpty()){
%>
<table align="center" border="1">
<% for(Friend friend : frnd_list) {%>
<tr>
<td><%=friend.getFriend_name() %></td>
<td><a href="FriendProfile?id=<%=friend.getFriend_id() %>">View Profile</td>
</tr>
<%} %>
</table>


<%} %>
</center>

</body>
</html>