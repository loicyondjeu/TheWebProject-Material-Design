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
 
  <!-- ACHTUNG Hier wird die Variable der Speise aus Scope der Session deklariert -->
  <!--   ${meal = sessionScope.toEvaluateMeal} -->
  <div class="col s12 l6">
   <div class="card-panel">
    <div class="card-content">
     <div class="card-title red-text"><h5><i class="material-icons left">restaurant</i>${meal.name}</h5></div>
     <br/>
     <div class="row">
      <div class="col l3 m12 s12">
       <img src="${meal.image}" class="responsive-img"/>     	
      </div>
      <div class="col l9 m12 s12">
       <span>${meal.description}</span>     	
      </div>
     </div>
     
     <h5>Speisestruktur</h5>
     
     <div class="row">
      <table class="bordered">
       <tbody>
        <tr>
         <td>Suppe</td>
         <td>${not empty meal.soup ? meal.soup: 'keine Suppe'}</td>
        </tr>
        <tr>
         <td>Hauptspeise</td>
         <td>${not empty meal.entree ? meal.entree : 'keine Hauptspeise'}</td>          
        </tr>
        <tr>
         <td>Salat</td>
         <td>${not empty meal.salad ? meal.salad : 'kein Salat'}</td>          
        </tr>
        <tr>
         <td>Beilage</td>
         <td>${not empty meal.complement ? meal.complement : 'keine Beilage'}</td>          
        </tr>
        <tr>
         <td>Dessert</td>
         <td>${not empty meal.dessert ? meal.dessert : 'keine Beilage'}</td>          
        </tr>
       </tbody>
      </table>
     </div>
     
     
     <h5>Gesundheitsdaten</h5>
     
     <div class="row">
      <table class="bordered">
       <tbody>
        <tr>
         <td>Energie</td>
         <td>${not empty meal.energy ? meal.energy: 'keine Angabe'} kcal</td>
        </tr>
        <tr>
         <td>Protein</td>
         <td>${not empty meal.protein ? meal.protein : 'keine Angabe'} g</td>          
        </tr>
        <tr>
         <td>Fett</td>
         <td>${not empty meal.fat ? meal.fat : 'keine Angabe'} g</td>          
        </tr>
        <tr>
         <td>Kohlenhydrate</td>
         <td>${not empty meal.carbs ? meal.carbs : 'keine Angabe'} kcal</td>          
        </tr>
       </tbody>
      </table>
     </div>     
     
     <div class="section">
      <h5>Bisherige Bewertungen</h5>
      <p>Anzahl der Sterne: ${meal.stars}</p>            
     </div>
     
     <div class="divider"></div>
     <div class="section">
      <h5>Kommentare</h5>
      <p>Hier wird ein zufälliger Kommentar angezeigt</p>            
     </div>
     
    </div>
   </div>
  </div>
  
  <div class="col s12 l6">
   <div class="card-panel">
    <div class="card-content">
     <div class="card-title red-text"><h5><i class="material-icons left">sentiment_very_satisfied</i>Speise bewerten</h5></div>
     <br/>
     <form action="../saveMealEvaluation" method="get">
     <input type="hidden" name="evaluated" value="${sessionScope.toEvaluateMeal.meal_id}"/>
     
     Hier kannst du Speise bewerten. Gebe einfach mal eine Note für die folgenden Kriterien auf einem Skala von 1 bis 10 :)
     <br/>
     <br/>
     
      <div class="row">
       <div class="range-field">
        <div class="col s4 m4 l12">
         <label for="taste"><i class="material-icons left">sentiment_very_satisfied</i>Geschmack</label>
         <br/>hat es dir geschmeckt ?
         <input type="range" id="taste" name="taste" value="" min="0" max="10" />
        </div>
       </div>
       <br/>
      </div>
      
      <div class="row">
       <div class="range-field">
        <div class="col l12">
         <label for="freshness"><i class="material-icons left">invert_colors</i>Frische</label>
         <br/>Wie frisch war dein Essen ?         
         <input type="range" id="freshness" name="freshness" value="" min="0" max="10" />
        </div>
       </div>
       <br/>
      </div>  
          
      <div class="row">
       <div class="range-field">
        <div class="col l12">
         <label for="serving_size"><i class="material-icons left">room_service</i>Portionsgröße</label>
         <br/>Wie bewertest du deine Portionsgröße ?         
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
              <label for="comment"><i class="material-icons left">create</i>Dein Kommentar</label>
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