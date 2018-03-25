<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../jsp_components/linkMetaDependencies.jsp">
   <jsp:param name="domain" value="guest" />
  </jsp:include>
	<title>Schnell bewerten</title>
</head>

<body class="white">

 <jsp:include page="../jsp_components/guestHeader.jsp"/>

	<div id="content" class="container">
	    <h1 class="red-text">Wie hat es dir geschmeckt ? :)</h1>

	    <form action="../saveQuickMealEvaluation" method="post">
	    <div class="row">
         <div class="col l3 m12 s12">
          <img src="${sessionScope.toEvaluateMeal.image}" class="responsive-img"/>    	
         </div>
         <div class="col l9 m12 s12">
          <div class="container flow-text teal-text">${sessionScope.toEvaluateMeal.name}</div>    	
         </div>         	     
	    </div>
 
	    <input type="hidden" name="meal" value="${sessionScope.toEvaluateMeal.meal_id}"/>
  <ul class="stepper horizontal">
 
   <li class="step active">
      <div class="step-title waves-effect">Salat</div>
      <div class="step-content">
        				<div class="container">
				<div class="center">
					<img src="../images/icons/salad.png" height="150" width="150px"/>
				</div>
				<div class="center"><h2>Wie war dein Salat ?</h2></div>
				<div class="center">
				    <input type="radio" id="salad_bad" name="salad" value="bad"/>
					<label for="salad_bad"><i class="material-icons large teal-text">sentiment_very_dissatisfied</i></label>
					<input type="radio" id="salad_neutral" name="salad" value="neutral"/>
					<label for="salad_neutral"><i class="material-icons large teal-text">sentiment_neutral</i></label>
					<input type="radio" id="salad_good" name="salad" value="good"/>
					<label for="salad_good"><i class="material-icons large teal-text">sentiment_very_satisfied</i></label>
				</div>
				</div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
         </div>
      </div>
   </li>
   
   
   <li class="step">
      <div class="step-title waves-effect">Hauptspeise</div>
      <div class="step-content">
         				<div class="container">
				<div class="center">
					<img src="../images/icons/chicken.png" height="150" width="150px"/>
				</div>
				<div class="center"><h2>Wie war die Hauptspeise ?</h2></div>
				<div class="center">
				    <input type="radio" id="entree_bad" name="entree" value="bad"/>
					<label for="entree_bad"><i class="material-icons large teal-text">sentiment_very_dissatisfied</i></label>
					<input type="radio" id="entree_neutral" name="entree" value="neutral"/>
					<label for="entree_neutral"><i class="material-icons large teal-text">sentiment_neutral</i></label>
					<input type="radio" id="entree_good" name="entree" value="good"/>
					<label for="entree_good"><i class="material-icons large teal-text">sentiment_very_satisfied</i></label>
				</div>
				</div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>
  
    <li class="step">
      <div class="step-title waves-effect">Beilage</div>
      <div class="step-content">
         				<div class="container">
				<div class="center">
					<img src="../images/icons/rice.png" height="150" width="150px"/>
				</div>
				<div class="center"><h2>Wie war die Beilage ?</h2></div>
				<div class="center">
				    <input type="radio" id="complement_bad" name="complement" value="bad"/>
					<label for="complement_bad"><i class="material-icons large teal-text">sentiment_very_dissatisfied</i></label>
					<input type="radio" id="complement_neutral" name="complement" value="neutral"/>
					<label for="complement_neutral"><i class="material-icons large teal-text">sentiment_neutral</i></label>
					<input type="radio" id="complement_good" name="complement" value="good"/>
					<label for="complement_good"><i class="material-icons large teal-text">sentiment_very_satisfied</i></label>
				</div>
				</div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>  
   
   
    <li class="step">
      <div class="step-title waves-effect">Suppe</div>
      <div class="step-content">
				<div class="container">
				<div class="center">
					<img src="../images/icons/soup.png" height="150" width="150px"/>
				</div>
				<div class="center"><h2>Wie war die Suppe ?</h2></div>
				<div class="center">
				    <input type="radio" id="soup_bad" name="soup" value="bad"/>
					<label for="soup_bad"><i class="material-icons large teal-text">sentiment_very_dissatisfied</i></label>
					<input type="radio" id="soup_neutral" name="soup" value="neutral"/>
					<label for="soup_neutral"><i class="material-icons large teal-text">sentiment_neutral</i></label>
					<input type="radio" id="soup_good" name="soup" value="good"/>
					<label for="soup_good"><i class="material-icons large teal-text">sentiment_very_satisfied</i></label>
				</div>
				</div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>
   
   
       <li class="step">
      <div class="step-title waves-effect">Dessert</div>
      <div class="step-content">
<div class="container">
				<div class="center">
					<img src="../images/icons/dessert.png" height="150" width="150px"/>
				</div>
				<div class="center"><h2>Wie war das Dessert ?</h2></div>
				<div class="center">
				    <input type="radio" id="dessert_bad" name="dessert" value="bad"/>
					<label for="dessert_bad"><i class="material-icons large teal-text">sentiment_very_dissatisfied</i></label>
					<input type="radio" id="dessert_neutral" name="dessert" value="neutral"/>
					<label for="dessert_neutral"><i class="material-icons large teal-text">sentiment_neutral</i></label>
					<input type="radio" id="dessert_good" name="dessert" value="good"/>
					<label for="dessert_good"><i class="material-icons large teal-text">sentiment_very_satisfied</i></label>
				</div>
				</div>
         <div class="step-actions">
            <button class="waves-effect waves-dark btn next-step">WEITER</button>
            <button class="waves-effect waves-dark btn-flat previous-step">ZURÜCK</button>
         </div>
      </div>
   </li>  
   
   
   <li class="step">
      <div class="step-title waves-effect">OK</div>
      <div class="step-content">
       <div class="row center-align">
        <i class="material-icons large teal-text">cloud_done</i>
        <h1>Alles Klar</h1>
        <h2>Schicke uns deine Bewertung</h2>        
       </div>
         <div class="step-actions">
            <input type="hidden" name="bewerten" value="bewerten"/>
            <button class="waves-effect waves-dark btn" type="submit" name="bewerten" value="bewerten">BEWERTUNG SCHICKEN<i class="material-icons right">send</i></button>
         </div>
      </div>
   </li>
</ul>
 </form>
	    
	</div>

 <jsp:include page="../jsp_components/guestFooter.jsp"/>
 
 <jsp:include page="../jsp_components/javaScriptDependencies.jsp"/>

</body>
</html>