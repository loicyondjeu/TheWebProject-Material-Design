<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
	 <jsp:param name="domain" value="admin" />
	</jsp:include>
	<title>Anmelden</title>
</head>

<body class="red">

<main>
  <div class="row">
      <div class="col s12 m6 l6 offset-l3 offset-m3">
      
      <div class="center-align">
     	<img src="../img/logo.svg" height="75" width="75" id=""/>
      	<h1 class="white-text" id="myGeschmack_logo_text"><span id="my">my</span>Geschmack</h1>
      </div>
		
        <div class="card medium">
          
           <div class="card-content">
           
           	 <span class="card-title red-text">Anmelden</span>
           	 <br>
           	 
           	 <form class="" action="../signin" method="post" >
           	 
	              <div class="input-field">
	              	<i class="medium material-icons prefix">account_box</i>
	              	<label for="username">Benutzername</label>
	                <input type="text" name="username" id="username" value="${sessionScope.user.username}">
	              </div>
	              <br>
	              
	               <div class="input-field">
	              	<i class="medium material-icons prefix">lock</i>
	              	<label for="password">Passwort</label>
	                <input type="password" name="password" id="password">
	              </div>
	              <br>

	              <div class="input-field">
	                <button class="btn red waves-effect waves-light">Anmelden</button>
	              </div>
	              
             </form>
             
           </div>
           
        </div>
        
      </div>
  </div>
  
</main>
	
<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>

</body>
</html>