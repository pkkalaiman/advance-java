<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				alt="" width="50" height="30">

			</a>
			<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"
						style='color: Violet'>Home</a>
				</form>
			
			<form class="d-flex">
					<a href="mobile" class="form-control me-0"
						style='color: OrangeRed'>Mobiles</a>
				</form>
			
			
			
		</div>
	</nav>
	
 <!-- <marquee> <h1 style="color:pink">Welcome to Mobile Search</h1></marquee> -->
  
 <div class="container"> <div class="ticker"> <div class="title"><h5 style="color:green">Breaking News</h5></div> 
 <div class="news"> <marquee class="news-content"> <p style="color:indigo">Welcome to P K Mani Mobile , Today i will Give Pig offer For You , By One Mobile Get On Hair Phone</p> </marquee> </div> </div> </div>
  
	
	
	<h3><span style='color:red'>${error}</span></h3>
	
	<form action="searchbyname" method="get" class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">
	
	Search By Name<input type="text" name="name"/>
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
		
		</tr>
		
			<c:forEach items="${list}" var="l">
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
					<td><a href="Updated?id=${l.id}">update</a> </td>
					
		    	</tr>
			</c:forEach>
	
	</table>
	
	</div>
	
	
	

</body>
</html>