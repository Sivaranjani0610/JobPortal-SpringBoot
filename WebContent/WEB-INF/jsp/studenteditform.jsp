<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Users</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style>
tr:nth-child(even) {background-color: red;}
tr{
color:black;
}
body{
 background-color: white;
  
}
h1{
color:black;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Update the User details</h1>  
		<pre>
       <form:form method="POST" action="/jobportalmain/usereditsubmit/${firstname}">    
        
                   
         
          Title          :      <form:input path="title"  />
           
          First name     :      <form:input path="firstname"  /> 
           
          Surname        :      <form:input path="surname"  />  
          
          Gender         :      <form:input path="gender" />
          
          Mobile No      :      <form:input path="phoneno" />
           
          DOB            :      <form:input path="dateofbirth" />   
          
          Marital Status :      <form:input path="maritalstatus" /> 
           
          Visa Status    :      <form:input path="visastatus" /> 
           
          Location       :      <form:input path="address" />
           
            
          <input type="submit" value="Save" class="btn" />   
            
       </form:form>  
       </pre>  
	</div>
</body>
</html>