	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
     <link type="text/css" rel="stylesheet" href="../css/materialize.css"  media="screen,projection"/>
     <link type="text/css" rel="stylesheet" href="../css/materialize-stepper.css"  media="screen,projection"/>
<%
	String domain = request.getParameter("domain");
	if(domain.equals("admin")){
		out.print("<!--");%>
     <link type="text/css" rel="stylesheet" href="../css/style_guest.css"  media="screen,projection"/>
		<%
		out.print("-->");%>
	 <link type="text/css" rel="stylesheet" href="../css/style_admin.css"  media="screen,projection"/><%	
	}else if(domain.equals("guest")){
		out.print("<!--");%>
     <link type="text/css" rel="stylesheet" href="../css/style_admin.css"  media="screen,projection"/>		
		<%
		out.print("-->");%>
	 <link type="text/css" rel="stylesheet" href="../css/style_guest.css"  media="screen,projection"/><%
	}else{
		
	}

%>
		
