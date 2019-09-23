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

	<center>
<mvc:form action="Register" method="POST" modelAttribute="employee">
<h2>Welcome To Parking System</h2>
 <fieldset style="width:20%">
    <legend>Personal information:</legend>

<mvc:input placeholder="FULL NAME" path="name" pattern="[A-Z]*[a-z]*" oninvalid="this.setCustomValidity('Invalid Name')" oninput="this.setCustomValidity('')"/><mvc:errors path="name"></mvc:errors><br/>
<label><mvc:radiobutton path="gender" value="male"/>MALE</label>
<label><mvc:radiobutton path="gender" value="female"/>FEMALE</label><mvc:errors path="gender"></mvc:errors><br/>
<mvc:input type ="email" placeholder="Email" path="email" /><mvc:errors path="email"></mvc:errors><br/>
<mvc:password placeholder="Password" path="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" oninvalid="this.setCustomValidity('Password should contain upper & lower case and numberic and symbol')" oninput="this.setCustomValidity('')"/><mvc:errors path="password"></mvc:errors><br/>
<mvc:password placeholder="Confirm Pass" path="cpassword" /><mvc:errors path="cpassword"></mvc:errors><br/> 
<mvc:input type ="number" placeholder="Contact No." path="contact" /><mvc:errors path="contact"></mvc:errors><br/>

<mvc:select path="organization_id">
	<mvc:options items="${orgList}" itemValue="id" itemLabel="organization_name"/>

</mvc:select>
<input type="submit" value="REGISTERED"><br/>
<a href="loginPage">Already User?Click Here</a>
</fieldset>
</mvc:form>
<h4>${message}</h4>
</center> 
</body>
</html>