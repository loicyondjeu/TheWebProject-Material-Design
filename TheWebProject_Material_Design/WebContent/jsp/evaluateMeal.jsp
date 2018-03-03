<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Speise bewerten</title>
</head>
<body>
	<h1>Meal</h1>
	<form action="../evaluateMeal" method="post">
		Meal_ID<input type="number" name="meal_id" value=""><br/>
		Anzahl der Sterne<input type="number" name="stars" value=""><br/>
		emoticon:
			<select name="emoticon">
				<option value="angry">angry</option>
				<option value="happy">happy</option>
				<option value="super">super happy</option>
			</select><br/>
		dein Kommentar:<br/>
		<textarea name="comment" rows="10" cols="30"></textarea>
		<br/>
		<input type="submit" value="bewerten"/>
	</form>
</body>
</html>