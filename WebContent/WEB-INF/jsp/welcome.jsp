<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<center><img
        src="${pageContext.request.contextPath}/resources/img/welcome.gif" width="50%"/ > </center>
	<table>
		<tr>
			<td>Welcome ${firstname}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="userdetails">Create Application</a></td>
			</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
			</tr>
		<tr>
		
	</table>
	
</body>
</html>