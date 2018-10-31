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
   
    <form action="../userUpdate" method="post">
     <div class="card-content">
      <span class="card-title red-text">Profil bearbeiten</span>
      <br/>
      
      <div class="container">
       <div class="input-field">
	    <i class="medium material-icons prefix">account_box</i>
	    <label for="username">Username</label>
	    <input class="validate" type="text" name="username" id="disabled" disabled value="${sessionScope.user.username}">
	   </div>
	   <br/>
	  
	   <div class="input-field">
	    <i class="medium material-icons prefix">lock</i>
	    <label for="old_password">Altes Passwort</label>
	    <input type="password" name="old_password" id="old_password">
	   </div>
	   <br/>
	   
	   <div class="input-field">
	    <i class="medium material-icons prefix">lock</i>
	    <label for="new_password">Neues Passwort</label>
	    <input type="password" name="new_password" id="new_password">
	   </div>
	   <br/>
	  
	   <div class="input-field">
	    <i class="medium material-icons prefix">email</i>
	    <label for="email">Email</label>
	    <input type="email" name="email" id="email" value="${sessionScope.user.email}">
	   </div>
	   <br/>
      
	 </div>
    </div>
     
     <div class="card-action">
       <div class="input-field">
	     <input type="submit" name="submit" value="speichern" class="btn red waves-effect waves-light">
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