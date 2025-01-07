<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<div align="center" class="des">
    <h2>ADMIN LOGIN</h2>
    
    
    <form action="/jobportalmain/adminlogin" method="post"  >
        <table float="center" id="myTable"> 
      <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr> 
    <tr> <td>  Username : <input type="text" name="username"> </td></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
     
    <tr> <td> Password :   <input type="password" name="password"> </td> </tr>
       <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr> <td>    <input type="submit" value="submit"> </td></tr>
        </table>
    </form>
</div>
</body>
</html>
