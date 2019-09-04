<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.metacube.services.Organization"%>
<%@page import="com.metacube.services.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<div align="right"><a href="LogOut"><button>Log Out</button></a></div>
<form action="UpdateProfile" method="POST" onsubmit="return checkValidation(this)">
<h2>Edit Profile</h2>
 <fieldset style="width:20%">
    <legend>Personal information:</legend>
<% Employee emp = (Employee) request.getAttribute("employeeDetail"); %>
Employee Id : <input type="text" name="id" value="<%=emp.getEmp_id() %>" readonly="readonly">
<input type="text" value="<%=emp.getName() %>" placeholder="FULL NAME" name="empName" minlength=2 pattern="[A-Z]*[a-z]*" oninvalid="this.setCustomValidity('Invalid Name')" oninput="this.setCustomValidity('')"  required><br/>
<input type="radio" name="gender" value="male" checked>MALE</label><label><input type="radio" name="gender" value="female">FEMALE</label><br/>
<input type ="email" value="<%=emp.getEmail() %>" placeholder="Email" name="email" oninput="this.setCustomValidity('')" required><br/>
<input type ="number" value="<%=emp.getContact() %>" placeholder="Contact No." name="contact" maxlength="10" min=1 required><br/>
<select name="org">
<% List<Organization> org_lst = (ArrayList<Organization>)request.getAttribute("organization_list");

for(Organization org : org_lst){
%>
<option value="<%=org.getId() %>"><%=org.getOrganization_name() %></option>
<%} %>
</select><br/>
<input type="submit" name="submit" value="Update"><input type="submit" name="submit" value="Cancel"><br/>
</fieldset>
</form>
<% if(request.getAttribute("message")!=null){
%>
<%=request.getAttribute("message").toString() %>
<%} %>
</center>
</body>
</html>