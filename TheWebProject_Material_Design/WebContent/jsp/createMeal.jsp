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
	Typ:
	<select name="type">
		<option value="suppe">Suppe</option>
		<option value="hauptspeise">Hauptspeise</option>
		<option value="salat">Salat</option>
		<option value="komplement">Komplement</option>
		<option value="dessert">Dessert</option>
	</select><br/>
	<input type="checkbox" name="isVegetarisch" value="isVegetarisch"/>Speise ist vegetarisch<br/>
	Beschreibung<br>
	<textarea rows="10" cols="10" name="description"></textarea>
	<hr/>
	Gesundheitsdaten
	<hr/>
	Energie<input type="number" name="energy" value=""/>kcal<br/>
	Eiweiß<input type="number" name="protein" value=""/>kcal<br/>
	Fett<input type="number" name="fat" value=""/>kcal<br/>
	Kohlenhydrate<input type="number" name="carbs" value=""/>g<br/>
	Vitamins:
	<input type="checkbox" name="vitA" value="vitA"/>A
	<input type="checkbox" name="vitB1" value="vitB1"/>B1
	<input type="checkbox" name="vitB2" value="vitB2"/>B2
	<input type="checkbox" name="vitC" value="vitC"/>C
	<input type="checkbox" name="vitD" value="vitD"/>D
	<hr/>
	Struktur
	<hr/>
	Suppe:<input type="text" name="soup" value=""/><br/>
	Hauptspeise:<input type="text" name="entree" value=""/><br/>
	Komplement:<input type="text" name="complement" value=""/><br/>
	Salat:<input type="text" name="salad" value=""/><br/>
	Dessert:<input type="text" name="dessert" value=""/><br/>
	<hr/>
	Allergien
	<hr/>
	<textarea rows="10" cols="10" name="allergies"></textarea>
	<input type="submit" name="anlegen" value="anlegen"/>
	</form>
</body>
</html>