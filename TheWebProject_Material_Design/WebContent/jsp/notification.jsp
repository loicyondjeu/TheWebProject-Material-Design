<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
	<jsp:param name="domain" value="guest" />
	</jsp:include>
	
	<title>Speise Nachverfolgung</title>
</head>
<body>

 <jsp:include page="../jsp_components/guestHeader.jsp"/>

 <div class="container">
  <div class="row">
   <div class="col l12 m12 s12">
    <div class="card-panel">
     <div class="valign-wrapper">
      <h1>Der Dienst wird leider noch nicht angeboten. <br> Haben sie bitte etwas Geduld :)...</h1> 
     </div>
     <a href="index.jsp" class="btn">Zur Homepage</a>
    </div>
   </div>
  </div>
 </div>
 
 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
	
</body>
</html>