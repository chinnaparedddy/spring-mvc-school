<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="user.jsp">HOME</a>
	<a href="load">Add STUDENT</a></h1>
	
	<table border="5px" cellpadding="50px">
	    <tr>
	        <th>Id</th>
	        <th>Name</th>
	        <th>Email</th>
	        <th>Gender</th>
	        <th>Age</th>
	        <th>Phone</th>
	        <th>Edit</th>
	        <th>Delete</th>
	    </tr>
	    <c:forEach var="student" items="${students}">
	      <tr>
	    	<td>${student.getId()}</td>
	    	<td>${student.getName()}</td>
	    	<td>${student.getEmail()}</td>
	    	<td>${student.getGender()}</td>
	    	<td>${student.getAge()}</td>
	    	<td>${student.getPhone()}</td>
	    	<td>
	    	    <a href="editstudent?id=${student.getId()}">Edit</a>
	    	</td>
	    	<td>
	    	     <a href="deletestudent?id=${student.getId()}">Delete</a>
	    	</td>
	      </tr>
	    </c:forEach>
	
	
	
	</table>
</body>
</html>