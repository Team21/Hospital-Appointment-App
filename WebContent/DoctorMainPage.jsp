<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My patients</title>
</head>
<body>
<h1>My patients</h1>
 <table border="1" class="table table-striped">
            <tr>
                <th>UserId</th>
                <th>PatientName</th>
                <th>Description</th>
                <th>Add Report</th>
            </tr>
            <c:forEach items="${appointments}" var="appointment">
                <tr>
                    <td><c:out value="${appointment.getUserId()}" /></td>
                    <td><c:out value="${appointment.getPatientName()}" /></td>
                    <td><c:out value="${appointment.getDescription()}" /></td>
                    <td><a href="AddHealthReport.jsp?userid=${appointment.getUserId()}&doctorid=${appointment.getDoctorId()}&appointmentid=${appointment.getAppointmentId()}"/>Add Report</a></td>  
                </tr>
            </c:forEach>
       </table>
</body>
</html>