<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ausgabe anlegen</title>
</head>
<body>

	<form action="../createAusgabe" method="post">
	Ausgabe anlegen
	<hr/>
	Ausgabetyp:<input type="radio" name="ausgabetyp" value="vollkost"/>vollkost<input type="radio" name="ausgabetyp" value="vegetarisch"/>vegetarisch<br/>
	Suppe:<input type="text" name="suppe" value=""/><br/>
	Hauptspeise:<input type="text" name="hauptspeise" value=""/><br/>
	Salat:<input type="text" name="salat" value=""/><br/>
	Komplement:<input type="text" name="komplement" value=""/><br/>
	Dessert:<input type="text" name="dessert" value=""/><br/>
	<hr/>
	<input type="submit" name="anlegen" value="anlegen"/>
	</form>
	
</body>
</html>