<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
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
<mvc:form action="updateprofile" method="post" modelAttribute="employee">
<mvc:input path="emp_id" readonly="true"/><br>
<mvc:input path="name"/><br>
<mvc:input path="email"/><br>
<mvc:input path="contact"/><br>
<mvc:hidden path="organization_id"/>
<input type="submit" value="Update" name="submit"><input type="submit" value="Cancel" name="submit">
</mvc:form>
</div>
</body>
</html>