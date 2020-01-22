<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing jsp</title>
</head>
<body>
	<h3> Enter some info </h3>
	<form action="ProcessInfo" method="post" >
		<label> First Name :</label>
		<input type="text" name="fname">
		<label> Last Name :</label>
		<input type="text" name="lname">
		<label> phone :</label>
		<input type="text" name="phone">
		<br> <input type="submit" value="send">
	</form>
</body>
</html>