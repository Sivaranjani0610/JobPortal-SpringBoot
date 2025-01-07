<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
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
		<h1>Users List</h1> 
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
		<input type="text" id="myInput1" onkeyup="myFunction2()" placeholder="Visa Status.." title="Type in a name">
		<input type="text" id="myInput2" onkeyup="myFunction3()" placeholder="Job Role.." title="Type in a name">
		<table float="center" id="myTable">  
		<tr><th>Id</th><th>Title</th><th>First Name</th><th>Surname</th><th>Gender</th><th>Mobile No</th><th>DOB</th><th>Marital Status</th><th>Visa Status</th><th>Job Role</th><th>IT Experience</th><th>Location</th></tr>  
		   <c:forEach var="viewstu" items="${list}" varStatus="status">   
		   <tr>  
		   <td>${status.index + 1}</td>  
		   <td>${viewstu.title}</td>  
		   <td>${viewstu.firstname}</td>  
		   <td>${viewstu.surname}</td>  
		   <td>${viewstu.gender}</td>
		   <td>${viewstu.phoneno}</td>
		   <td>${viewstu.dateofbirth}</td>
		   <td>${viewstu.maritalstatus}</td>
		   <td>${viewstu.visastatus}</td>
		   <td>${viewstu.jobrole}</td>
		   <td>${viewstu.itexperience}</td>
		   <td>${viewstu.address}</td>
		     
		     
		   
		   <td> <a href="<c:url value='/downloadFile/${viewstu.profileid}' />">Download File </a></td>
		    
		   </tr>  
		   </c:forEach>  
		   </table>  
		   <br/>  
		   
		   
		     
	</div>
	<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

function myFunction2() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput1");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[8];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	
function myFunction3() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput2");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[9];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>
	
</body>
</html>