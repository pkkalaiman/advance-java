<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<body>


	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
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

			<!-- <form class="d-flex">
				<a href="casino.jsp" class="form-control me-0" style='color: OrangeRed'>Casino</a> 
				<a href="Beach.jsp" class="form-control me-0" style='color: OrangeRed'>Beach</a> 
			</form> -->
		</div>
	</nav>


	<h1 style="color: blue">Welcome to PK Mani</h1>

	<form action="mani" method="get">
		<input type="submit" value="Show Email" />
		<h6>Display eMail :${eMail}</h6>
	</form>

	<form action="mobile" method="get">
		<input type="submit" value="Show Mobile" />
		<h6>Display MobileNo :${MobileNo}</h6>
	</form>

	<form action="Aadhar" method="get">
		<input type="submit" value="Show Aadhar" />
		<h6>Display AadharNo :${AadharNo}</h6>
	</form>

	<form action="Age" method="get">
		<input type="submit" value="Show Age" />
		<h6>Display Age :${Age}</h6>
	</form>

	<form action="DOB" method="get">
		<input type="submit" value="Show DOB" />
		<h6>Display DOB$Time :${DateOfBirthAndTime}</h6>
	</form>

	<form action="Salary" method="get">
		<input type="submit" value="Show Salary" />
		<h6>Display DerivedSalary :${FixedSalary}</h6>
	</form>


	<!-- MY BEST FRIENDS SHOWING  IN JSP-->
	
	<form action="best">
		<input type="submit" value="Show best" />
		<h6 style="color: yellow">Display Friends :</h6>
		<ul>
			<c:forEach items="${BestFriends}" var="var">
				<li>${var}</li>
			</c:forEach>
		</ul>
	</form>


	<!-- MOST VISITING PLACESS IN JSP -->
	
	<form action="onvist">
		<input type="submit" value="Show Places">
		<h6 style="color: blue">Display Visiting Place :</h6>
		<ul>
			<c:forEach items="${VisitPlace}" var="placesss">
				<li>${placesss}</li>
			</c:forEach>
		</ul>
	</form>

	<!-- MY SKILL SET DISPLAY JSP -->

	<form action="SkillSet">
		<input type="submit" value="Show Skills">
		<h6 style="color: green">Display SkillSet :</h6>
		<c:forEach items="${SkillSet}" var="Skil">
			<li>${Skil}</li>
		</c:forEach>
	</form>

	<!-- EDUCATIONDTO JSP -->

	<form action="DTO">
		<input type="submit" value="Show EducationDTO">
		<h6 style="color: green">Display EducationDTO :</h6>
		<label> ${Education.name}</label><br>
		<label>${Education.id}</label><br>
		<label> ${Education.dateOfBirth}</label><br>
		<label>${Education.deportment}</label><br>
		
	</form>


	<!-- FAMILYDTO IN JSP -->

	<form action="FamilyDto" method="get">
		<input type="submit" ${Family} value="Show FamilyDto">
		<h6 style="color: green">Display FamilyDto :</h6>
		<label>FatherName: ${Family.fatherName}</label><br>
		<label>Age: ${Family.fatherAge}</label><br>
		<label>MotherName: ${Family.motherName}</label><br>
		<label>Age: ${Family.motherAge}</label><br>
		<label>sisterName: ${Family.sisterName}</label><br>
		<label>Age: ${Family.sisterAge}</label><br>
		<label>BrotherName: ${Family.brotherName}</label><br>
		<label>Age: ${Family.brotherAge}</label><br>
		<label>GramaName: ${Family.gramaName}</label><br>
		<label>Age: ${Family.granmaaAge}</label><br>
		<label>GranpaAge: ${Family.granpaaName}</label><br>
		<label>Age: ${Family.granpaAge}</label>
	</form>

	<!-- MOBILEDTO IN JSP -->

	<form action="Redmi">
		<input type="submit" value="Show Mobile">
		<h6 style="color: green">Display MobileDto :</h6>
		<label>${OPPO.name}</label><br>
		<label>${OPPO.price}</label><br>
		<label>${OPPO.model}</label><br>
		<label>${OPPO.version}</label><br>
		<label>${OPPO.ram}</label><br>
	</form>

	<!-- BEVERAGEDTO IN JSP -->

	<form action="Beverage">
		<input type="submit" value="Show Beverage">
		<h6 style="color: green">Display BeverAge :</h6>
		<label>${CocaCola.cocaCola}</label><br>
		<label>${CocaCola.blender}</label><br>
		<label>${CocaCola.carbonated}</label><br>
		<label>${CocaCola.hospitality}</label><br>
		<label>${CocaCola.proteinshake}</label><br>
		<label>${CocaCola.shake}</label><br>
		<label>${CocaCola.thirstquenching}</label><br>
		<label>${CocaCola.sundowner}</label><br>
	</form>

	<!-- CHATINGDTO IN JSP -->
	
	<form action="Chating">
		<input type="submit" value="Show ChatingDTO">
		<h6 style="color: green">Display BeverAge :</h6>
		<label>${Group.name}</label><br>
		<label>${Group.noOfChating}</label><br>
		<label>${Group.noOfGroups}</label><br>
		<label>${Group.wichgroup}</label><br>
		<label>${Group.friends}</label><br>
		<label>${Group.offlineChating}</label><br>
		<label>${Group.onlineChating}</label><br>
		<label>${Group.funnyChating}</label><br>
		<label>${Group.collageGroup}</label><br>
	</form>


</body>
</html>