<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
    <title>Upload PDF</title>
</head>
<body>

    <h2>Upload CV/Resume File</h2>
    
    
    <form action="/jobportalmain/uploadPDF/${surname}/${firstname}" method="post"  enctype="multipart/form-data">
        
       
       Surname  ${surname} 
       First Name ${firstname}
       
       <input type="file" name="file"  required >
        <br/><br/>
       
        <input type="submit" value="Upload">
    </form>

</body>
</html>
