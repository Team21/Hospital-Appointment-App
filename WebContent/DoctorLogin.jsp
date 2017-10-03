<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>Doctor Login</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
	<div class="jumbotron">
    <h1>Doctor Login</h1>
    </div>
    <form action="DoctorLogin" method="post">
    <table class="table table-striped" border = "1">
    	<tr><td>Doctor</td><td><input type="text" name="doctorid"/></td></tr>
    	<tr><td>HospitalId</td><td><input type="password" name="hospitalid"/></td></tr>
    	<tr><td><input type="submit" value="Login"/></td><td><input type="reset" value="Clear"/></td></tr>
    </table>
    </form>
    <br/>
  </body>
</html>