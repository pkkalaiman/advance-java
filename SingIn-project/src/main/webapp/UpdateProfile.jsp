<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
			 <span>Welcome:${userID}</span>
			<img src="download?fileName=${dtoPic}" height="50" width="80">
		</div>
	</nav>

	<form action="upload" method="post" enctype="multipart/form-data">

		<pre>
	
	User ID <input type="text" name="userId" id="userName"
				onchange="ValideName()" value="${dto.userId}">
			<span id="nameError" style="color: red"></span><br>
			<span id="displayUserName" style="color: red"></span>

	Eamil <input type="email" name="email" id="emailId"
				onchange="validEmail()" value="${dto.email}">
		<span id="emailError" style="color: red"></span><br>
		<span id="display" style="color: red"></span>

	Mobile Number<input type="number" name="mobile" id="userMobile"
				value="${dto.mobile}">
				<span id="mobileError" style="color: red"></span><br>
				<span id="displayuserMobile" style="color: red"></span>

	Set Profile Picture: <input type="file" name="mani">
	
	
				<div> <button type="button" class="btn btn-success">Update</button> </div>

	</pre>

	</form>


	<div>

		<script>
	
		function myFunction(){
			
			var x=document.getElementById("userPassword");
			if(x.type === "password"){
				
				c.type = "text";
			}else{
				x.type = "password";
			}
		}
		
		function ValidName(){
			var user= document.getElementById('userName');
			var userValue =user.value;
			console.log(uservalue);
			
			if(uservalue !=null && uservalue !="" && uservalue.length>2 && uservalue.length < 30){
				console.log('valid name');
				document.getElementById('nameError').innerHTML ='';
				
			}else{
				console.log('invalid name');
				document.getElementById('nameError').innerHTML='please enter valide Name min 2 and max 30 charactor';
			}
			const xhttp =new XMLHttpRequest();
			console.log("running in ajax");
			console.log(uservalue);
			xhttp.open("GET","http://localhost:8080/SingIn-project/userName/"+uservalue);
			xhttp.send();
			xhttp.onload =function(){ 
				console.log(this);
				document.getElementById("displayUserName").innerHTML= this.responseText
			}
		}
			
			function validEmail(){
				var userEmail= document.getElementById('emailId');
				var userEmailvalue= userEmail.value;
				console.log(userEmailvalue);
				if(userEmailvalue !=null && userEmailvalue !="" && userEmailvalue .length >4 && userEmailvalue.length <40){
					console.log('valid email');
					document.geElementById('emailError').innerHTML ='';
					
				}else{ 
					console.log('invalid email');
					document.getElementById('emailError').innerHTML ='Please enter valid email';
				}
				
				const xhttp =new  XMLHttpRequest();
				console.log('running in ajax');
				console.log(userEmailvalue);
				chttp.open("GET","http://localhost:8080/SingIn-project/email/"+userEmailvalue);
				
				xhttp.send();
				xhttp.onload = function(){
				console.log(this);
				document.getElementById("display").innerHTML=this.responseText
				}
			}
				
			function ValidMobile(){
				var userMobile =document.getElementById('userMobile');
				var userMobilevalue=userMobile.value;
				
				console.log(userMobilevallue);
				if(userMobilevalue !-null && userMobilevalue !="" && userMobilevalue.length == 10){
				console.log('valid mobile');
				document.getElementById('mobileError').innerHTML="";
				
				}else{
					console.log('invalid mobile');
					document.getElementById('mobileEror').innerHTML = "Please enter valid mobile number";
				}
				const chttp =new XMLHtpRequest();
				console.log('Running in ajax');
				console.log(userMobilevalue);
				xhttp.open("GET","http://localhost:8080/SingIn-project/mobile/"+userMobilevalue);
				xhttp.send();
				xhttp.onload=function(){
					console.log(this);
					documents.getElementById("displayUserMobile").innerHTML = this.responseText
				}
				
				}
			
		script>
	</div>


</body>
</html> --%>