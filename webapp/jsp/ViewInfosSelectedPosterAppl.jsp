<%@page import="de.hwg_lu.bw4s.beans.BucketlistBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>
<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanRegister"%>
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

	String chosenElementId = request.getParameter("chosenElement");    		//later on we neeed to add the simular movies and they are going to have an id if we click on them we get directed to the poster movies 
	String selectedKategorie = request.getParameter("selectedKategorie");     
	String BacktoOriginalView=  request.getParameter("BacktoOriginalView");   
	String Topmovies=  request.getParameter("Topmovies");
	String AddToBucketlistString =  request.getParameter("in Bucketlist Hinzufugen");
	String RemoveFromBucketlistString=  request.getParameter("Entfernen von Bucketlist");
	String Bucketlist = request.getParameter("Bucketlist");
	String newReview = request.getParameter("newReview");
	String addReview = request.getParameter("addReview");
	String ausloggen = request.getParameter("ausloggen");
//--------------------cleaning and triming----------------------------------	

	if(chosenElementId == null){chosenElementId="";}
	if(selectedKategorie == null){selectedKategorie="";}
	if(BacktoOriginalView == null){BacktoOriginalView="";}
	if(Topmovies == null){Topmovies="";}
	if(AddToBucketlistString == null){AddToBucketlistString="";}
	if(RemoveFromBucketlistString == null){RemoveFromBucketlistString="";}
	if(Bucketlist == null){Bucketlist="";}
	if(newReview == null){newReview="";}
	if(addReview == null){addReview="";}
	if (ausloggen == null){ ausloggen = "";}
	
	int id= 0;
	try{ 
		id = Integer.parseInt(chosenElementId);
	}catch(NumberFormatException nfe){
		nfe.printStackTrace();
	}
	 // *****************************
	int AddToBucketlist= 0;
	try{ 
		AddToBucketlist = Integer.parseInt(AddToBucketlistString);
	}catch(NumberFormatException nfe){
		nfe.printStackTrace();
	}
    // *****************************
	int RemoveFromBucketlist= 0;
	try{ 
		RemoveFromBucketlist = Integer.parseInt(RemoveFromBucketlistString);
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
	}else if(AddToBucketlist != 0){
		myBucketlistBean.setUsername(myMABL.getUsername()); 
		myBucketlistBean.setSelectedMovieId(AddToBucketlist);
		if(!myBucketlistBean.checkMovieInBucketlist()){
			myMessageBean.setMovieAddedSuccefuly();
			myBucketlistBean.AddtoBucketlist();	
		}else{ 
			myMessageBean.setMovieAlreadyExists();
		}
		response.sendRedirect("./ViewInfosSelectedPoster.jsp");
	}else if(RemoveFromBucketlist != 0){
		myBucketlistBean.setUsername(myMABL.getUsername());  
		myBucketlistBean.setSelectedMovieId(RemoveFromBucketlist);
		if(myBucketlistBean.checkMovieInBucketlist()){
			myMessageBean.setMovieRemovedSuccefuly();
			myBucketlistBean.RemovefromBucketlist();
		}else{ 
			myMessageBean.setMovieIsntSelected();
		}
		response.sendRedirect("./ViewInfosSelectedPoster.jsp");
	}else if(Bucketlist.equals("Bucketlist")){
		myMessageBean.setBucketlistWelcome();
		myBucketlistBean.setUsername(myMABL.getUsername()); 
		response.sendRedirect("./Bucketlist.jsp");
	}else if(addReview.equals("Add Review")){
	    myMB.setAddedReview(newReview);
	    myMB.insertReviewForSelectedPoster();
	    response.sendRedirect("./ViewInfosSelectedPoster.jsp");
	}else if (ausloggen.equals("Ausloggen")) {
	    myMABL.setLoggedIn(false);
	    myMessageBean.setInfoMsg("Sie haben sich erfolgreich abgemeldet.");
	    response.sendRedirect("./LoginView.jsp");
	}else response.sendRedirect("./ViewInfosSelectedPoster.jsp");
	


			

%>
</body>
</html>