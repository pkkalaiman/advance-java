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
				alt="" width="50" height="30"></a>


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"
						style='color: OrangeRed'>Home</a>
				</form>

				<form class="d-flex">
					<a href="FindById.jsp" class="form-control me-0"
						style='color: OrangeRed'>SeearchById</a>
				</form>
				
				<form class="d-flex">
					<a href="FindByName.jsp" class="form-control me-0"
						style='color: OrangeRed'>SeearchByName</a>
				</form>
		</div>
	</nav>
	

	<h1>Welcome to ManiMobiles Data Updated Page...</h1>
	
	<form action="Update" method="post" class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">
	<table>
	
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" value="${dto.id}"> </td>
		</tr>
		
		<tr>
			<td>Mobile Name</td>
			<td><input type="text" name="name" value="${dto.name}"> </td>
		</tr>
		
		<tr>
			<td>Model Name</td>
			<td><input type="text" name="modelName" value="${dto.modelName}"></td>
		</tr>
		
		<tr>
			<td>Brand Name</td>
			<td><input type="text" name="brandName" value="${dto.brandName}"></td>
		</tr>
		
		<tr>
			<td>Cellular Technology</td>
			<td><input type="text" name="technology" value="${dto.technology}"></td>		
		</tr>
		
		<tr>
			<td>Colors</td>
			<td><select name="colors">
				<option value="${dto.colors}">${dto.colors}</option>
				<c:forEach items="${colors}" var="c">
					<option value="${c}">${c}</option>				
				</c:forEach>
			</select></td>
		</tr>
		
		<tr>
			<td>Os</td>
			<td><select name="os">
			<option value="${dto.os}">${dto.os}</option>
			<c:forEach items="${os}" var="v">
				<option value="${v}">${v}</option>			
			</c:forEach>
			</select> </td>
		</tr>
		
		<tr>
			<td>Storage</td>
			<td><select name="storage">
				<option value="${dto.storage}">${dto.storage}</option>
				<c:forEach items="${storage}" var="s">
				<option value="${s}">${s}</option>				
				</c:forEach>
			</select></td>
		</tr>
		
	</table>
	
	<tr>
		<td><input type="submit" value="update"	class="btn btn-outline-success btn-green"></td>
		
	</tr>
	
	</form>

</body>
</html>