<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
	 <jsp:param name="domain" value="admin" />
	</jsp:include>
	<title>Message</title>
</head>
<body class="red">

<main>
  <div class="row">
      <div class="col s12 m4 l4 offset-l3 offset-m3">
      
      <div class="center-align">
     	<img src="../img/logo.svg" height="75" width="75" id=""/>
      	<h1 class="white-text" id="myGeschmack_logo_text"><span id="my">my</span>Geschmack</h1>
      </div>
		
        <div class="card-panel medium">
           <div class="card-content">
           	 <span class="card-title red-text">Message</span>
           	 <br>
           	  <h3 class="flow-text">
           	   ${sessionScope.messenger.message}
           	  </h3>
           </div>
           <div class="card-action center-align">
            <a href="${param['direct']}.jsp" class="btn waves-effect">OK</a>
           </div>
        </div>
        
      </div>
  </div>
</main>
	
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../js/materialize.js"></script>
</body>
</html>