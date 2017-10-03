<%@ page language="java" import="java.util.*, hospital.model.Users" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>User Information</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
    <%
    	Users user=(Users)request.getSession().getAttribute("loginUser");
    	%>
	<h1>
		Welcome Back
		<%=user.getUserName()%></h1>
	<table border="1" class="table table-striped">
		<tr>
			<td>UserName</td>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Email</td>
			<td>Phone</td>
		</tr>
		<tr>
			<td><%=user.getUserName()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getLastName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPhone()%></td>
		</tr>
	</table>
	<br/>
	<div id="findhospital"><a href="FindHospital.jsp">Find Hospital and make appointment</a></div>
	<br/>
	<br/>
	<div id="reviewcase"><a href="FindHealthReport">Review my case</a></div>
	<br/>
	<br/>
	<div id="reviewappointment"><a href="ReviewAppointment?type=review">Review my appointment</a></div>
	<br/>
	<br/>
	<div id="userupdate"><a href="UserUpdate.jsp">Update User Information</a></div>
	<br/>
	<br/>
	<div id="Login"><a href="Login.jsp">Logout</a></div>
	<br/>
    </div>
</body>
</html>