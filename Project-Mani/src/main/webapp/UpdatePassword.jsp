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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

</head>

<body>

<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top"></a>

				<a href="index.jsp" class="btn btn-warning">Home</a>
				
				<a href="SingIn.jsp" class="btn btn-warning">SignIn</a>
				
		</div>

	</nav>

<div align="center">User Name:${userId}</div>

<form action="passwordUpdate" method="post" class="container col-30 col-sm-30 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-i  nfo">

	<pre>

	User ID <input type="text" name="userId" id="userName"
			onchange="ValidName()"> <span id="nameError"
			style="color: red"></span>
			<span id="displayUserName" style="color: red"> </span>
			
	    
	Password<input type="password" name="password" id="userPassword"
			onchange="ValidPassword()"> <span id="passwordError"
			style="color: red"></span> 
			 <input type="checkbox" onclick="myFunction()">Show Password
			 
	ConfirmPassword<input type="password" name="confirmPassword"
			id="userConfirmPassword" onchange="ValidPassword()">
			<span id="passwordCompare" style="color: red"></span>
			
	<button type="submit">SignUp</button>
	
	</pre>

</form>

<script>
	function myFunction() {
		var x = document.getElementById("userPassword");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
	function ValidName() {
		var user = document.getElementById('userName');
		var uservalue = user.value;
		console.log(uservalue);
		if (uservalue != null && uservalue != "" && uservalue.length > 2
				&& uservalue.length < 30) {
			console.log('valid name');
			document.getElementById('nameError').innerHTML = '';
		} else {
			console.log('invalid name');
			document.getElementById('nameError').innerHTML = 'Please enter valid name min 4 and max 30 character';
		}
	}
	function ValidPassword() {
		var userPassword = document.getElementById('userPassword');
		var userConfirmPassword = document
				.getElementById('userConfirmPassword');
		var userPasswordvalue = userPassword.value;
		var userConfirmPasswordvalue = userConfirmPassword.value;
		console.log(userPasswordvalue);
		if (userPasswordvalue != null && userPasswordvalue != ""
				&& userPasswordvalue.length > 4
				&& userPasswordvalue.length < 12) {
			if (userPasswordvalue == userConfirmPasswordvalue) {
				console.log('valid both password are same');
				document.getElementById('passwordCompare').innerHTML = '';
			} else {
				console.log('valid both password are not same');
				document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
			}
			console.log('valid password');
			document.getElementById('passwordError').innerHTML = '';
		} else {
			console.log('invalid password');
			document.getElementById('passwordError').innerHTML = 'Please enter valid password';
		}
	}
</script>




</body>

</body>
</html>