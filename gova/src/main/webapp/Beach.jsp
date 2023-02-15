<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workx</title>
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
	<h1 style="color: blue">Wlcome to Beach</h1>
	<br>
	<br>

	<form action="Beach" method="post">

		<pre>
Name<input type="text" name="name" />

Location<input type="text" name="location" />

<div id="map-container-google-2" class="z-depth-1-half map-container"
				style="height: 500px">
  <iframe
					src="https://maps.google.com/maps?q=chicago&t=&z=13&ie=UTF8&iwloc=&output=embed"
					frameborder="100px" style="border: 200px"></iframe>
</div>


Clean Yes<input type="checkbox" name="clean" />
	 No<input type="checkbox" name="FreeFood" />
	 
 
</pre>
		<input type="submit" value="Send" class="btn btn-dark">

	</form>


</body>
</html>