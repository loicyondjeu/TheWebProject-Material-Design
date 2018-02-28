<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mensa bewerten</title>
</head>
<body>

	<form action="../evaluateMensa" method="post">
	Mensa bewerten
	<hr/>
	Wie findest du die Qualität der Speise im Allgemein:
	<input type="radio" name="quality" value=""/>sehr gut<br/>
	<input type="radio" name="quality" value=""/>gut<br/>
	<input type="radio" name="quality" value=""/>nicht schlecht<br/>
	<input type="radio" name="quality" value=""/>schlecht<br/>
	
	Welche Benotung würdest du deiner Mensa geben?
	<select name="grade">
		<option value="suppe">1,0</option>
		<option value="hauptspeise">2,0</option>
		<option value="salat">3,0</option>
		<option  value="komplement">4,0</option>
		<option value="dessert">5,0</option>
	</select><br/>
	
	Wie würdest du die Vielfalt unseres Angebot bewerten?
	<input type="radio" name="" value=""/>Vielfältig <input type="radio" name="" value=""/>eher nicht
	
	Wie bewertest du die Abwechlsung unseres Angebots?
	<input type="radio" name="variety" value=""/>sehr gut<br/>
	<input type="radio" name="variety" value=""/>gut<br/>
	<input type="radio" name="variety" value=""/>nicht schlecht<br/>
	<input type="radio" name="variety" value=""/>schlecht<br/>
	
	Wie findest du die Portionsgröße?
	<input type="radio" name="variety" value=""/>zu viel<br/>
	<input type="radio" name="variety" value=""/>viel<br/>
	<input type="radio" name="variety" value=""/>angemessen<br/>
	<input type="radio" name="variety" value=""/>zu wenig<br/>
	
	<input type="submit" name="anlegen" value="anlegen"/>
	</form>
	
</body>
</html>