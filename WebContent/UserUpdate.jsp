<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>Update a User</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
	<h1>Update My Information</h1>
	<form action="UserUpdate" method="post">
	<div class="alert alert-info" role="alert">
		<p>
			<div class="block">
			<label class="horizontal-element" for="FirstName">FirstName</label>
			<input class="horizontal-element" id="firstname" name="firstname" value="${fn:escapeXml(param.firstname)}">
			</div>
		</p>
		<p>
			<div class="block">
			<label class="horizontal-element" for="LastName">LastName</label>
			<input class="horizontal-element" id="lastname" name="lastname" value="${fn:escapeXml(param.firstname)}">
			</div>
		</p>
		<p>
			<div class="block">
			<label class="horizontal-element" for="Email">Email</label>
			<input class="horizontal-element" id="email" name="email" value="${fn:escapeXml(param.email)}">
			</div>
		</p>
		<p>
			<div class="block">
			<label class="horizontal-element" for="Phone">Phone</label>
			<input class="horizontal-element" id="phone" name="phone" value="${fn:escapeXml(param.phone)}">
			</div>
		</p>
		<p>
			<input class="horizontal-element btn btn-lg btn-primary" type="submit">
		</p>
		</div>
	</form>
	<div id="UserInfo"><a href="UserInfo.jsp">Return to MainPage</a></div>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	
	<!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </div>
</body>
</html>