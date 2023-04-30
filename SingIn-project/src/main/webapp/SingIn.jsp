<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P.K.Mani</title>
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
		rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
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
		</div>
	</nav>



	<div align="center">
		<h5 style="color: red">${notmatch}</h5>
		<h5 style="color: red">${msg}</h5>
		<h5 style="color:red">${Timeout}</h5>

		<form action="signin" method="post"
			class="container col-30 col-sm-30 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-i  nfo">

			<table>
				<tr>
					<td>User ID</td>

					<td><input type="text" name="userId" id="userName" onchange="ValideName()" placeholder="User-Id"> 
					<span id="nameError" style="color: red"></span> 
					<span id="displayUserName" style="color: red"></span></td>
						
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword" onblur="ValidePassword()" placeholder="Password">
						 <span id="passwordError" style="color: red"></span>
						 <input type="checkbox" onclick="myFunction()">Show Password
					  </td>
				</tr>

			</table>
			<div>
				<button type="submit" class="btn btn-success">SignIN</button>
			</div>

			<div>
				<a href="SingUp.jsp" style="color: blue">Create New Account</a> <br>
				<a href="resetpassword.jsp" style="color: blue">Forgot Password</a><br>
<!-- 				  <a href="updatepassword.jsp" style="color: blue">Update Passsword</a>
 -->					
			</div>
		</form>
	</div>
	<script>
		function ValideName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('valide name');
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('invalide name');
				document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
			}
		}
		function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>


</body>
</html>