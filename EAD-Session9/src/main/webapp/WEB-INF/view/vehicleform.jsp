<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<mvc:form action="vehicleRegister" method="post" modelAttribute="vehicle">
<h2>Vehicle Form</h2>
<fieldset style="width:20%">
    <legend>Vehicle information:</legend>
<mvc:input path="vehicle_name" placeholder="Vehicle Name" /><mvc:errors path="vehicle_name"></mvc:errors>
<mvc:select path="type">
<mvc:option value="CYCLE">CYCLE</mvc:option>
<mvc:option value="MOTOR CYCLE">MOTOR CYCLE</mvc:option>
<mvc:option value="FOUR WHEELER">FOUR WHEELER</mvc:option>
</mvc:select>
<mvc:input path="vehicle_number" placeholder="Vehicle Number" /><mvc:errors path="vehicle_number"></mvc:errors>
<mvc:input path="emp_id" readonly="true" />
<mvc:textarea path="identification" /><mvc:errors path="identification"></mvc:errors>
<input type="submit" value="Add Vehicle"><br/>
</fieldset>
</mvc:form>
</center>


</body>
</html>