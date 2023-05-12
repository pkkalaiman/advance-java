<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile</title>
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
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="50" height="30">


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"
						style='color: OrangeRed'>Home</a><br>
				
					<a href="MobileSearch.jsp" class="form-control me-0"
						style='color: OrangeRed'>MobileSearch</a>
				</form>
		</div>
	</nav>
	
	<c:forEach items="${error}" var="f">
	<option style="color:red" value="${f.message}">${f.message}</option>
	</c:forEach>

	<form action="Mobile" method="post"
		class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">

		<table>
			<tr>
				<td><h5>Welcome to Mobile Data Saving....</h5></td>
			</tr>

			<tr>
				<td>Mobile Name</td>
				<td><input type="text" name="name" value="${dto.name }"></td>
			</tr>

			<tr>

				<td>Brand Name</td>
				<td><input type="text" name="brandName" value="${dto.brandName }"></td>
			</tr>

			<tr>

				<td>Model Name</td>
				<td><input type="text" name="modelName" value="${dto.modelName }"></td>
			</tr>

			<tr>

				<td>Os</td>
				<td><select name="os">
						<option value="${dto.os }">${dto.os }</option>
						<c:forEach items="${os}" var="o">
							<option value="${o}">${o}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>

				<td>Storage</td>
				<td><select name="storage">
						<option value="${dto.storage }">${dto.storage }</option>
						<c:forEach items="${storage}" var="d">
							<option value="${d}">${d}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>

				<td>Cellular Technology</td>
				<td><input type="text" name="technology" value="${dto.technology }">
	                

			</tr>

			<tr>

				<td>Colors</td>
				<td><select name="colors">
						<option value="${dto.colors }">${dto.colors }</option>
						<c:forEach items="${colors}" var="c">
							<option value="${c}">${c}</option>
						</c:forEach>

				</select></td>
			</tr>

		</table>

		<tr>
			<td><input type="submit" value="Order"
				class="btn btn-outline-success btn-green"></td>
		</tr>

	</form>
</body>


</html>