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

 <jsp:include page="../jsp_components/adminHeader.jsp"/>

<main>
 <div class="row">
  <div class="col s12 m6 l6">
   <div class="card hoverable center-align">
    <div class="card-content">
      <i class="material-icons large red-text">create</i>
     </div>
     <div class="card-action">
      <a href="createMeal.jsp" class="red-text">Speise erstellen</a>
     </div>
    </div>
   </div>
   <div class="col s12 m6 l6">
   <div class="card hoverable center-align">
    <div class="card-content">
      <i class="material-icons large red-text">event</i>
     </div>
     <div class="card-action">
      <a href="planMeal.jsp" class="red-text">Speise planen</a>
     </div>
    </div>
   </div>
   <div class="col s12 m6 l6">
   <div class="card hoverable center-align">
    <div class="card-content">
      <i class="material-icons large red-text">dashboard</i>
     </div>
     <div class="card-action">
      <a href="dashboard.jsp" class="red-text">Statistiken ansehen</a>
     </div>
    </div>
   </div>
   <div class="col s12 m6 l6">
   <div class="card hoverable center-align">
    <div class="card-content">
      <i class="material-icons large red-text">person</i>
     </div>
     <div class="card-action">
      <a href="register.jsp" class="red-text">User anlegen</a>
     </div>
    </div>
   </div>
 </div>
</main>

<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
</body>
</html>