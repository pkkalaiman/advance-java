<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<h4>Send Interview details</h4>
	
	
	<form action="interview" method="post" class="form-control-lg ">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Company
				Name</label> <input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Enter food name"
				name="Company">
		</div>
		<div>
			<label for="exampleFormControlInput2" class="form-label">Possition
				type</label> <select class="form-select" name="Possition" aria-label="Default select example">
				<option selected>Select Company</option >
				<option value="Infosys">Infosys</option>
				<option value="Tata">Tata</option>
				<option value="PK Groups">PK Groups</option>
			</select>
		</div>

		<div>
			<label for="customRange2" class="form-label">Range</label> <input
				type="range" class="form-range" min="0" max="5" id="customRange2" name="Range">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput2" class="form-label">Salary</label> 
			<input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Enter the price"
				name="Salary">
		</div>
		<input type="submit" value="Send" class="btn btn-dark"/>
	</form>

</body>
</html>