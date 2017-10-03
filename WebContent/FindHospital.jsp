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
<title>Find a Hospital</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
	
	<form action="FindHospital" method="post"> 
		<h1>Find a Hospital</h1>
		<div class="alert alert-info" role="alert">
		<p>
		<label class="horizontal-element" for="Search By">Search By: </label>
		<select class="horizontal-element" name="searchtype">
  			<option value ="HospitalId">HospitalId</option>
  			<option value ="HospitalName">HospitalName</option>
  			<option value="State">State</option>
  			<option value="City">City</option>
		</select>
		<input class="horizontal-element" id="searchvalue" name="searchvalue" value="${fn:escapeXml(param.searchvalue)}">
		</div>
		<input class="horizontal-element btn btn-lg btn-primary" type="submit">
		
		<br/><br/><br/>
		<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<div id="UserInfo">
		<a href="UserInfo.jsp">Return to MainPage</a>
	</div>
	<div>
	<h1>Matching Hospital</h1>
	</div>
        <table border="1" class="table table-striped">
            <tr>
                <th>HospitalId</th>
                <th>HospitalName</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip</th>
                <th>Phone</th>
                <th>OverallRating</th>
                <th>ListedHours</th>
                <th>Emergency Call</th>
                <th>Make Appointment</th>
            </tr>
            <c:forEach items="${hospitals}" var="hospital">
                <tr>
                    <td><c:out value="${hospital.getHospitalId()}" /></td>
                    <td><c:out value="${hospital.getHospitalName()}" /></td>
                    <td><c:out value="${hospital.getAddress()}" /></td>
                    <td><c:out value="${hospital.getCity()}" /></td>
                    <td><c:out value="${hospital.getState()}" /></td>
                    <td><c:out value="${hospital.getZip()}" /></td>
                    <td><c:out value="${hospital.getPhone()}" /></td>
                    <td><c:out value="${hospital.getOverallRating()}" /></td>
                    <td><c:out value="${hospital.getListofHours()}" /></td>
                    <td><a href="EmergencyCall?hospitalid=${hospital.getHospitalId()}"/>Call</a></td>
                    <td><a href="MakeAppointment?type=find&hospitalid=${hospital.getHospitalId()}"/>Make Appointment</a></td>         
                </tr>
            </c:forEach>
       </table>
    </div>
    
    <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
</body>
</html>
