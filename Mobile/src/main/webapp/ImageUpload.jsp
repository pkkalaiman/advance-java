<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				alt="" width="60" height="50"></a>


				<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"style='color: OrangeRed'>Home</a><br> 
					
				</form>
		</div>
	</nav>
	
	<h1>Upload Image Test</h1>

	<form action="Imageupload" method="post" enctype="multipart/form-data">
	Upload : <input type="file" name="mani">
	<input type="submit" value="upload">
	</form>	

</body>
</html>