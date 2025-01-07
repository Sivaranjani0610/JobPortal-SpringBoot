<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
    <title>File Download</title>
</head>
<body>
    <h1>Download File</h1>
    
    <p>
        <a href="<c:url value='/downloadFile/3' />">Download File 1</a>
        <!-- Replace '1' in '/downloadFile/1' with the appropriate file ID -->
    </p>

   

   

</body>
</html>