<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Health Report</title>
</head>
<body>
<h1>Add Case Description</h1>
 <table border="1" class="table table-striped">
 		<form action="AddHealthReport" method="post"> 
        <textarea id="txtArea" rows="10" cols="60" name="description"></textarea>
        <input type="hidden" name="userid" value=<%=request.getParameter("userid")%> />
        <input type="hidden" name="doctorid" value=<%=request.getParameter("doctorid")%> />
        <input type="hidden" name="appointmentid" value=<%=request.getParameter("appointmentid")%> />
        <br>
        <input type="submit">     
        </br>
        </form>
 </table>
</body>
</html>