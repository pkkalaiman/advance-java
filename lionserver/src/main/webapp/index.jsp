<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<body  leftmargin="500px" marginheight="120px" style='background-color:white(0,234,343)'>

<h1 style='color:Coral'>Lion jsp File</h1>

<form action="ManiServlet" method="post">
<pre>
FirstName<input type="text" name="fName"/><br>
LastName<input type="text" name="lName"><br>
Gender<input type="radio" name="Gender" value="Male">Male
	  <input type="radio" name="Gender" value="Female">Female
	  <input type="radio" name="Gender" value="Others">Others<br>
Reason<textarea rows="4" cols="10"name="reason"></textarea><br>
Address<textarea rows="5" cols="15" name="address"></textarea><br>


</pre>

	<input type="submit" name="send" style='color:green'>
</form>

</body>
</html>