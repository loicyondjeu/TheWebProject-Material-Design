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
   <div class="card-content">
   <div class="card-title red-text">Speise anlegen</div>
  </div>
  
 <form action="../createMeal" method="post">
 <ul class="stepper horizontal">
 
   <li class="step active">
      <div class="step-title waves-effect">Grunddaten</div>
      <div class="step-content">
         <div class="row">
            <div class="input-field col s12">
               <input type="text" name="name" id="name">
               <label for="name">Name</label>
            </div>
              <div class="input-field col s12">
               <textarea name="description" id="description" class="materialize-textarea"></textarea> 
               <label for="description">Beschreibung</label>
            </div>
         </div> 
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
         </div>
      </div>
   </li>
   
   
   <li class="step">
      <div class="step-title waves-effect">Speisestruktur</div>
      <div class="step-content">
         <div class="row">
            <div class="input-field col s12">
               <input type="text" name="soup" id="soup">
               <label for="soup">Suppe</label>
            </div>
            <div class="input-field col s12">
               <input type="text" name="salad" id="salad">
               <label for="salad">Salat</label>
            </div>
            <div class="input-field col s12">
               <input type="text" name="entree" id="entree">
               <label for="entree">Hauptspeise</label>
            </div>
            <div class="input-field col s12">
               <input type="text" name="complement" id="complement">
               <label for="complement">Komplement</label>
            </div>
            <div class="input-field col s12">
               <input type="text" name="dessert" id="dessert">
               <label for="dessert">Dessert</label>
            </div>                                              
         </div>
         <div class="row">
         </div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>
  
    <li class="step">
      <div class="step-title waves-effect">Gesundheitsdaten</div>
      <div class="step-content">
         <div class="row">
            <div class="col s12">
	         <input name="vegetarian" type="checkbox" id="vegetarian" value="vegetarian"/>
             <label for="vegetarian">Speise ist Vegetarisch</label>
            </div>
            <br/>
            <div class="col s12">
	         <input name="halal" type="checkbox" id="halal" value="halal"/>
             <label for="halal">Speise enthält Schwein</label>
            </div>
            
            <br/>
            
            <div class="input-field col s6">
               <input type="number" name="energy" id="energy">
               <label for="energy">Energie</label>            
            </div>
            <div class="input-field col s6">
               <input type="number" name="protein" id="protein">
               <label for="protein">Proteininhalt</label>               
            </div>
            
            <div class="input-field col s6">
               <input type="number" name="fat" id="fat">
               <label for="fat">Fett</label>            
            </div>
            <div class="input-field col s6">
               <input type="number" name="carbs" id="carbs">
               <label for="carbs">Kohlenhydrate</label>               
            </div>            
            
            <div class="col s12">
	  	     <label>Vitamins</label><br/>
	         <input type="checkbox" id="v1" name="v1" value="A"/>
	         <label for="v1">A</label>
	         <input type="checkbox" id="v2" name="v2" value="B1"/>
	         <label for="v2">B1</label>
	         <input type="checkbox" id="v3" name="v3" value="vB2"/>
	         <label for="v3">B2</label>
	         <input type="checkbox" id="v4" name="v4" value="C"/>
	         <label for="v4">C</label>
	         <input type="checkbox" id="v5" name="v5" value="D"/>
	         <label for="v5">D</label>
            </div>
            
            <br/>
            <div class="input-field col s12">
              <textarea name="allergies" id="allergies" class="materialize-textarea"></textarea>   
	          <label for="allergies">Allergien</label>
            </div>                                              
         </div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>  
   
   
    <li class="step">
      <div class="step-title waves-effect">Planung</div>
      <div class="step-content">
         <div class="row">
            <div class="col s12">
	         <input name="text" class="datepicker" type="text" id="date" value=""/>
             <label for="date">Datum</label>
            </div>                                   
         </div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>  
   
   
   <li class="step">
      <div class="step-title waves-effect">Fertig</div>
      <div class="step-content">
         
         <div class="step-actions">
            <button class="waves-effect waves-dark btn" type="submit">SUBMIT</button>
         </div>
      </div>
   </li>
</ul>
 </form>
 

 </div>
 </div>

  </div>
</main>
     
<jsp:include page="../jsp_components/adminFooter.jsp"/>

<jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>
</body>
</html>