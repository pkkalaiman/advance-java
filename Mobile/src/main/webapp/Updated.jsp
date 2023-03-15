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
				alt="" width="50" height="30">


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"
						style='color: OrangeRed'>Home</a>
				</form>

				<form class="d-flex">
					<a href="MobileSearch.jsp" class="form-control me-0"
						style='color: OrangeRed'>SeearchById</a>
				</form>
				
				<form class="d-flex">
					<a href="SearchByName.jsp" class="form-control me-0"
						style='color: OrangeRed'>SeearchByName</a>
				</form>
		</div>
	</nav>
	
	<div class="container"> <div class="ticker"> <div class="title"><h5 style="color:green">Breaking News</h5></div> 
 <div class="news"> <marquee class="news-content"> <p style="color:indigo">Welcome to P K Mani Mobile , Today i will Give Big offer For You , By One Mobile Get On Hair Phone</p> </marquee> </div> </div> </div>
  
	
	<c:forEach items="${error }" var="e">
		<span style='color: red;' ${e }>${e.getMessage()}</span>
	</c:forEach>
   <span style='color:green;'>${message }</span>
	<form action="updated" method="post"
		class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">

		<table>
			<tr>
				<td><h5>Welcome to Mobile Data Updated Page....</h5></td>
			</tr>
			
			<tr>
				<td style="color:green">Id</td>
				<td><input type="text" name="id" value="${dto.id}"></td>
			</tr>

			<tr>
				<td style="color:green">Mobile Name</td>
				<td><input type="text" name="name" value="${dto.name}"></td>
			</tr>

			<tr>

				<td style="color:green">Brand Name</td>
				<td><input type="text" name="brandName" value="${dto.brandName}"></td>
			</tr>

			<tr>

				<td style="color:green">Model Name</td>
				<td><input type="text" name="modelName" value="${dto.modelName}"></td>
			</tr>
			
			<tr>

				<td style="color:green">Price</td>
				<td><input type="text" name="price" value="${dto.price}"></td>
			</tr>
			
			<tr>

				<td style="color:green">Os</td>
				<td><select name="os">
						<option value="${dto.os }">${dto.os }</option>
						<c:forEach items="${os}" var="o">
							<option value="${o}">${o}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>

				<td style="color:green">Storage</td>
				<td><select name="storage">
						<option value="${dto.storage }">${dto.storage }</option>
						<c:forEach items="${storage}" var="d">
							<option value="${d}">${d}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>

				<td style="color:green">Cellular Technology</td>
				<td><input type="text" name="technology" value="${dto.technology }">
	                

			</tr>
			

			<tr>

				<td style="color:green">Colors</td>
				<td><select name="colors">
						<option value="${dto.colors }">${dto.colors }</option>
						<c:forEach items="${colors}" var="c">
							<option value="${c}">${c}</option>
						</c:forEach>

				</select></td>
			</tr>

		</table>

		<tr>
			<td><input type="submit" value="update"
				class="btn btn-outline-success btn-green"></td>
		</tr>

	</form>
</body>
</html>