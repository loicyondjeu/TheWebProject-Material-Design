<%@page import="de.hs_lu.mensa.model.Meal"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Speise auswählen</title>
</head>
<body>
	<h1>Speise suchen</h1>
	<hr>
	<form action="../findMeal" method="get">
		Name:<input type="text" name="name" value=""><br/>
		Note:<input type="number" name="avg_eval" value=""><br/>
		<input type="checkbox" name="vegetarian" value="vegetarian"/>vegetarisch<br/>
		Kalorien<input type="number" name="calories" value=""/><br/>
		<input type="submit" name="submit" value="suchen"/><input type="reset"/>
	</form>
	<%
	String submit =(String)request.getAttribute("submit");
	List<Meal> meals;
	
	if(submit!=null ){ 
		meals=(List<Meal>)request.getAttribute("meals");
	%>
	<div>
		<table>
			<thead>
				<tr>
					<th>Name</th><th>Image</th>
				</tr>
			</thead>
			<tbody>
			<% for(Meal meal:meals) {%>
				<tr>
					<td><%=meal.getName() %></td><td><img  src="<%=meal.getImage() %>"> </td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<% } %>
</body>
</html>