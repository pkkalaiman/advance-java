<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<body>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="80" height="48">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="d-flex">
				<a href="index.jsp" class="form-control me-2">Home</a>
			</div>
		</div>
	</nav>
	<h4>Send food item details</h4>
	
	
	<form action="food" method="post" class="form-control-lg ">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Food
				Name</label> <input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Enter food name"
				name="name">
		</div>
		<div>
			<label for="exampleFormControlInput2" class="form-label">Food
				type</label> <select class="form-select" name="type" aria-label="Default select example">
				<option selected>Select Food type</option >
				<option value="veg">Veg</option>
				<option value="nonveg">Non-Veg</option>
				<option value="both">Both</option>
			</select>
		</div>

		<div>
			<label for="customRange2" class="form-label">Quantity</label> <input
				type="range" class="form-range" min="0" max="5" id="customRange2" name="quantity">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput2" class="form-label">Price</label> 
			<input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Enter the price"
				name="price">
		</div>
		<input type="submit" value="Send" class="btn btn-dark"/>
	</form>


</body>
</html>