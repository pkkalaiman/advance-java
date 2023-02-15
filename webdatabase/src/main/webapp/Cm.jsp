<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		</div>
	</nav>

	<form action="cm" method="post"
		class="container col-12 col-sm-6 col-md-3 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">
		<table>
			<tr>
				<td><h5>PARTY DETAILES</h5></td>
			</tr>

			<tr>
				<td>CM NAME</td>
				<td><input type="text" name="name"><br></td>
			</tr>



			<tr>
				<td>PARTY</td>
				<td><select name="party">
						<option>--select party----</option>
						<option>BJP</option>
						<option>JDS</option>
						<option>APP</option>
						<option>CONGRESS</option>
				</select></td>
			</tr>



			<tr>
				<td>STATE</td>
				<td><select name="state">
						<option value="0">--select state----</option>
						<option>KARNATAKA</option>
						<option>ANDRHA</option>
						<option>TELAGNA</option>
						<option>UP</option>
				</select></td>
			</tr>

			
			<tr>
			<td>Tenuer</td>
			<td><textarea rows="2" cols="10" name="tenuer"></textarea>
			
			
			
			</select>


		</table>

		<tr>
			<td><input type="submit" value="save"
				class="btn btn-outline-success btn-block"></td>
		</tr>
	</form>

</body>
</html>