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
<form action="vehicleRegister" method="post">
<h2>Vehicle Form</h2>
<fieldset style="width:20%">
    <legend>Vehicle information:</legend>
<input type="text" name="vehicle_name" placeholder="Vehicle Name" required>
<select name="type">
<option value="CYCLE">CYCLE</option>
<option value="MOTOR CYCLE">MOTOR CYCLE</option>
<option value="FOUR WHEELER">FOUR WHEELER</option>
</select>
<input type="text" name="vehicle_number" placeholder="Vehicle Number" required>
<input type="number" name="emp_id" value="<%=request.getAttribute("message").toString() %>" readonly="readonly">
<textarea name="identification" placeholder="Identification of Your Vehicle">
</textarea>
<input type="submit" value="Add Vehicle"><br/>
</fieldset>
</form>
</center>
</body>
</html>