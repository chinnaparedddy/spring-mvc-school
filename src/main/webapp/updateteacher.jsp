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
<form:form action="update" modelAttribute="edit">
	Id : <form:input path="id" readonly="true"/>
	Name : <form:input path="name" />
	Gender : <form:input path="gender" />
	Email : <form:input path="email" />
	Phone : <form:input path="phone" />
	Subject : <form:input path="subject" />
		<form:button>update</form:button>

	</form:form>
</body>
</html>