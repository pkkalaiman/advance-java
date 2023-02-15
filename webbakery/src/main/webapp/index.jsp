<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<link rel="stylesheet" href="BootStrap.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand"> <img alt="X-Workz" src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" Width="100" height="70"></a>
    <form class="d-flex" role="search">
    </form>
  </div>
</nav>
 <h1 align="center">Welcome to Bakery</h1>
 
 <form action="main" method="post">
 <table>
<tr><td> Name  Bakery</td><td><input type="text" name="bakery.name"></td></tr>
 <tr><td>Name owner owner</td><td><input type="text" name="bakery.ownerName"></td></tr>
 <tr><td>Name OwnerWife</td><td><input type="text" name="bakery.ownerWife"></td></tr>
 <tr><td>Owner Married</td></tr>
 <tr><td><input type="radio" value="true" name="bakery.isMarried">yes</td>
 <td><input type="radio" value="false" name="bakery.isMarried">No</td></tr>
 <tr><td>Bakery Special for</td><td><textarea rows="3" cols="3"></textarea></td></tr>
 <tr><td>Since</td><td><input type="text" name="bakery.since">
 </td>
 </tr>
 <tr><td><input type="submit" value="save">
 </table>
 </form>

</body>
</html>