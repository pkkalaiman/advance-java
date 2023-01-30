<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P K Mani</title>
</head>
<body leftmargin="500px" marginheight="250px"  style='background-color: white(0,230,340)'>

<h3 style='color:purple'>Details Sharing</h3>

<form action="MessageServer" method="post">

<pre>

FirstName<input type="text" name="fName"><br>
LaastName<input type="text" name="lName"><br>
Gender<input type="radio" name="Gender" value="Male">Male
	  <input type="radio" name="Gender" value="Female">Female
	  <input type="radio" name="Gender" value="Others">Others<br>
Reason<textarea rows="4" cols="10" name="reason"></textarea><br>
Address<textarea rows="5" cols="20" name="address"></textarea><br><br>
</pre>

<input type="submit" name="send" style='color:green'>

</form>

</body>
</html>