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
<title>Create a User</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
	<h1>Create new account</h1>
	<form action="UserCreate" method="post">
	<div class="alert alert-info" role="alert">
		<p>
			<div class="block">
			<label for="username">UserName</label>
			<input id="username" type="text" name="username" value="">
			</div>
		</p>
		<p>
			<div class="block">
		    <label for="password">PassWord</label>
		    <input id="password" type="password" name="password" value="">
		    </div>
		</p>
		<p>
			<div class="block">
			<label for="firstname">FirstName</label>
			<input id="firstname" type="text" name="firstname" value="">
			</div>
		</p>
		<p>
			<div class="block">
			<label for="lastname">LastName</label>
			<input id="lastname" type="text" name="lastname" value="">
			</div>
		</p>
		<p>
			<div class="block">
			<label for="email">Email</label>
			<input id="email" type="text" name="email" value="">
			</div>
		</p>
		<p>
			<div class="block">
			<label for="phone">Phone</label>
			<input id="phone" type="text" name="phone" value="">
			</div>
		</p>
		<p>
			<input class="horizontal-element btn btn-lg btn-primary" type="submit">
		</p>
		</div>
	</form>
	<div id="Login"><a href="Login.jsp">Return to Login</a></div>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>