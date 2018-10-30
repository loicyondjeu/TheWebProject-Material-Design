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
  <div class="col s12 m12 l12">
   <div class="card">
   
    <form action="../register" method="post">
     <div class="card-content">
      <span class="card-title red-text">User registrieren</span>
      <br/>
      
      <div class="container">
       <div class="input-field">
	    <i class="medium material-icons prefix">account_box</i>
	    <label for="username">Benutzername</label>
	    <input type="text" name="username" id="username">
	   </div>
	   <br/>
	  
	   <div class="input-field">
	    <i class="medium material-icons prefix">lock</i>
	    <label for="password">Passwort</label>
	    <input type="password" name="password" id="password">
	   </div>
	   <br/>
	  
	   <div class="input-field">
	    <i class="medium material-icons prefix">email</i>
	    <label for="email">Email</label>
	    <input type="email" name="email" id="email">
	   </div>
	   <br/>
	  
	   <input name="sex" type="radio" id="male" value="male"/>
       <label for="male">Männlich</label>
       <input name="sex" type="radio" id="female" value="female"/>
       <label for="female">Weiblich</label>
       <br/>
	  

       <div class="input-field">
    	 <select name="function">
      	  <option value="" disabled selected>Funktion</option>
          <option value="cook">Koch</option>
          <option value="helper">Küchenhilfe</option>
          <option value="service">Servicemitarbeiter</option>
         </select>
      </div>
      
	 </div>
    </div>
     
     <div class="card-action">
       <div class="input-field">
	     <input type="submit" name="submit" value="anmelden" class="btn red waves-effect waves-light">
	     <input type="reset" name="reset" value="leeren" class="btn waves-effect waves-light">
	   </div>
     </div>
    </form>
    
   </div>
  </div>
 </div>
</main>
     
<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>

</body>
</html>