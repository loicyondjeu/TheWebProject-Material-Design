<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../jsp_components/linkMetaDependencies.jsp">
   <jsp:param name="domain" value="guest" />
  </jsp:include>
  <title>Speisepläne</title>
</head>
<body class="white">

<jsp:include page="../jsp_components/guestHeader.jsp"/>

<main>

 <div class="col s12 m12">
  <h1 class="red-text center-align">Dein Speiseplan</h1>
 </div>

  <div class="row white">
  
   <div class="col s12 m12 l12">
    <h1 class="red-text center-align">Heute in deiner Mensa</h1>
   </div>
   
   <div class="col s12 m6 l6">
   	<h3 class="red-text center-align">Vegetarisch</h3>
    <div class="card">
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="../img/logo.svg" height="300" width="300" id=""/>
     </div>
     <div class="card-content">
      <span class="card-title activator">${applicationScope.todaymeals[0].name} #HierTodayMeal<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.todaymeals[0].name} #HierTodayMeal<i class="material-icons right">close</i></span>
       <p>${applicationScope.todaymeals[0].description} #HierTodayMeal</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="evaluateMeal?meal=0">bewerten</a></p>
     </div>
    </div>
   </div>
   
   <div class="col s12 m6 l6">
    <h3 class="red-text center-align">Vollkost</h3>
    <div class="card">
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="../img/logo.svg" height="300" width="300" id=""/>
     </div>
     <div class="card-content">
      <span class="card-title activator">${applicationScope.todaymeals[0].name} #HierTodayMeal<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.todaymeals[0].name} #HierTodayMeal<i class="material-icons right">close</i></span>
       <p>${applicationScope.todaymeals[0].description} #HierTodayMeal</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="evaluateMeal?meal=1">bewerten</a></p>
     </div>
    </div>
   </div>
   
  </div>


  <div class="row white">
  
   <div class="col s12 m12 l12">
    <h1 class="red-text center-align">Morgen in deiner Mensa</h1>
   </div>
   
   <div class="col s12 m6 l6">
   	<h3 class="red-text center-align">Vegetarisch</h3>
    <div class="card">
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="../img/logo.svg" height="300" width="300" id=""/>
     </div>
     <div class="card-content">
      <span class="card-title activator">${applicationScope.tomorrowmeals[0].name} #Hiertomorrowmeal<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.tomorrowmeals[0].name} #Hiertomorrowmeal<i class="material-icons right">close</i></span>
       <p>${applicationScope.tomorrowmeals[0].description} #Hiertomorrowmeal</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="evaluateMeal?meal=0">bewerten</a></p>
     </div>
    </div>
   </div>
   
   <div class="col s12 m6 l6">
    <h3 class="red-text center-align">Vollkost</h3>
    <div class="card">
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="../img/logo.svg" height="300" width="300" id=""/>
     </div>
     <div class="card-content">
      <span class="card-title activator">${applicationScope.tomorrowmeals[0].name} #Hiertomorrowmeal<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.tomorrowmeals[0].name} #Hiertomorrowmeal<i class="material-icons right">close</i></span>
       <p>${applicationScope.tomorrowmeals[0].description} #Hiertomorrowmeal</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="evaluateMeal?meal=1">bewerten</a></p>
     </div>
    </div>
   </div>
   
  </div>
    
</main>

 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
</body>
</html>