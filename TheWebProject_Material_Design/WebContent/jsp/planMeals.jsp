<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Speiseplan erstellen</title>
</head>
<body>

	<form action="../planMeals" method="get">
		Kalenderwoche<input type="number" name="weekNum" value=""/><br/>
		Jahr<input type="number" name="year" value=""><br/>
		<select name="day">
			<option value="monday">Montag</option>
		</select>
		<br/>
		<select name="type">
			<option value="vegetarian">vegetarisch</option>
			<option value="vollkost">vollkost</option>
		</select>
		<input type="submit" name="submit" value="auswaehlen"/><br/>
		<br/>
		<input type="submit" name="submit" value="auswaehlen"/><br>
		<input type="submit" name="submit" value="planerstellen">
	</form>

	
</body>
</html>