<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="edit" modelAttribute="student" >
	Id : <form:input path="id" readonly="true"/>
	Name : <form:input path="name" />
	Age : <form:input path="age" />
	Gender : <form:input path="gender" />
	Email : <form:input path="email" />
	Phone : <form:input path="phone" />
		<form:button>Update</form:button>

	</form:form>
</body>
</html>