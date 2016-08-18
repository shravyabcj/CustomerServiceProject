<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>

	<h2>Registration Successful!!</h2>
			<label>First Name:</label>
			<label><b>${customer[0]}</b></label>
			<br>
			<label>Last Name:</label>
			<label><b>${customer[1]}</b></label>
			<br>
			<label>Email:</label>
			<label><b>${customer[2]}</b></label>
			<br>
			<label>User Name:</label>
			<label><b>${customer[3]}</b></label>
			<br><br>
			<label>Service Details</label>
			<label><b>Service ID:</b></label>
			<label><b>${customer[4]}</b></label>
			<br>
			<label><b>Service Plan:</b></label>
			<label><b>${customer[5] }</b></label>

</body>
</html>