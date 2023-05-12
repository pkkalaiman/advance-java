<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					style='color: OrangeRed'>Home</a>
			</form>

			<form class="d-flex">
				<a href="mobile" class="form-control me-0" style='color: OrangeRed'>Mobiles</a>
			</form>



		</div>
	</nav>

	<h1 align="center" style="color: green">Mobile Search</h1>


	<h3>
		<span style='color: red'>${message}</span>
	</h3>

	<form action="findId" method="get"
		class="container col-20 col-sm-6 col-md-4 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">

		Search By Id<input type="text" name="id" /> <input type="submit"
			value="Search" />
	</form>

	<div>

		<h3 align="center" style="color: green">Result Search ID:</h3>

		<h3 style="color: green">ID :${dto.id}</h3>
		<h3 style="color: green">Name : ${dto.name}</h3>
		<h3 style="color: green">Brand Name: ${dto.brandName}</h3>
		<h3 style="color: green">Model Name : ${dto.modelName}</h3>
		<h3 style="color: green">Storage : ${dto.storage}</h3>
		<h3 style="color: green">Os : ${dto.os}</h3>
		<h3 style="color: green">Colors :${dto.colors}</h3>
		<h3 style="color: green">Technology :${dtdtoo.technology}</h3>

	</div>

</body>
</html>