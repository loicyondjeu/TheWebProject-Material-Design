<!-- Diese JSP Seite benutzt die JSTL für Zugriff auf Meal Daten -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
	 <jsp:param name="domain" value="admin" />
	</jsp:include>
	<title>Willkommen</title>
</head>

<body class="grey">

<jsp:include page="../jsp_components/adminHeader.jsp"/>

<main>
 <div class="row">
 
  <div class="col s12 m12 l12">
  
   <div class="card">
    <form action="../findMeal" method="get">
    
     <div class="card-content">
     
      <span class="card-title red-text"><i class="material-icons left">event</i>Speise planen</span>
      <br/>
      <div class="container">
	   <div class="col s12">
	   <input name="vegetarian" type="checkbox" id="vegetarian" value="vegetarian"/>
       <label for="vegetarian">Speise sollte Vegetarisch sein</label>
       </div>
       <br/>
       <div class="col s12">
	   <input name="halal" type="checkbox" id="halal" value="halal"/>
       <label for="halal">Speise sollte kein Schwein enhalten</label>
       </div>
	   <br/>
	  </div>
	  
    </div>
     
     <div class="card-action">
     
       <div class="input-field">
	     <input type="submit" name="search" value="suchen" class="btn red waves-effect waves-light">
	     <input type="reset" name="reset" value="leeren" class="btn waves-effect waves-light">
	   </div>
	   
     </div>
     
    </form>
   </div>
   
   <!-- Abfrage der Länge des Ergebnisses -->
   <div class="row">
    <div class="col l12 m12 s12">
     <div class="card panel">
      <div class="container">
       <div class="flow-text">Aktuell <span class="teal-text"> ${not empty sessionScope.mealListSize ? sessionScope.mealListSize : '0'} </span> Speise(n) gefunden </div>      
      </div>
     </div>
    </div>
   </div>
   
  <ul class="collapsible" data-collapsible="accordion">
  
   <!-- ACHTUNG es wird hier mit Hilfe von JSTL auf auf alle Speise des Suchergebnisses iteriert -->
   <c:forEach items="${sessionScope.mealList}" var="meal">
     <li>

      <div class="collapsible-header"><i class="material-icons">restaurant</i>${meal.name}</div>
      
      <div class="collapsible-body white">
       
       <div class="row">
      	<div class="col l3 m12 s12">
         <img src="${meal.image}" class="responsive-img"/>     	
      	</div>
      	<div class="col l9 m12 s12">
         <span>${meal.description}</span>     	
      	</div>
       </div>
       
       <div class="row">
        <table class="bordered">
         <tbody>
          <tr>
           <td>Suppe</td>
           <td>${not empty meal.soup ? meal.soup: 'keine Suppe'}</td>
          </tr>
          <tr>
           <td>Hauptspeise</td>
           <td>${not empty meal.entree ? meal.entree : 'keine Hauptspeise'}</td>          
          </tr>
          <tr>
           <td>Salat</td>
           <td>${not empty meal.salad ? meal.salad : 'kein Salat'}</td>          
          </tr>
          <tr>
           <td>Beilage</td>
           <td>${not empty meal.complement ? meal.complement : 'keine Beilage'}</td>          
          </tr>
          <tr>
           <td>Dessert</td>
           <td>${not empty meal.dessert ? meal.dessert : 'keine Beilage'}</td>          
          </tr>
         </tbody>
        </table>
       </div>
       
       <!-- Icons für Angabe vegetarisch, pescetarian und schwein -->
       <div class="row">
        ${meal.halal ? '<img src="../img/halal.svg" height="30" width="30"/>' : ' '} 
        ${meal.vegetarian ? '<img src="../img/vegetarian.svg" height="30" width="30"/>' : ' '}                 
       </div>
       
       
       <form action="../findMeal" method="get">
        <div class="input-field">
	     <input name="date" class="datepicker" type="text" id="date" value=""/>
         <label for="date">Datum</label>
	    </div>
	    <br/>
        <span class="rigth-align"><button type="submit" class="btn teal" name="choosedMeal" value="${meal.meal_id}">planen<i class="material-icons right">event</i></button></span>
        <span class="rigth-align"><button type="submit" class="btn red" name="deleteMeal" value="${meal.meal_id}">löschen<i class="material-icons right">delete</i></button></span>
	   </form>
       </div>
       
     </li>
   </c:forEach>
   
  </ul>
  </div>
 </div>
</main>
     
<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>

</body>
</html>