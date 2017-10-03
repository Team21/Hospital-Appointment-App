<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Health Report</title>
</head>
<body>
<h1>Review My Reports</h1>
        <table border="1">
            <tr>
                <th>ReportId</th>
                <th>ServiceDate</th>
                <th>Description</th>
                <th>UserId</th>
                <th>DoctorId</th>
            </tr>
            <c:forEach items="${healthreports}" var="healthReport" >
                <tr>
                    <td><c:out value="${healthReport.getReportid()}" /></td>
                    <td><fmt:formatDate value="${healthReport.getServicedate()}" pattern="MM-dd-yyyy"/></td>
                    <td><c:out value="${healthReport.getDescription()}" /></td>
                    <td><c:out value="${healthReport.getUserid()}" /></td>
                    <td><c:out value="${healthReport.getDoctorid()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>