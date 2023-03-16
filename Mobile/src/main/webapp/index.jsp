<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%-- <% if(session.getAttribute("name")==null){
		response.sendRedirect("index");
	
	}	%> this using in direclty in index page using java  --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mani Mobiles</title>
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

	<!-- <style type="text/css">
			body {
			background-image: 
			url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuSCAApWHFM6eCMDUkGcGgXm5GgB29Nd02DQ&usqp=CAU");
			background-position: inherit;
			}	
		</style>
		 -->
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5hLacfhlnTGv3fDvLEJd8pkvFM85ZJCFoKg&usqp=CAU"
				width="80" height="60">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
	 	<!-- Example single danger button -->
<div class="btn-group">
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Click to All Pages
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="mobile" class="form-control me-0"style='color: blue'>Mobile</a>
    <a class="dropdown-item" href="MobileSearch.jsp" class="form-control me-0"style='color: blue'>SearchByID</a>
    <a class="dropdown-item" href="SearchByName.jsp" class="form-control me-0"style='color: blue'>SearchByName</a>
    <a class="dropdown-item" href="Updated.jsp" class="form-control me-0"style='color: blue'>Updated Page</a>
    <a class="dropdown-item" href="Delete.jsp" class="form-control me-0"style='color: blue'>Deleted Page</a>
    <a class="dropdown-item" href="SearchNameBybrandName.jsp" class="form-control me-0"style='color: blue'>SearchByNameByBrandName Page</a>
    <a class="dropdown-item" href="FindAll.jsp" class="form-control me-0"style='color: blue'>FindAll Page</a>
    <a class="dropdown-item" href="ImageUpload.jsp" class="form-control me-0"style='color: blue'>UploadImage Page</a>
    <a class="dropdown-item" href="DisplayImage.jsp" class="form-control me-0"style='color: blue'>DisplayImage Page</a>
    
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#"></a>
  </div>
</div> 
			


			<!-- <form class="d-flex">

				<a href="mobile" class="form-control me-0" style='color: OrangeRed'>Mobiles</a>
				<br>
				 <a href="MobileSearch.jsp" class="form-control me-0"style='color: OrangeRed'>SeearchByID</a> 
				<br>	
				<a href="SearchByName.jsp"class="form-control me-0" style='color: OrangeRed'>SearchByName</a>
					
				<br> 
				<a href="Updated.jsp" class="form-control me-0"style='color: OrangeRed'>Updated</a>
				<br>	
				<br> <a href="Delete.jsp" class="form-control me-0"style='color: OrangeRed'>Delete</a>
				<br> <a href="SearchNameBybrandName.jsp" class="form-control me-0"style='color: OrangeRed'>SearchByNameByBrandName</a>
			</form>

 -->
		</div>
	</nav>

	<marquee>
		<h1 style="color: Lime">Welcome to P K Mani Mobile</h1>
	</marquee>



	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<style>
	
	
/* Make the image fully responsive */
.carousel-inner img {
	width: 80%;
	height: 10%;
}
</style>
</head>
<body>

	<div class="container mt-3">

		<h2 align="center" style="color: crimson">P K Mani Mobiles</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">

			<!-- Indicators Slide the Seconds one by one -->
			<ul class="carousel-indicators">
				<li data-target="Redmi Mobile " data-slide-to="0" class="active"></li>
				<li data-target="I-Phone" data-slide-to="1"></li>
				<li data-target="Samsung" data-slide-to="2"></li>
				<li data-target="I-Phone" data-slide-to="3"></li>
			</ul>

			<!-- The slideshow Images Steps-->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61dVlTwBKcL._SY550_.jpg" 
						alt="Chennai Sdadium" width="1100" height="80">
				</div>
				<div class="carousel-item">
					<img
						src="https://m.media-amazon.com/images/I/71AvQd3VzqL._SL1500_.jpg"
						alt="Chennai Sdadium" width="21000" height="80">
				</div>
				<div class="carousel-item">
					<img
						src="https://m.media-amazon.com/images/I/612nLX+2vbL._AC_UF640,640_SR640,640_.jpg"
						alt="HydraBhath Stadium" width="21000" height="80">
				</div>
			</div>

			<!-- Left and right controls Steps -->
			<a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#myCarousel"
				data-slide="next"> <span class="carousel-control-next-icon"></span>
			</a>
		</div>

	</div>


</body>


</html>