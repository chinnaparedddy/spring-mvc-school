<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="user.jsp">HOME</a>
	<a href="loadteacher">Add TEACHER</a></h1>
	<table border="5px" cellpadding="50px" style="color: red">
    <tr>
    <th>Id </th>
    <th>Name</th>
    <th>Gender</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Subject</th>
    <th>Edit</th>
    <th>Delete</th>
    
    </tr>
    <c:forEach var="teacher" items="${teachers}">
    <tr>
    <td>${teacher.getId()}</td>
    <td>${teacher.getName()}</td>
    <td>${teacher.getGender()}</td>
    <td>${teacher.getEmail()}</td>
    <td>${teacher.getPhone()}</td>
    <td>${teacher.getSubject()}</td>
    <td>
      <a href="editteacher?id=${teacher.getId()}">Edit</a>
    </td>
    <td>
    <a href="deleteteacher?id=${teacher.getId()}">Delete</a>
    </td>
    </tr>
    </c:forEach>
    
    
    </table>
</body>


</html>