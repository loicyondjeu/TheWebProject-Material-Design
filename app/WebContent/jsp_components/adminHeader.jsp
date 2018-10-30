<header>
  <nav>
   <div class="nav-wrapper red">
    <a href="#" data-activates="nav-mobile" class="button-collapse">
     <i class="material-icons">menu</i>
    </a>
    <a class="brand-logo flow-text white-text center">Willkommen ${sessionScope.user.username}</a>
   </div>
  </nav>
      
  <ul id="nav-mobile" class="side-nav fixed">
       <li>
       	<div class="user-view red">
          <a href="../jsp/features.jsp">
          	<i class="material-icons large white-text">account_circle</i>
          </a>
          <a href="#!name">
          	<span class="name white-text">${sessionScope.user.username}</span>
          </a>
          <a href="#!email">
          	<span class="email white-text">${sessionScope.user.email}</span>
          </a>
         </div>
        </li>
        
         <li>
         	<a class="waves-effect" href="profile.jsp">
         		<i class="material-icons">account_circle</i>Profil
         	</a>
         </li>
         
         <li>
         	<a class="waves-effect" href="createMeal.jsp">
         		<i class="material-icons">create</i>Speise erstellen
         	</a>
         </li>
         
         <li>
         	<a class="waves-effect" href="planMeal.jsp">
         		<i class="material-icons">event</i>Speise planen
         	</a>
         </li>
         
         <li>
         	<a class="waves-effect" href="dashboard.jsp">
         		<i class="material-icons">dashboard</i>Statistiken ansehen
         	</a>
         </li>
                  
         <li>
         	<a class="waves-effect" href="register.jsp">
         		<i class="material-icons">person</i>User anlegen
         	</a>
         </li>
         
         <li>
         	<div class="divider red"></div>
         </li>
         
         <li>
         	<a class="waves-effect" href="../logout"><i class="material-icons">power_settings_new</i>Abmelden</a>
         </li>
   </ul>
 </header>