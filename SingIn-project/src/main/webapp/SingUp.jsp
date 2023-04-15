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

			<form class="d-flex">
				<a href="index.jsp" class="form-control me-0"
					style='color: OrangeRed'>Home</a>
			</form>

			<form class="d-flex">
				<a href="SingIn.jsp" class="form-control me-0"
					style='color: OrangeRed'>SingIn</a>
			</form>
		</div>
	</nav>

	<style type="text/css">

body {
	background-image: url("https://thumbs.dreamstime.com/b/taj-mahal-agra-india-morning-light-reflection-water-uttar-pradesh-108954918.jpg");
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
	text-align: center;
	margin-top: 100px;
}
</style>

	<div align="center">
		<h1 style="color: green;">${message}</h1>
		<h5 style="color: red;">${messag}<br>
			<c:forEach items="${errors}" var="e">${e.message}</c:forEach>
		</h5>

		<form action="detials" method="post"
			class="container col-20 col-sm-8 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-i  nfo">

			<table>
				<tr>
					<td>User ID</td>

					<td><input type="text" name="userId" id="userName"
						onchange="ValideName()"> <span id="nameError"
						style="color: red"></span> <span id="displayUserName"
						style="color: red"></span></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="email" name="email" id="emailId"
						onchange="valideEmail()"> <span id="emailError"
						style="color: red"></span> <span id="display" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Mobile Number</td>
					<td><input type="number" name="mobile" id="userMobile"
						onchange="ValideMobile()"> <span id="mobileError"
						style="color: red"></span> <span id="displayUserMobile"
						style="color: red"></span></td>
				</tr>


				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword">
						<span id="passwordError" style="color: red"></span> <input
						type="checkbox" onclick="myFunction1()">Show Password</td>
				</tr>

				<tr>
					<td>ConfirmPassword</td>
					<td><input type="password" name="confirmPassword" id="userConfirmPassword" onblur="ValidePassword()">
					<span id="passwordCompare" style="color: red"></span></td>
				</tr>


				<tr>
					<td>Agreement <input type="checkbox" name="agreement"
						id="agreementConfirm" onclick="ValideName()"></td>
				</tr>
			</table>
			<div>
				<button type="submit" class="btn btn-success" onclick="ValideName()"
					disabled="true" id="submitId">SignUp</button>
			</div>
		</form>
	</div>
	<h4 style="color: red;">${password}</h4>
	<script>
		function myFunction1() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		function myFunction2() {
			var x = document.getElementById("userConfirmPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}

		function ValideName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('valide name');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(user);
				console.log(uservalue);

				xhttp.open("GET",
						"http://localhost:8080/SingIn-project/userName/"
								+ uservalue);
				xhttp.send();
				xhttp.onload = function() {
					console.log(this);
					document.getElementById("displayUserName").innerHTML = this.responseText
				}
				var agree = document.getElementById('agreementConfirm');
				console.log(agree.checked);
				if (agree.checked) {
					document.getElementById('submitId').disabled = false;
				}
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('invalide name');
				document.getElementById('submitId').disabled = 'disabled';
				document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
			}
		}
		function valideEmail() {
			var userEmail = document.getElementById('emailId');
			var userEmailvalue = userEmail.value;
			console.log(userEmailvalue);
			if (userEmailvalue != null && userEmailvalue != ""
					&& userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('valide email');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(userEmailvalue);
				xhttp.open("GET", "http://localhost:8080/SingIn-project/email/"
						+ userEmailvalue);
				xhttp.send();
				xhttp.onload = function() {
					console.log(this);
					document.getElementById("display").innerHTML = this.responseText
				}
				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalide email');
				document.getElementById('emailError').innerHTML = 'Plese enter valide email min 4 and max 40 charactes ';
			}
		}
		function ValideMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valide mobile');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(userMobilevalue);
				xhttp.open("GET",
						"http://localhost:8080/SingIn-project/mobile/"
								+ userMobilevalue);
				xhttp.send();
				xhttp.onload = function() {
					console.log(this);
					document.getElementById("displayUserMobile").innerHTML = this.responseText
				}
				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalide mobile');
				document.getElementById('mobileError').innerHTML = 'Plese enter valide Mobile Number digits must be 10';
			}
		}
		function ValidePassword() {
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
					console.log('valide both password are same');
					document.getElementById('passwordCompare').innerHTML = '';
				} else {
					console.log('valide both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword are not matching';
				}
				console.log('valide password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalide password');
				document.getElementById('passwordError').innerHTML = 'Plese enter valide password length must be greater then 4 and less then 12';
			}
		}
	</script>


</body>
</html>