<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Schnell bewerten</title>
</head>
<body>
	<h1>Meal</h1>
	<form>
		Suppe:<input type="radio" name="eval" value="gut"/>gut<input type="radio" name="eval" value="schlecht"/>schlecht<br/>
		Dessert:<input type="radio" name="eval" value="gut"/>gut<input type="radio" name="eval" value="schlecht"/>schlecht<br/>
		Salat:<input type="radio" name="eval" value="gut"/>gut<input type="radio" name="eval" value="schlecht"/>schlecht<br/>
		Hauptspeise:<input type="radio" name="eval" value="gut"/>gut<input type="radio" name="eval" value="schlecht"/>schlecht<br/>
		Komplement:<input type="radio" name="eval" value="gut"/>gut<input type="radio" name="eval" value="schlecht"/>schlecht<br/>
		<input type="submit" value="bewerten"/>	<input type="submit" value="abbrechen"/>
		</form>
</body>
</html>