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
	<form:form action="savestudent" modelAttribute="user" >
	Name : <form:input path="name" />
	Age : <form:input path="age" />
	Gender : <form:input path="gender" />
	Email : <form:input path="email" />
	Phone : <form:input path="phone" />
		<form:button>Rigister</form:button>

	</form:form>

</body>
</html>