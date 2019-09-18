<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center" style="color:blue">
	<h3>Friends</h3>
	<table border="1">
		<core:forEach items="${frnd_list}" var="friend">
		<tr>
			<td>${friend.friend_name}</td>
			<td><a href="FriendProfile?id=${friend.friend_id}">View Profile</td>
		</tr>
		</core:forEach>
	</table>
</div>
</body>
</html>