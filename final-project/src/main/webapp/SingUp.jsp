<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<a class="navbar-brand" href="#"></a> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="100" height="48" class="d-inline-block align text-top">
		
		<form class="d-flex">
			<a href="index.jsp" class="form-control me-0"style='color: OrangeRed'>Home</a>
		</form>

		
				</div>

	</nav>

	<h1 style="color: green;">${message}</h1>
	<h5 style="color: red;">${messag}<br>
		<c:forEach items="${error}" var="e">${e.message}</c:forEach>
	</h5>
		<form action="mani" method="post" class="container col-20 col-sm-8 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-i  nfo">

	<!--<h2 align="center">Login Page</h2>-->
		<%-- User ID <input type="text" name="userId" id="userName" onchange="ValideName()"> 
		<span id="nameError" style="color: red"></span>
		<span style="color: red">${userIdExesist}</span>
		<span id="displayUserName" style="color: red"></span>
		<br>
		
 --%>		<table>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userId" id="userName" onchange="ValideName()">
				<span id="nameError" style="color:red"></span>
				<span style="color:red">${userIdExesist}</span>
				<span id="dislplayUserName" style="color:red"></span>
			    </td>
			</tr><br>
		</table>
		
		<%--  Email<input type="email" name="email" id="emailId" onchange="valideEmail()">
		 <span id="emailError" style="color: red"></span>
		<span id="display" style="color: red"></span>
		<span style="color: red">${emailIdExesist}</span>
		<br> --%>
		
		    <tr>
				<td>Email Id</td>
				<td><input type="email" name="email" id="emailId" onchange="valideEmail()">
				<span id="emailError" style="color:red"></span>
				<span id="display" style="color:red"></span>
				<span style="color:red">${emailIdExesist}</span>
			    </td>
			</tr>
			<br>
		
		<%--  Mobile Number<input type="number" name="mobileNo" id="userMobile" onchange="ValideMobile()">
		<span id="mobileError" style="color: red"></span>
		<span id="displayUserMobile" style="color: red"></span>
		<span style="color: red">${mobileNumberExesist}</span>
		`<br> --%>
		
		  <tr>
				<td>Mobile Number</td>
				<td><input type="number" name="mobileNo" id="userMobile" onchange="ValideMobile()">
				<span id="mobileError" style="color:red"></span>
				<span id="displayUserMobile" style="color:red"></span>
				<span style="color:red">${mobileNumberExesist}</span>
			    </td>
			</tr>
			<br>
		
		 Password<input type="password" name="password" id="userPassword">
		<span id="passwordError" style="color: red"></span> <br>
		<input type="checkbox" onclick="myFunction()">Show Password 
		<br>
		ConfirmPassword<input type="password" name="confirmPassword" id="userConfirmPassword" onblur="ValidePassword()">
		<span id="passwordCompare" style="color: red"></span> 
		<br> 
		
		Agreement <input type="checkbox" name="agrement" id="agreementConfirm" onclick="ValideName()"> 
		<br>
		
		<button type="submit" class="btn btn-success" id="submitId" disabled="true">SignUp</button>
		
	</form>
	
	<%-- <input type="submit" value="ShowDTO" onclick="DisplayDTO()">
	<span id="ShowDTO"></span>
	<h4 style="color:red">${password}</h4>
	 --%>
	<script>
		function DisplayDTO() {
			console.log('Running in DisplayDTO');
			const xhttp = new XMLHttpRquest();
			xhttp.open("GET", "http://localhost:8080/final-project/dto");
			xhttp.send();

			xhttp.onload = function() {
				console.log(this);

				document.getElementById("showDTO").innerHTML = this.responseText

				var json = JSON.parse(this.responseText);
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

		function ValideName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('valide name');
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
			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(uservalue);
			xhttp.open("GET", "http://localhost:8080/final-project/userName/"
					+ uservalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayUserName").innerHTML = this.responseText
			}
		}
		function valideEmail() {
			var userEmail = document.getElementById('emailId');

			var userEmailvalue = userEmail.value;

			console.log(userEmailvalue);

			if (userEmailvalue != null && userEmailvalue != ""
					&& userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('valide email');

				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalide email');
				document.getElementById('emailError').innerHTML = 'Plese enter valide email';
			}

			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(userEmailvalue);
			xhttp.open("GET", "http://localhost:8080/final-project/email/"
					+ userEmailvalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("display").innerHTML = this.responseText

			}
		}
		function ValideMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valide mobile');
				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalide mobile');
				document.getElementById('mobileError').innerHTML = 'Plese enter valide Mobile Number';
			}
			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(userMobilevalue);
			xhttp.open("GET", "http://localhost:8080/final-project/mobile/"
					+ userMobilevalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayUserMobile").innerHTML = this.responseText
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
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
				}
				console.log('valide password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalide password');
				document.getElementById('passwordError').innerHTML = 'Plese enter valide password';
			}
		}
	</script>

</body>
</html>