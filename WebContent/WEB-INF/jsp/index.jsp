<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<center><h1>Welcome To Job Portal</h1></center>
<center><img
        src="${pageContext.request.contextPath}/resources/img/bg.jpg" /> </center>
	<table align="center">
		<tr>
			<td><button><a href="register">Register</a></button></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><button><a href="editprofile">Edit User Details</a></button></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
			<td><button><a href="adminlogin">Admin</a></button></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	</div>
</body>
</html>