<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ausgabe anlegen</title>
</head>
<body>

	<form action="../createSpeise" method="post">
	Speise anlegen
	<hr/>
	Name:<input type="text" name="suppe" value=""/><br/>
	Typ:
	<select name="typ">
		<option value="suppe">Suppe</option>
		<option value="hauptspeise">Hauptspeise</option>
		<option value="salat">Salat</option>
		<option  value="komplement">Komplement</option>
		<option value="dessert">Dessert</option>
	</select><br/>
	<input type="checkbox" name="isVegetarisch" value="isVegetarisch"/>Speise ist vegetarisch
	<hr/>
	<input type="submit" name="anlegen" value="anlegen"/>
	</form>
	
</body>
</html>