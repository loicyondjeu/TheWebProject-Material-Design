<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mensa bewerten</title>
</head>
<body>

	<form action="../evaluateRefectory" method="post">
	Mensa bewerten
	<hr/>
	Qualität
	<input type="radio" name="quality" value="1"/>sehr gut
	<input type="radio" name="quality" value="2"/>gut
	<input type="radio" name="quality" value="3"/>nicht schlecht
	<input type="radio" name="quality" value="4"/>schlecht<br/>
	
	Vielfalt
	<input type="radio" name="diversity" value="1"/>sehr gut
	<input type="radio" name="diversity" value="2"/>gut
	<input type="radio" name="diversity" value="3"/>nicht schlecht
	<input type="radio" name="diversity" value="4"/>schlecht<br/>
	
	Abwechlsung
	<input type="radio" name="variety" value="1"/>sehr gut
	<input type="radio" name="variety" value="2"/>gut
	<input type="radio" name="variety" value="3"/>nicht schlecht
	<input type="radio" name="variety" value="4"/>schlecht<br/>
	
	Portionsgröße
	<input type="radio" name="serving_size" value="1"/>zu viel
	<input type="radio" name="serving_size" value="2"/>viel
	<input type="radio" name="serving_size" value="3"/>angemessen
	<input type="radio" name="serving_size" value="4"/>zu wenig<br/>
	
	<input type="submit" name="bewerten" value="bewerten"/>
	</form>
	
</body>
</html>