<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrieren</title>
</head>
<body>
<form action="../register" method="post">
	username: <input type="text" name="username" value=""/><br/>
	email: <input type="email" name="email" value=""/><br/>
	passwort: <input type="password" name="password" value=""/><br/>
	geschlecht:
	<input type="radio" name="sex" value="male"/> Männlich
	<input type="radio" name="sex" value="female"/> Weiblich
	funktion:
	<select name="function">
		<option value="cook">Koch</option>
		<option value="helper">Küchenhilfe</option>
		<option value="service">Servicemitarbeiter</option>
	</select>
	<br/>
	<input type="submit" value="submit" name="submit"/>
	<input type="reset"/>
</form>
</body>
</html>