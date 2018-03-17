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

<%
   ApplicationManager.setUpTodayMeals(application);
%>

<jsp:include page="../jsp_components/guestHeader.jsp"/>


 <main>
 
  <div class="row">
  
   <div class="carousel carousel-slider center">
   
    <div class="carousel-item red white-text">
	 <h1>Bewerte das Essen in der Mensa</h1>
	 <p>Sag uns einfach wie dir das Essen geschmeckt hat !</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect" href="evaluateRefectory.jsp">Zur Bewertung</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h1>Verfolge Speisen</h1>
	 <p>Gib uns deiner E-Mail und lasst dich benachrichtigen für dein Lieblingsessen</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect" href="notification.jsp">Sich anmelden</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h1>Gucke den Speiseplan</h1>
	 <p>Bleibe immer im laufenden über die Ausgaben in deiner Mensa</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect" href="viewMealPlan.jsp">Zur Speiseplan</a>
	</div>
	
   </div>
   
  </div>
  
  <div class="row white">
  
   <div class="col s12 m12 l12">
    <h1 class="red-text center-align">
     Heute
     <span class="teal-text">
	  <script type="text/javascript">
		function wochentag(i) {
			var tage = [ 'Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag',
					'Freitag', 'Samstag', 'Sonntag' ];
			var tag = (typeof (i) == 'object') ? i.getDay() : i;
			return tage[tag];
		}
			var datum = new Date();
			var tag = datum.getDay();
			
		    document.write(wochentag(tag) + ", " + datum.getDate() + "." + parseInt(datum.getMonth()+1) + "." + (datum.getYear()+1900));
 		</script>
 	 </span>
    in deiner Mensa
    </h1>
   </div>
   
   <div class="col s12 m6 l6">
   
   	<h3 class="red-text center-align">Vegetarisch</h3>
   	
    <div class="card">
     <!--   ${tmv =  applicationScope.todayMealVegetarian} -->
     <div class="card-image waves-effect waves-block waves-light red">
      <img src="${not empty tmv ? tmv.image:'../img/logo.svg'}" height="300" width="300"/>
     </div>
     
     <div class="card-content">
      <span class="card-title activator">
       ${not empty tmv ? tmv.name : 'Es gibt leider keine Speise heute :(' }
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
       ${not empty tmo ? tmo.name : 'Es gibt leider keine Speise heute :(' }
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
   <h1 class="red-text center-align">Unsere Standorte</h1>
   
  	<div class="col s12 m12 l6">
  	 <div class="card">
  	  <div class="card-panel large">
  	   <span class="card-title">Mensa am Campus</span>
	   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1056.6973116017093!2d8.423566803215005!3d49.473468962007026!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4797cc7dbbd596fb%3A0x6c46f7025066f5d0!2sStudierendenwerk+Vorderpfalz+-+Mensa!5e1!3m2!1sen!2sde!4v1518518615723" width="90%" height="486" ></iframe>	
  	  </div>
  	 </div>
  	</div>
  	
  	<div class="col s12 m12 l6">
     <div class="card">
  	  <div class="card-panel large">
  	  	<span class="card-title">Studierendenwerk Vorderpfalz</span>  
  	   	 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d657.1118441782642!2d8.107776950830093!3d49.20451924547957!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x479650604ac64971%3A0x9ba7b24d29669d41!2sStudierendenwerk+Vorderpfalz+A%C3%B6R+-+Zentrale+%2F+Mensa!5e1!3m2!1sde!2sde!4v1520873495617" width="90%" height="486" style="border:0" ></iframe>
  	  </div>
  	 </div>
  	</div>
  	
  </div>
  
 </main>
    
 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
	
</body>
</html>