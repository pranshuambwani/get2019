<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List,java.util.ArrayList,com.metacube.services.Organization" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function checkValidation(form){
	password1=form.password.value;
	password2=form.cpassword.value;
	if(password1 != password2){
		alert("\nPassword did not match: Please try again..")
		return false;
	}
	else{
		    return ture;
	}

}
</script>
</head>
<body>
<center>
<form action="Register" method="POST" onsubmit="return checkValidation(this)">
<h2>Welcome To Parking System</h2>
 
    Personal information: <br><br>

<input type="text" placeholder="FULL NAME" name="empName" minlength=2 pattern="[A-Z]*[a-z]*" oninvalid="this.setCustomValidity('Invalid Name')" oninput="this.setCustomValidity('')"  required><br/>
<input type="radio" name="gender" value="male" checked>MALE</label><label><input type="radio" name="gender" value="female">FEMALE</label><br/>
<input type ="email" placeholder="Email" name="email" oninput="this.setCustomValidity('')" required><br/>
<input type ="password" placeholder="Password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" oninvalid="this.setCustomValidity('Password should contain upper & lower case and numberic and symbol')" oninput="this.setCustomValidity('')" required><br/>
<input type ="password" placeholder="Confirm Pass" name="cpassword" required><br/>
<input type ="number" placeholder="Contact No." name="contact" maxlength="10" min=1 required><br/>

<select name="org">
<% List<Organization> org_lst = (ArrayList<Organization>)request.getAttribute("organization_list");

for(Organization org : org_lst){
%>
<option value="<%=org.getId() %>"><%=org.getOrganization_name() %></option>
<%} %>
</select><br/>
<input type="submit" value="REGISTERED"><br/>
<a href="loginPage.jsp">Login...Click Here!!</a>
</fieldset>
</form>
<% if(request.getAttribute("message")!=null){
%>
<%=request.getAttribute("message").toString() %>
<%} %>

</center> 
</body>
</html>