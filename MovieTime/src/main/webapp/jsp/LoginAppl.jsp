<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myMABL" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanLogin" scope="session"/>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>
<%
//--------------------Retrieving and Storing----------------------------------
	
	String Username = request.getParameter("username");
	String Password = request.getParameter("password"); 	
	String BtnzumLogin = request.getParameter("BtnzumLogin"); 
	String zurReg = request.getParameter("zurReg");
	String ausloggen = request.getParameter("ausloggen");


//--------------------cleaning and triming----------------------------------	
	
	if(BtnzumLogin == null){BtnzumLogin="";}
	if(zurReg == null){zurReg="";}
	if (ausloggen == null) ausloggen = "";

		
//--------------------Instructions-----------------------------------------

	 if(BtnzumLogin.equals("Anmelden")){ 
		myMABL.setUsername(Username);
		myMABL.setPassword(Password);
		if(myMABL.checkAccountExists()){
			myMABL.setLoggedIn(true);
			myMessageBean.setHomepagewelcomeMsg(Username);
			response.sendRedirect("./Homepage.jsp");
		}else{ 
			myMABL.setLoggedIn(false);
			myMessageBean.setAccountAlreadyExists(Username);
			response.sendRedirect("./LoginView.jsp");
			}
	}else if(zurReg.equals("zurReg")){ 
		myMessageBean.setRegWelcome();
		response.sendRedirect("./RegisterView.jsp");		
	}else if (ausloggen != null && ausloggen.equals("Ausloggen")) {
	    myMABL.setLoggedIn(false);
	    myMessageBean.setInfoMsg("Sie haben sich erfolgreich abgemeldet.");
	    response.sendRedirect("./LoginView.jsp");
	}
	
	
	
	
%>
</body>
</html>