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
<title>Review My Appointment</title>
</head>
<body>
<div class="container theme-showcase" role="main">
<h1>Review My Appointment</h1>
        <table border="1" class="table table-striped">
            <tr>
            	<th>HospitalId</th>
                <th>HospitalName</th>
                <th>Schedule on</th>
                <th>Created on</th>
                <th>Cancel Appointment</th>
            </tr>
            <c:forEach items="${appointments}" var="appointment" >
                <tr>
                    <td><c:out value="${appointment.getHospitalId()}" /></td>
                    <td><c:out value="${appointment.getHospitalName()}" /></td>
                    <td><c:out value="${appointment.getScheduletime()}" /></td>
                    <td><c:out value="${appointment.getCreattime()}" /></td>
                    <td><a href="ReviewAppointment?type=cancel&appointmentid=${appointment.getAppointmentId()}"/>Cancel Appointment</a></td>         
                </tr>
            </c:forEach>
       </table>
       <div id="UserInfo"><a href="UserInfo.jsp">Return to MainPage</a></div>
       </div>
</body>
</html>
