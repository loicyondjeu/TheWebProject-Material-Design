<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../jsp_components/linkMetaDependencies.jsp">
    <jsp:param name="domain" value="guest" />
    </jsp:include>
	<title>Speise bewerten</title>
</head>
<body>

<jsp:include page="../jsp_components/guestHeader.jsp"/>

<main>
 <div class="row">
  <div class="col s12 l6">
   <div class="card">
     <div class="card-content">
     <div class="card-title red-text">${sessionScope.toEvaluateMeal.name}#Name</div>
     <h5>Beschreibung</h5>
     <p>${sessionScope.toEvaluateMeal.description}</p>
     <h5>Speisestruktur</h5>
     <p>Suppe: ${sessionScope.toEvaluateMeal.soup}</p>
     <p>Salat: ${sessionScope.toEvaluateMeal.salad}</p>
     <p>Haupspeise: ${sessionScope.toEvaluateMeal.entree}</p>
     <p>Komplement: ${sessionScope.toEvaluateMeal.complement}</p>
     <p>Dessert: ${sessionScope.toEvaluateMeal.dessert}</p>
     <h5>Gesundheitsdaten</h5>
     <p>Energie: ${sessionScope.toEvaluateMeal.energy}</p>
     <p>Protein: ${sessionScope.toEvaluateMeal.protein}</p>
     <p>Fett: ${sessionScope.toEvaluateMeal.fat}</p>
     <p>Kohlenhydrate: ${sessionScope.toEvaluateMeal.carbs}</p>
     <h5>Bisherige Bewertungen</h5>
     <p>Anzahl der Sterne: ${sessionScope.toEvaluateMeal.stars}</p>
     <p>Anzahl der Bewertungen: ${sessionScope.toEvaluateMeal.name}</p>
     <h5>Kommentare</h5>
     <p>Anzahl der Sterne: ${sessionScope.toEvaluateMeal.stars}</p>
     <p>Anzahl der Bewertungen: ${sessionScope.toEvaluateMeal.name}</p>
    </div>
   </div>
  </div>
  <div class="col s12 l6">
   <div class="card">
    <div class="card-content">
     <div class="card-title red-text">Speise bewerten</div>
     
     <form action="../saveMealEvaluation" method="get">
     <input type="hidden" name="evaluated" value="${sessionScope.toEvaluateMeal.meal_id}"/>
     
      <div class="row">
       <div class="range-field">
        <div class="col s4 m4 l12">
         <label for="taste">Geschmack</label>
         <input type="range" id="taste" name="taste" value="" min="0" max="10" />
        </div>
       </div>
       <br/>
      </div>
      
      <div class="row">
       <div class="range-field">
        <div class="col l12">
         <label for="freshness">Frische</label>
         <input type="range" id="freshness" name="freshness" value="" min="0" max="10" />
        </div>
       </div>
       <br/>
      </div>  
          
      <div class="row">
       <div class="range-field">
        <div class="col l12">
         <label for="serving_size">Portionsgröße</label>
         <input type="range" id="variety" name="serving_size" value="" min="0" max="10" />
        </div>
       </div>
       <br/>
      </div>   
      
          <div class="row">
            <div class="col s12">
	         <input name="vegetarian" type="checkbox" id="vegetarian" value="vegetarian"/>
             <label for="vegetarian">Das ist mein Geschmack !</label>
            </div>
            <br/>
         </div>
         
         <div class="row">
           <div class="input-field col s12">
              <textarea name="comment" id="comment" class="materialize-textarea"></textarea> 
              <label for="comment">Dein Kommentar</label>
            </div>
         </div>

      <br/>
      <br/>
      <div class="input-field">
       <button type="submit" class="btn" name="bewerten" value="bewerten"><i class="material-icons right">send</i>Bewertung senden</button>
      </div>
     </form>
    </div>
   </div>
  </div>
 </div>
</main>

 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
 
 
</body>
</html>