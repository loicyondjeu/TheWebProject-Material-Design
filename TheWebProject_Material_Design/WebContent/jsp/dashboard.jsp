<%@page import="de.hs_lu.mensa.helpers.ApplicationManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
	 <jsp:param name="domain" value="admin" />
	</jsp:include>
	<title>Willkommen</title>
</head>

<body class="grey">

<%

ApplicationManager.setUpStatistics(application);

%>

 <jsp:include page="../jsp_components/adminHeader.jsp"/>

<main>

 <div class="row">
   <div class="col l6 m6 s12">
    <div class="card-panel hoverable teal white-text">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Speisen</h5>
     <h1>${applicationScope.statistics.numberOfMeals}</h1>
    </div>
   </div>
   <div class="col l6 m6 s12">
    <div class="card-panel hoverable teal white-text">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h1>${applicationScope.statistics.numberOfUsers}</h1>
    </div>    
   </div>
 </div>
 
 <div class="row">
   <div class="col l12 m12 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl der Bewertungen</h5>
     <h1>${applicationScope.statistics.numberOfEvaluationOveral}</h1>
    </div>   
   </div>
   
      <div class="col l4 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Davon für die Einzelbewertungen</h5>
     <h1>${applicationScope.statistics.numberOfEvaluationNormal}</h1>
    </div>     
   </div>
   <div class="col l4 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Davon die schnelle Bewertungen</h5>
     <h1>${applicationScope.statistics.numberOfEvaluationQuick}</h1>
    </div>     
   </div>
   <div class="col l4 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Davon für die Mensa Bewertungen</h5>
     <h1>${applicationScope.statistics.numberOfRefectoryEvaluations}</h1>
    </div>     
   </div>
 </div>
 

 
 
   <div class="row">
   <div class="col l3 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h3>${applicationScope.statistics.avg_quality} / 10</h3>
    </div>     
   </div>
   <div class="col l3 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h3>${applicationScope.statistics.avg_diversity} / 10</h3>
    </div>     
   </div>
   <div class="col l3 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h3>${applicationScope.statistics.avg_variety} / 10</h3>
    </div>     
   </div>
   <div class="col l3 m6 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h3>${applicationScope.statistics.avg_serving_size} / 10</h3>
    </div>     
   </div>   
 </div>
 
  <div class="row">
   <div class="col l12 m12 s12">
    <div class="card-panel hoverable teal white-text center-align">
     <i class="material-icons large">local_pizza</i>
     <h5>Anzahl von Users</h5>
     <h3>${applicationScope.statistics.avg} / 10</h3>
    </div>   
   </div>
 </div>
 
</main>

<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
</body>
</html>