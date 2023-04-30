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
		crossorigin="anonymous"></script></head>

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
			
			<a href="SingUp.jsp" class="btn btn-primary"> SingUp</a>
            <a href="index.jsp" class="btn btn-primary">Home</a>
            
            <span style="color: green;">Welcome:${userID}</span>
				
			<img src="download?fileName=${dtoPic}" height="50" width="80">
            
		</div>
	</nav>
	
	<table class="table table-dark table-hover">
	
	<tr>
	<th>Technology Name</th>
	<th>Technology Language</th>
	<th>Technology Version</th>
	<th>Technology Owner</th>
	<th>Support From</th>
	<th>Support To</th>
	<th>License</th>
	<th>Open Source</th>
	<th>OS Type</th>	
	</tr>
	
	<c:forEach items="${viewTech}" var="t">
	
	<tr>
	<td>${t.technologyName}</td>
	<td>${t.languange}</td>
	<td>${t.version}</td>
	<td>${t.owner}</td>
	<td>${t.supportFrom}</td>
	<td>${t.supportTo}</td>
	<td>${t.licenseNo}</td>
	<td>${t.openSource}</td>
	<td>${t.osType}</td>
	
	
	
	</c:forEach>
	
	
	
	</table>
	
	

</body>

</html>