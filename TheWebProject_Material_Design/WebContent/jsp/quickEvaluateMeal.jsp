<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Schnell bewerten</title>
</head>
<body>
	<h1>Meal</h1>
	<form action="../quickEvaluateMeal" method="post">
		Meal_id<input type="number" name="meal_id" value=""/>
		Suppe:
		<input type="radio" name="soup" value="good"/>gut
		<input type="radio" name="soup" value="bad"/>schlecht<br/>
		
		Dessert:
		<input type="radio" name="dessert" value="good"/>gut
		<input type="radio" name="dessert" value="bad"/>schlecht<br/>
		
		Salat:
		<input type="radio" name="salad" value="good"/>gut
		<input type="radio" name="salad" value="bad"/>schlecht<br/>
		
		Hauptspeise:
		<input type="radio" name="entree" value="good"/>gut
		<input type="radio" name="entree" value="bad"/>schlecht<br/>
		
		Komplement:
		<input type="radio" name="complement" value="good"/>gut
		<input type="radio" name="complement" value="bad"/>schlecht<br/>
		
		<input type="submit" value="bewerten"/>
		</form>
</body>
</html>