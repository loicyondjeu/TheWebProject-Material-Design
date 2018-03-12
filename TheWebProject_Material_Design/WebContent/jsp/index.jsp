<%@page import="de.hs_lu.mensa.helpers.ApplicationManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../jsp_components/linkMetaDependencies.jsp">
   <jsp:param name="domain" value="guest" />
  </jsp:include>
  <title>Home</title>
</head>

<body class="white">

<%-- <%
   ApplicationManager.setUpTodayMeals(application);
%> --%>

<jsp:include page="../jsp_components/guestHeader.jsp"/>

 <main>
 
  <div class="row">
  
   <div class="carousel carousel-slider center">
   
    <div class="carousel-item red white-text">
	 <h1>Bewerte das Essen deiner Mensa</h1>
	 <p>Sag uns einfach wie dir das Essen geschmeckt hat !</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect" href="evaluateMensa.jsp">Zur Bewertung</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h1>Bewerte deine Mensa</h1>
	 <p>Hilf mit das Essen in deiner Mensa besser zu machen !</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect white grey-text">Zur Bewertung</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h1>Verfolge deiner Lieblingsspeise Speise</h1>
	 <p class="white-text">Gib uns deiner E-Mail und lasst dich benachrichtigen für dein Lieblingsessen</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect white grey-text">Zur Bewertung</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h1>Schaue dir deinen Speiseplan an</h1>
	 <p class="white-text">Bleibe immer im laufenden über die Ausgaben in deiner Mensa</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect white grey-text">Zur Bewertung</a>
	</div>
	
   </div>
   
  </div>
  
  <div class="row white">
  
   <div class="col s12 m12 l12">
    <h1 class="red-text center-align">Heute 
    <!-- JavaScript Code für den Wochentag und das aktuelle Datum  -->
		<script type="text/javascript">
		//Funktion zur Auswahl des korrekten Wochentages
		function wochentag(i){
		    var tage = ['Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag', 'Sonntag'];
		    var tag = (typeof(i) == 'object') ? i.getDay() : i ;
		    return tage[tag];
		}
		var datum = new Date();

		var tag = datum.getDay();
		  var tag = datum.getDay();

		//Ausgabe des Wochentags + Datums
		   document.write(wochentag(tag) + ", " + datum.getDate()+"."+parseInt(datum.getMonth()+1)+"."+(datum.getYear()+1900));
 		</script>
    in deiner Mensa</h1>
   </div>
   
   <div class="col s12 m6 l6">
   	<h3 class="red-text center-align">Vegetarisch</h3>
    <div class="card">
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="../img/logo.svg" height="300" width="300" id=""/>
     </div>
     <div class="card-content">
      <span class="card-title activator">${applicationScope.todayMealVegetarian.name}<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.todayMealVegetarian.name}<i class="material-icons right">close</i></span>
       <p>${applicationScope.todayMealVegetarian.description}</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${applicationScope.todayMealVegetarian.meal_id}&evaltype=normal">bewerten</a>
       <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${applicationScope.todayMealVegetarian.meal_id}&evaltype=quick">Schnell bewerten</a></p>
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
      <span class="card-title activator">${applicationScope.todayMealVollkost.name}<i class="material-icons right">add</i></span>
     </div>
     <div class="card-reveal">
      <span class="card-title">${applicationScope.todayMealVollkost.name}<i class="material-icons right">close</i></span>
       <p>${applicationScope.todayMealVollkost.description} #HierTodayMeal</p>
       <p><a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${applicationScope.todayMealVollkost.meal_id}&evaltype=normal">bewerten</a>
       <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${applicationScope.todayMealVollkost.meal_id}&evaltype=quick">Schnell bewerten</a></p>
     </div>
    </div>
   </div>
  </div>
  
  
  
  <div class="row white">
  	<h1 class="red-text center-align">Unsere Standorte</h1>
  	<div class="col s12 m6 l6">
  	 <div class="card">
  	  <div class="card-panel large">
  	  	<span class="card-title">Mensa am Campus</span>
			 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1056.6973116017093!2d8.423566803215005!3d49.473468962007026!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4797cc7dbbd596fb%3A0x6c46f7025066f5d0!2sStudierendenwerk+Vorderpfalz+-+Mensa!5e1!3m2!1sen!2sde!4v1518518615723" width="500" height="486" style="border:0"></iframe>
			
  	  </div>
  	 </div>
  	 
  	</div>
  	<div class="col s12 m6 l6">
     <div class="card">
  	  <div class="card-panel large">
  	  	<span class="card-title">Studierendenwerk Vorderpfalz</span>  
  	   	 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d657.1118441782642!2d8.107776950830093!3d49.20451924547957!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x479650604ac64971%3A0x9ba7b24d29669d41!2sStudierendenwerk+Vorderpfalz+A%C3%B6R+-+Zentrale+%2F+Mensa!5e1!3m2!1sde!2sde!4v1520873495617" width="500" height="486" style="border:0" ></iframe>
  	  </div>
  	 </div>
  	</div>
  </div>
  
 </main>
    
 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
	
</body>
</html>