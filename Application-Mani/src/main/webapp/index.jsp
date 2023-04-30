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
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>

	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script></hea
d>
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
			
			<form class="d-flex">
					<a href="index.jsp" class="form-control me-0"
					style='color: OrangeRed'>Home</a>
				</form>

              <form class="d-flex">
					<a href="Registration.jsp" class="form-control me-0"
					style='color: OrangeRed'>SingIn</a>
				</form>
		</div>
	</nav>
	
	<style type="text/css">
body {
	background-image:
		url("data:image/png;base64,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");
	background-size: cover;
}

.navbar {
	background: transparent;
}

.nav-link {
	font-family: serif;
}

.nav-link:hover {
	border-bottom: 2px solid #38fd07;
	display: block;
}

h1 {
	color: white;
	text-align: left;
	margin-top: 10px;
	font-size: 50px;
}
</style>
<div>
<h1 align="center" style="color:blue;">Welcome to P K Mani</h1>
<p>&#128512;</p>
</div>


</body>

</html>