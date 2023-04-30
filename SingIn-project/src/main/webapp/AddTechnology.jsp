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
			
			<a href="SingUp.jsp" class="btn btn-primary"> SingUp</a>
            <a href="index.jsp" class="btn btn-primary">Home</a>
            
            <span style="color: green;">Welcome:${userID}</span>
				
			<img src="download?fileName=${dtoPic}" height="50" width="80">
            
		</div>
	</nav>
	
	<form action="technology" method="post">

User Id<input value="${dto.userId}" readonly="readonly" name="userId"/>

<table>

<tr>
<td>Technology Name</td>
<td><input type="text" name="technologyName" value="${entity.technologyName}"/></td>
<tr>

<tr>
<td>Technology Language</td>
<td><input type="text" name="language" value="${entity.languange}"/></td>
<tr>

<tr>
<td>Technology Version</td>
<td><input type="text" name="version" value="${entity.version}"/></td>
<tr>

<tr>
<td>Technology Owner</td>
<td><input type="text" name="owner" value="${entity.owner}"/></td>
<tr>

<tr>
<td>Support From</td>
<td><input type="text" name="supportFrom" value="${entity.supportFrom}"/></td>
<tr>

<tr>
<td>Support To</td>
<td><input type="text" name="supportTo" value="${entity.supportTo}"/></td>
<tr>

<tr>
<td>License No</td>
<td><input type="text" name="licenseNo" value="${entity.licenseNo}"/></td>
<tr>

<tr>
<td>Open Source</td>
<td><input type="text" name="openSource" value="${entity.openSource}"/></td>
<tr>

<tr>
<td>OS Type</td>
<td><input type="text" name="osType" value="${entity.osType}"/></td>
<tr>

</table>

<br>

<button type="submit">Add</button>

</pre>


</form>
	

</body>

</html>