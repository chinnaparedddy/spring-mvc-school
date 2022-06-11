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

    <table>
    <tr>
    <th>Id </th>
    <th>Name</th>
    <th>Gender</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Subject</th>
    
    </tr>
    <c:forEach var="teacher" items="${teacher}">
    <tr>
    <td>${teacher.getId()}</td>
    <td>${teacher.getName()}</td>
    <td>${teacher.getGender()}</td>
    <td>${teacher.getEmail()}</td>
    <td>${teacher.getPhone()}</td>
    <td>${teacher.getSubject()}</td>
  <!--  <td>
      <a href="editteacher?id=${teacher.getId()}"></a>
    </td>
    <td>
    <a href="deletestudent?id=${teacher.getId() }"></a>
    </td> --> 
    </tr>
    </c:forEach>
    
    
    </table>
</body>
</html>