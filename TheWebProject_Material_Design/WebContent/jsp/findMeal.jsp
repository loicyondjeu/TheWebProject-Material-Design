<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Speise auswählen</title>
</head>
<body>
	<h1>Speise suchen</h1>
	<hr>
	<form action="../findMeal" method="get">
		Name:<input type="text" name="name" value=""><br/>
		Note:<input type="number" name="avg_eval" value=""><br/>
		<input type="checkbox" name="vegetarian" value="vegetarian"/>vegetarisch<br/>
		Kalorien<input type="number" name="calories" value=""/><br/>
		<input type="submit" value="suchen"/><input type="reset"/>
	</form>
</body>
</html>