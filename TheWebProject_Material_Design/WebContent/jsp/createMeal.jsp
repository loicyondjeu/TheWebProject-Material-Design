<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Speise anlegen</title>
</head>
<body>

	<form action="../createMeal" method="post">
	Speise anlegen
	<hr/>
	Name:<input type="text" name="name" value=""/><br/>
	Hauptspeise:<input type="text" name="entree" value=""/><br/>
	<br/>
	<input type="checkbox" name="vegetarian" value="vegetarian"/>Speise ist vegetarisch<br/>
	
	Beschreibung<br>
	<textarea rows="10" cols="10" name="description"></textarea>
	
	<hr/>
	Gesundheitsdaten
	<hr/>
	Energie<input type="number" name="energy" value=""/>kcal<br/>
	
	<!--  Eiweiß<input type="number" name="protein" value=""/>kcal<br/>
	Fett<input type="number" name="fat" value=""/>kcal<br/>
	Kohlenhydrate<input type="number" name="carbs" value=""/>g<br/>  -->
	
	Vitamins:
	<input type="checkbox" name="v1" value="vA"/>A
	<input type="checkbox" name="v2" value="vB1"/>B1
	<input type="checkbox" name="v3" value="vB2"/>B2
	<input type="checkbox" name="v4" value="vC"/>C
	<input type="checkbox" name="v5" value="vD"/>D
	
	<!--  <hr/>
	Struktur
	<hr/>
	Suppe:<input type="text" name="soup" value=""/><br/>
	Hauptspeise:<input type="text" name="entree" value=""/><br/>
	Komplement:<input type="text" name="complement" value=""/><br/>
	Salat:<input type="text" name="salad" value=""/><br/>
	Dessert:<input type="text" name="dessert" value=""/><br/>
	 -->
	 
	<hr/>
	Allergien
	<hr/>
	<textarea rows="10" cols="10" name="allergies"></textarea>
	
	<input type="submit" name="create" value="anlegen"/>
	</form>
</body>
</html>