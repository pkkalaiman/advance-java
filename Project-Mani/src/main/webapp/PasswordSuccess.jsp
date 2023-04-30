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

</head>


<body>

<nav class="navbar navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"><img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align-text-top"></a>

				
				<a href="index.jsp" class="btn btn-warning"> Home </a>
				
				
				<span style="color: white;">Welcome:${userID}</span>
				<img src="download?fileName=${dtoPic}" height="50" width="80">
				
		</div>

	</nav>
	
	<a href="updateProfile.jsp" class="btn btn-warning"> Update Profile </a>
	<a href="technology" class="btn btn-warning">Add Technology </a>
	<a href="viewTech?userId=${userID}" class="btn btn-warning" > View Technology </a>
	
	<h2 style="color:green;"> Login Successfull </h2>

</body>

</body>
</html>