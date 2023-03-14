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
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-Light  bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5hLacfhlnTGv3fDvLEJd8pkvFM85ZJCFoKg&usqp=CAU"
				alt="" width="60" height="50">


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"style='color: OrangeRed'>Home</a><br> 
					
				</form>
		</div>
	</nav>


	<div class="container"> <div class="ticker"> <div class="title"><h2 align="center" style="color:OrangeRed">Breaking News</h2></div> 
 <div class="news"> <marquee class="news-content"> <p style="color:indigo">Welcome to P K Mani Mobile ,Dhamaaka offer buy 1 get 1 </p> </marquee> </div> </div> </div>
  
	
	
	<h3><span style='color:red'>${Error}</span></h3>
	
	<h3><span style="color:green">${message }</span> </h3>
	
	<form action="searchNameBybrandName" method="get" class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">
	
	Search ByNameByBrandName<input type="text" name="name"/><input type="text" name="brandName"/>
	<input type="submit" value="Search"/>
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
		
			<c:forEach items="${name}" var="l">
				<tr>
					<td>${l.id}</td>
					<td>${l.name}</td>
					<td>${l.brandName}</td>
					<td>${l.modelName}</td>
					<td>${l.storage}</td>
					<td>${l.os}</td>
					<td>${l.price}</td>
					<td>${l.technology}</td>
					<td>${l.colors}</td>
					<td><a href="updated?id=${l.id}">update</a> </td>
					<td><a href="delete?id=${l.id }">Delete</a> </td>
					
					
		    	</tr>
			</c:forEach>
	
	</table>
	
	</div>
</body>
</html>