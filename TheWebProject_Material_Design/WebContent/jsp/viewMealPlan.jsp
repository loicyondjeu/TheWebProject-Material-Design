<%@page import="de.hs_lu.mensa.helpers.ApplicationManager"%>
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

<%
   ApplicationManager.setUpTodayMeals(application);
   ApplicationManager.setUpTomorrowMeals(application);
%>


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
     <!--   ${tmv =  applicationScope.todayMealVegetarian} -->
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="${not empty tmv ? tmv.image:'../img/logo.svg'}" height="300" width="300" id=""/>
     </div>
     
     <div class="card-content">
      <span class="card-title activator">
       ${not empty tmv ? tmv.name : 'Keine Speise für heute geplant :(' }
       <i class="material-icons right">add</i>
      </span>
     </div>
     
     <div class="card-reveal">
      <span class="card-title">${tmv.name}<i class="material-icons right">close</i></span>
      <p>${tmv.description}</p> 
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=normal" ${not empty tmv ? '':'disabled'}> bewerten </a>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=quick" ${not empty tmv ? '':'disabled'}>Schnell bewerten</a>
     </div>
     
    </div>
    
    
   </div>
   
   <div class="col s12 m6 l6">
    <h3 class="red-text center-align">Vollkost</h3>
    
    <div class="card">
     <!--   ${tmo =  applicationScope.todayMealVollkost} -->
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="${not empty tmo ? tmo.image:'../img/logo.svg'}" height="300" width="300" id=""/>
     </div>
     
     <div class="card-content">
      <span class="card-title activator">
       ${not empty tmo ? tmo.name : 'Keine Speise für heute geplant :(' }
       <i class="material-icons right">add</i>
      </span>
     </div>
     
     <div class="card-reveal">
      <span class="card-title">
       ${tmo.name}
       <i class="material-icons right">close</i>
      </span>
      <p>${tmo.description}</p>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=normal" ${not empty tmo ? '':'disabled'}> bewerten </a>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=quick" ${not empty tmo ? '':'disabled'}>Schnell bewerten</a>
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
     <!--   ${tmv =  applicationScope.tomorrowMealVegetarian} -->
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="${not empty tmv ? tmv.image:'../img/logo.svg'}" height="300" width="300" id=""/>
     </div>
     
     <div class="card-content">
      <span class="card-title activator">
       ${not empty tmv ? tmv.name : 'Keine Speise für morgen geplant :(' }
       <i class="material-icons right">add</i>
      </span>
     </div>
     
     <div class="card-reveal">
      <span class="card-title">
       ${tmv.name}
       <i class="material-icons right">close</i>
      </span>
      <p>${tmv.description}</p>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=normal" ${not empty tmv ? '':'disabled'}> bewerten </a>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=quick" ${not empty tmv ? '':'disabled'}>Schnell bewerten</a>
     </div>
     
    </div>
    
   </div>
   
   <div class="col s12 m6 l6">
    <h3 class="red-text center-align">Vollkost</h3>
    
    <div class="card">
     <!--   ${tmo =  applicationScope.tomorrowMealVollkost} -->
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="${not empty tmo ? tmo.image:'../img/logo.svg'}" height="300" width="300" id=""/>
     </div>
     
     <div class="card-content">
      <span class="card-title activator">
       ${not empty tmo ? tmo.name : 'Keine Speise für morgen geplant :(' }
       <i class="material-icons right">add</i>
      </span>
     </div>
     
     <div class="card-reveal">
      <span class="card-title">
       ${tmo.name}
       <i class="material-icons right">close</i>
      </span>
      <p>${tmo.description}</p>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=normal" ${not empty tmo ? '':'disabled'}> bewerten </a>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=quick" ${not empty tmo ? '':'disabled'}>Schnell bewerten</a>
     </div>
     
    </div>
    
   </div>
   
  </div>
    
</main>

 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
</body>
</html>