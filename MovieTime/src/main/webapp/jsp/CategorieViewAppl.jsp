
<%@page import="de.hwg_lu.bw4s.beans.BucketlistBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myMB" class= "de.hwg_lu.bw4s.beans.MovieBean" scope="session"/>
<jsp:useBean id="myMABL" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanLogin" scope="session"/>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>
<jsp:useBean id="myBucketlistBean" class= "de.hwg_lu.bw4s.beans.BucketlistBean" scope="session"/>

<% 
//--------------------Retrieving and Storing----------------------------------

	String chosenElementId = request.getParameter("chosenElement");
	String selectedKategorie = request.getParameter("selectedKategorie");
	String BacktoOriginalView=  request.getParameter("BacktoOriginalView");
	String Topmovies=  request.getParameter("Topmovies");
	String Bucketlist = request.getParameter("Bucketlist");
	String ausloggen = request.getParameter("ausloggen");

//--------------------cleaning and triming----------------------------------	

	if(chosenElementId == null){chosenElementId="";}
	if(selectedKategorie == null){selectedKategorie="";}
	if(BacktoOriginalView == null){BacktoOriginalView="";}
	if(Topmovies == null){Topmovies="";}
	if(Bucketlist == null){Bucketlist="";}
	if (ausloggen == null){ ausloggen = "";}
	
	int id= 0;
	try{ 
		id = Integer.parseInt(chosenElementId);
	}catch(NumberFormatException nfe){
		nfe.printStackTrace();
	}

//--------------------Instructions-----------------------------------------

	if(id != 0){
		myMB.setSelectedMovieId(id);
		myMessageBean.setMovieInfosWelcome();
		
		response.sendRedirect("./ViewInfosSelectedPoster.jsp");
		
	}else if(selectedKategorie.length()>1){ 
		myMB.setChosenCategorie(selectedKategorie);

		if(selectedKategorie.equals("drama")){
			myMessageBean.setdramaWelcome();
		}else if(selectedKategorie.equals("action")){
			myMessageBean.setactionWelcome();	
		}else if(selectedKategorie.equals("romance")){
			myMessageBean.setromanceWelcome();
		}else if(selectedKategorie.equals("horror")){
			myMessageBean.sethorrorWelcome();
		}else if(selectedKategorie.equals("comedy")){
			myMessageBean.setcomedyWelcome();
		}else if(selectedKategorie.equals("fantasy")){
			myMessageBean.setfantasyWelcome();
		}
		
		response.sendRedirect("./CategorieView.jsp");	
		
	}else if(BacktoOriginalView.equals("BacktoOriginalView")){
		myMessageBean.setGeneralWelcome();
		response.sendRedirect("./Homepage.jsp");
	}else if(Topmovies.equals("Top60")){
		myMessageBean.setTop60Welcome();
		response.sendRedirect("./Best60View.jsp");
	}else if(Bucketlist.equals("Bucketlist")){
		myMessageBean.setBucketlistWelcome();
		myBucketlistBean.setUsername(myMABL.getUsername());
		response.sendRedirect("./Bucketlist.jsp");
	}else if (ausloggen.equals("Ausloggen")) {
	    myMABL.setLoggedIn(false);
	    myMessageBean.setInfoMsg("Sie haben sich erfolgreich abgemeldet.");
	    response.sendRedirect("./LoginView.jsp");
	}

%>			
</body>
</html>