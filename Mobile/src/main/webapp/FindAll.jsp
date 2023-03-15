<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mani Mobiles</title>
</head>
<body>

<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-Light  bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> 
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5hLacfhlnTGv3fDvLEJd8pkvFM85ZJCFoKg&usqp=CAU"
				alt="" width="60" height="50">
				</a>


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"style='color: OrangeRed'>Home</a><br> 
					
				</form>
		</div>
	</nav>
	
	
	<h3><span style='color:red'>${error}</span></h3>
	
	<h3><span style="color:green">${message }</span> </h3>
	
	<form action="findall" method="get" class="container col-20 col-sm-6 col-md-4 
	shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg m-5 pb-5 bg-info">
	
	Search FindAll <input type="submit" value="findall"/>
	</form>
	
	<div>
	
	<table class="table">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">name</th>
			<th scope="col">brandName</th>
			<th scope="col">modelName</th>
			<th scope="col">storage</th>
			<th scope="col">os</th>
			<th scope="col">price</th>
			<th scope="col">technology</th>
			<th scope="col">colors</th>
			<th scope="col">update</th>
			<th scope="col">Delete</th>
		
		</tr>
		
			<c:forEach items="${findall}" var="f">
				<tr>
					<td>${f.id}</td>
					<td>${f.name}</td>
					<td>${f.brandName}</td>
					<td>${f.modelName}</td>
					<td>${f.storage}</td>
					<td>${f.os}</td>
					<td>${f.price}</td>
					<td>${f.technology}</td>
					<td>${f.colors}</td>
					<td><a href="updated?id=${f.id}">update</a> </td>
					<td><a href="delete?id=${f.id }">Delete</a> </td>
					
					
		    	</tr>
			</c:forEach>
	</table>
	</div>

</body>
</html>