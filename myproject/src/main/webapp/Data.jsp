<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Data</h1>

<c:forEach items="${error}" var="e">
	<span>${e.getmessage}</span>
</c:forEach>

<h1 style="color:green">${message}</h1>

 <h2 align="center"><a href="index.jsp">Home</a></h2> 

<form action="project" method="post">

Name<input type="text" name="name" placeholder="Enter Name" value="${dto.name }"/><br><br>
Father Name<input type="text" name="fatherName" placeholder="Enter FatherName" value="${dto.fatherName }"/><br><br>
Mother Name<input type="text" name="motherName" placeholder="Enter MotherName" value="${dto.motherName }"/><br><br>
Gender <input type="radio" name="gender"  value="${dto.gender }"/>Male<br><br>
		<input type="radio" name="gender"  value="${dto.gender }"/>Female<br><br>
	
E-mail <input type="email" name="email" placeholder="Enter E-mail" value="${dto.email }"/><br><br>

<input type="submit" name="saved">

</form>
</body>
</html>