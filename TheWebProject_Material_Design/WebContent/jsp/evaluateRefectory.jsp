<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../jsp_components/linkMetaDependencies.jsp">
   <jsp:param name="domain" value="guest" />
  </jsp:include>
 <title>Mensa bewerten</title>
</head>
<body>

<jsp:include page="../jsp_components/guestHeader.jsp"/>

<main>
 <div class="row">
  <div class="col s12 m6 l6">
   <div class="card">
   
    <div class="card-content">
     <div class="card-title red-text">Mensa bewerten</div>
     
     <form action="../evaluateRefectory" method="post">
     
     <div class="row">
           <div class="range-field">
       <div class="col s4 m4 l12">
        <label for="quality">Qualität</label>
        <input type="range" id="quality" min="0" max="10" name="quality" value=""/>
       </div>
      </div>
     </div>

      
      <br/>
      
      <div class="row">
             <div class="range-field">
       <div class="col s4 m4 l12">
        <label for="diversity">Vielfalt</label>
        <input type="range" id="diversity" min="0" max="10" name="diversity" value=""/>
       </div>
      </div>
      </div>

      
      <br/>
      
      
      <div class="row">
        <div class="range-field">
         <div class="col s4 m4 l12">
        <label for="variety">Abwechslung</label>
        <input type="range" id="variety" min="0" max="10" name="variety" value="" />
       </div>
      </div>  
      </div>
    

      <br/>
      
      
        <div class="row">
       <div class="range-field">
       <div class="col s4 m4 l12">
        <label for="serving_size">Portionsgröße</label>
        <input type="range" id="serving_size" min="0" max="10" name="serving_size" value=""/>
       </div>
      </div> 
      </div>

      
       <button type="submit" class="btn" name="bewerten" value="bewerten"><i class="material-icons right">send</i>Bewertung senden</button>
     </form>
    </div>
   </div>
  </div>
  
  <div class="col s12 m6 l6">
   <div class="card">
   
    <div class="card-content">
     <div class="card-title red-text">Vorschlag machen</div>
     <form action="addSuggestion" method="post">
      <div class="input-field">
       <i class="material-icons prefix">person</i>
       <input id="Vorname" type="text" class="validate">
       <label for="first_name">Vorname</label>
      </div>
      <br/>
      <div class="input-field">
       <i class="material-icons prefix">person</i>
       <input id="last_name" type="text" class="validate">
       <label for="last_name">Nachname</label>
      </div>
      <br/>
      <div class="input-field">
       <i class="material-icons prefix">mail</i>
       <input id="email" type="email" class="validate" required>
       <label for="email" data-error="wrong" data-success="right">Email</label>
      </div>
      <br/>
      <div class="input-field">
       <select name="suggestion_type">
        <option value="" disabled selected>Bitte wählen Sie den Anlass Ihrer Nachricht</option>
        <option value="1">Menüvorschlag</option>
        <option value="2">allgemeine Wünsche</option>
        <option value="3">Sonstiges</option>
       </select>
      </div>
      <br/>
      
      <div class="input-field">
       <textarea id="rate" class="materialize-textarea"></textarea>
       <label for="rate">Dein Vorschlag</label>
      </div>
      <br/>
      <br/>
      <div class="input-field">
       <button type="submit" class="btn" name="bewerten" value="bewerten"><i class="material-icons right">send</i>Vorschlag senden</button>
      </div>
     </form>
    </div>
   </div>
  </div>
 </div>
</main>

 <footer class="page-footer red">
  <div class="container">
   <div class="row">
    <div class="col l6 s12">
     <h5>Impressum</h5>
     Hochschulgastronomie<br/>
     Campus Ernst-Boehe-Straße<br />
     Ernst-Boehe-Str. 4 <br />
     67059 Ludwigshafen <br />
     <div class="valign-wrapper">
      <i class="material-icons small">call</i> +49 (0) 6341/9179-0 <br />
     </div>
     <div class="valign-wrapper">
     <i class="material-icons">email</i><a href="mailto:info@stw-vp.de" class="white-text">info@stw-vp.de</a> <br />
     </div>     
    </div>
    <div class="col l4 offset-l2 s12">
     <h5>Links</h5>
     <ul>
      <li><a class="grey-text text-lighten-3" href="https://www.hs-lu.de/service/studierendenwerk-vorderpfalz.html">Dein Studierendenwerk Vorderpfalz</a></li>
      <li><a class="grey-text text-lighten-3" href="https://www.studierendenwerk-vorderpfalz.de/home/speiseplaene/speiseplaene/ludwigshafen-mensa-wochenplan-aktuell.html">Dein Mensaplan mit PDF-Funktionalität</a></li>
      <li><a class="grey-text text-lighten-3" href="https://www.hs-lu.de/">Deine Hochschule Ludwigshafen</a></li>
      <li><a class="grey-text text-lighten-3" href="https://www.studierendenwerk-vorderpfalz.de/en/home/speiseplaene/menu/ludwigshafen-weekly-menu-current-week.html"> Dein Menu in English </a></li>
     </ul>
    </div>
   </div>
  </div>
  <div class="footer-copyright">
   <div class="container center-align">
    © 2018 The Web Project
   </div>
  </div>
 </footer>

 <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
 <script type="text/javascript" src="../js/materialize.js"></script>
  <script type="text/javascript">
 $(document).ready(function() {
	    $('select').material_select();
	  });
 </script>
</body>
</html>