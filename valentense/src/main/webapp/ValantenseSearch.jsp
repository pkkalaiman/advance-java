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
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="50" height="30">

			</a>
			<a href="valentens">Valantense</a>
			<a href="index.jsp"></a>
		</div>
	</nav>
	
	<h1>Vlantense Search</h1>
	
	
	<h3><span style='color:red'>${message}</span></h3>
	
	<form action="search" method="get">
	
	Search By Id<input type="text" name="id"/>
	<input type="submit" value="Search"/>
	</form>
	
	<div>
	
	<h3>Search Result: </h3>
	Name : ${dto.name}<br>
	Place: ${dto.place}<br>
	Gift : ${dto.gift}<br>
	Valantense Name : ${dto.valantenseName}
	
	</div>
	

</body>
</html>