<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <form action="../findMeal" method="get">
     <div class="card-content">
      <span class="card-title red-text">Speise planen</span>
      <br/>
      
      <div class="container">

	               <div class="col s12">
	         <input name="vegetarian" type="checkbox" id="vegetarian" value="vegetarian"/>
             <label for="vegetarian">Speise sollte Vegetarisch sein</label>
            </div>
            <br/>
            <div class="col s12">
	         <input name="halal" type="checkbox" id="halal" value="halal"/>
             <label for="halal">Speise sollte kein Schwein enhalten</label>
            </div>
	   <br/>
      
	 </div>
    </div>
     
     <div class="card-action">
       <div class="input-field">
	     <input type="submit" name="search" value="suchen" class="btn red waves-effect waves-light">
	     <input type="reset" name="reset" value="leeren" class="btn waves-effect waves-light">
	   </div>
     </div>
    </form>
   </div>
   
  <ul class="collapsible" data-collapsible="accordion">
   <c:forEach items="${sessionScope.mealList}" var="meal">
     <li>

      <div class="collapsible-header"><i class="material-icons">filter_drama</i>${meal.name}</div>
      <div class="collapsible-body white">
       <span>${meal.description}</span><br/>
       <form action="../findMeal" method="get">
        <div class="input-field">
	    <input name="date" class="datepicker" type="text" id="date" value=""/>
        <label for="date">Datum</label>
	   </div><br/>
       <span class="rigth-align"><button type="submit" class="btn" name="choosedMeal" value="${meal.meal_id}">auswählen</button></span>
	   </form>
       </div>
       
     </li>
   </c:forEach>
  </ul>
  </div>
 </div>
</main>
     
<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>

</body>
</html>