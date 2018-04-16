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
	/* Der App Manager initialisiert die Speisen von dem aus der Datenbank.*/
		/* Sollte keine Verdindung zur DB herstellt werden kann der Start ein sehr dauern (eine bessere Lösung wird gesucht... :)) */
   ApplicationManager.setUpTodayMeals(application);
%>

 <jsp:include page="../jsp_components/guestHeader.jsp"/>


 <main>
 
  <div class="row">
  
   <div class="carousel carousel-slider center">
   
    <div class="carousel-item red white-text">
	 <h3>Bewerte das Getränk in der Mensa</h3>
	 <p>Sag uns einfach wie dir das Essen geschmeckt hat !</p>
	 <i class="material-icons large">directions_bike</i><br/>
	 <a class="btn waves-effect" href="evaluateRefectory.jsp">Zur Bewertung</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h3>Verfolge Speisen</h3>
	 <p>Gib uns deiner E-Mail und lasst dich benachrichtigen für dein Lieblingsessen</p>
	 <i class="material-icons large">find_in_page</i><br/>
	 <a class="btn waves-effect" href="notification.jsp">Sich anmelden</a>
	</div>
	
	<div class="carousel-item red white-text">
	 <h3>Gucke den Speiseplan</h3>
	 <p>Bleibe immer im laufenden über die Ausgaben in deiner Mensa</p>
	 <i class="material-icons large">event</i><br/>
	 <a class="btn waves-effect" href="viewMealPlan.jsp">Zur Speiseplan</a>
	</div>
	
   </div>
   
  </div>
  
  <div class="container">
   <div class="row white">
  
    <div class="col s12 m12 l12">
     <h1 class="red-text center-align">
      Heute
      <span class="teal-text">
	   <script type="text/javascript">
		 function wochentag(i) {
			 var tage = [ 'Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag','Freitag', 'Samstag', 'Sonntag' ];
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
    
      <!-- ACHTUNG Hier wird die Variable der Speise aus Scope der Anwendung deklariert -->
      <!--   ${tmv =  applicationScope.todayMealVegetarian} -->
     
      <div class="card-image waves-effect waves-block waves-light red">
       <img src="${not empty tmv ? tmv.image:'../img/logo.svg'}" height="300" width="300"/> <!-- Wenn es keine Speise zum Anzeige gibt, wird das züruckgegeben -->
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
      <!-- Icons für Angabe vegetarisch, pescetarian und schwein -->
       <div class="row">
        ${tmv.halal ? '<img src="../img/halal.svg" height="30" width="30"/>' : ' '} 
        ${tmv.vegetarian ? '<img src="../img/vegetarian.svg" height="30" width="30"/>' : ' '}                 
       </div> 
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=normal" ${not empty tmv ? '':'disabled'}> bewerten <i class="material-icons right">sentiment_very_satisfied</i> </a>
      <br/><br/>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmv.meal_id}&evaltype=quick" ${not empty tmv ? '':'disabled'}>Schnell bewerten <i class="material-icons right">timer</i></a>
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
      <!-- Icons für Angabe vegetarisch, pescetarian und schwein -->
       <div class="row">
        ${tmo.halal ? '<img src="../img/halal.svg" height="30" width="30"/>' : ' '} 
        ${tmo.vegetarian ? '<img src="../img/vegetarian.svg" height="30" width="30"/>' : ' '}                 
       </div>       
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=normal" ${not empty tmo ? '':'disabled'}> bewerten <i class="material-icons right">sentiment_very_satisfied</i> </a>
      <br/><br/>
      <a class="waves-effect waves-light tooltipped teal btn" data-tooltip="Gehe zu bewertung" href="../evaluateMeal?meal=${tmo.meal_id}&evaltype=quick" ${not empty tmo ? '':'disabled'}>Schnell bewerten <i class="material-icons right">timer</i> </a>
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
	   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1056.6973116017093!2d8.423566803215005!3d49.473468962007026!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4797cc7dbbd596fb%3A0x6c46f7025066f5d0!2sStudierendenwerk+Vorderpfalz+-+Mensa!5e1!3m2!1sen!2sde!4v1518518615723" width="90%" height="280" ></iframe>	
  	  </div>
  	 </div>
  	</div>
  	
  	<div class="col s12 m12 l6">
     <div class="card">
  	  <div class="card-panel large">
  	  	<span class="card-title">Studierendenwerk Vorderpfalz</span>  
  	   	 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d657.1118441782642!2d8.107776950830093!3d49.20451924547957!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x479650604ac64971%3A0x9ba7b24d29669d41!2sStudierendenwerk+Vorderpfalz+A%C3%B6R+-+Zentrale+%2F+Mensa!5e1!3m2!1sde!2sde!4v1520873495617" width="90%" height="280" style="border:0" ></iframe>
  	  </div>
  	 </div>
  	</div>
  	
  </div>

   <div class="row">
   
    <div class="col s12">
     <div class="container">
     
      <h3 class="red-text">Unser Team</h3>
      
      <ul class="collapsible popout" data-collapsible="accordion">
       <li>
        <div class="collapsible-header active"><img src="../img/lm.png" width="50" height="50">Jasmin Moos</div>
        <div class="collapsible-body"><span>Student an HS Ludwigshafen. Verantwortlich für die Datenbankschicht der Applikation. Benutzte MongoDB, MongoDB Atlas, Java, HTML, CSS, Web API,  Materialize, JavaScript, JQuery</span></div>
       </li>
       <li>
        <div class="collapsible-header"><img src="../img/ha.png" width="50" height="50">Haitem Atyaout</div>
        <div class="collapsible-body"><span>Student an HS Ludwigshafen. Verantwortlich für die Präsentationschicht der Applikation. Benutzte HTML, CSS, JavaScript, Web APIs, MongoDB, MongoDB Atlas, Java, Servlet, JSP, Java EE</span></div>
       </li>
       <li>
        <div class="collapsible-header"><img src="../img/lo.png" width="50" height="50">Loic Yondjeu</div>
        <div class="collapsible-body"><span>Student an HS Ludwigshafen. Verantwortlich für die Anwendungschicht der Applikation und den Software Engineering Prozess. (inkl. Deployment). Benutzte MongoDB, MongoDB Atlas, Java, Servlet, JSP, JSP EL, JSTL, Java EE, Microsoft Azure</span></div>
      </li>
     </ul>
     
    </div>
   </div>
    
   </div>  
  
  </div>
  
  <div class="fixed-action-btn">
  
  <a class="btn-floating btn-large red pulse" href="../jsp/evaluateRefectory.jsp">
    <i class="large material-icons">sentiment_very_satisfied</i>
  </a>
  <ul>
    <li><a class="btn-floating teal" href="../jsp/viewMealPlan.jsp"><i class="material-icons">event</i></a></li>
  </ul>
  
</div>

 </main>
    
 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
	
	
</body>
</html>