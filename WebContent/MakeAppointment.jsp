<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" import="java.util.*, hospital.model.Hospital" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Appointment</title>
</head>
<body>
<h1>Schedule Appointment</h1>
	<form action="MakeAppointment?type=make" method="post">
        <table border="1" class="table table-striped">
            <tr>
            	<td>HospitalId</td>
                <td>HospitalName</td>
                <td>Address</td>
                <td>DoctorId</td>
                <td>Schedule</td>
                <td>Description</td>
            </tr> 
             <%
    			Hospital hospital=(Hospital)request.getAttribute("hospital");
    		%>
            <tr>
				<td><%=hospital.getHospitalId()%></td>
				<td><%=hospital.getHospitalName()%></td>
				<td><%=hospital.getAddress()%></td>
				<td><input type="text" name="doctorid"/></td>
				<td><input type="text" name="schedule"/></td>
				<td><input type="text" name="description"/></td>
				<input type="hidden" name="hospitalid" value=<%=hospital.getHospitalId()%>>
			</tr>
       </table>
       <input type="submit">       
       </form>
       <table border="1" class="table table-striped">
            <tr>
            	<td>DoctorId</td>
                <td>DoctorName</td>
                <td>Specialty</td>
            </tr> 
           <c:forEach items="${doctors}" var="doctor">
                <tr>
                    <td><c:out value="${doctor.getDoctorid()}" /></td>
                    <td><c:out value="${doctor.getName()}" /></td>
                    <td><c:out value="${doctor.getSpecialty()}" /></td>  
                </tr>
            </c:forEach>
       </table>
       <div id="FindHospital"><a href="FindHospital.jsp">Return to Find</a></div>
       <span id="successMessage"><b>${messages.success}</b></span>
</body>
</html>