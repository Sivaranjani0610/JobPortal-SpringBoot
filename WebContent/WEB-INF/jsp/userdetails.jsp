<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Students</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style>

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
	<div align="center" class="des">
		  <h1>Enter the User Details</h1> 
		  
		  <pre>
       <form:form method="post" action="addnewstud" enctype="multipart/form-data">
       <table float="center" id="myTable">    
         
         <tr><td> Title          :      <form:input path="title"  /> </td></tr>
           
         <tr><td> First name     :      <form:input path="firstname"  /> </td></tr>
           
         <tr><td> Surname        :      <form:input path="surname"  />  </td></tr>
          
         <tr><td> Gender         :      <form:input path="gender" /> </td></tr>
          
         <tr><td> Mobile No      :      <form:input path="phoneno" /> </td></tr>
           
         <tr><td> DOB            :      <form:input path="dateofbirth" />   </td></tr>
          
         <tr><td> Marital Status :      <form:input path="maritalstatus" /> </td></tr>
           
         <tr><td> Visa Status    :      <form:input path="visastatus" /> </td></tr>
         
         <tr><td> Job Role       :      <form:input path="jobrole" /> </td></tr>
         
         <tr><td> IT Experience  :      <form:input path="itexperience" /> </td></tr>
           
         <tr><td> Location       :      <form:input path="address" /> </td></tr>
           
        
        
        
          
          
          
       <tr><td>     <input type="submit" value="Save" class="btn" /> </td></tr>
            </table>
               
       </form:form>    
      
       </pre>
	</div>
</body>
</html>