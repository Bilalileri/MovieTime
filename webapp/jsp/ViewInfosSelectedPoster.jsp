<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>
<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="../css/styles.css">
<title>Homepage MovieTime</title>
</head>
<body>
 <form method="get" action="./ViewInfosSelectedPosterAppl.jsp" class="mb-3">
<jsp:useBean id="myMB" class= "de.hwg_lu.bw4s.beans.MovieBean" scope="session"/>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>
<jsp:useBean id="myMABL" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanLogin" scope="session"/>
<% if(myMABL.isLoggedIn()==false){ response.sendRedirect("./LoginView.jsp");} %>


<header class = "header-container">
    <a href="./ViewInfosSelectedPosterAppl.jsp?BacktoOriginalView=BacktoOriginalView" class="text-dark text-decoration-none  fs-1">
      <img alt="Logo" src="../img/logo.jpg" width="75" height="75" class="me-2">
      Movie Time 
    </a>
</header>

<div class="d-flex justify-content-center">
<ul class="nav nav-underline fs-4">
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?BacktoOriginalView=BacktoOriginalView"">Home Page</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=action">Action</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=comedy">Comedy</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=romance">Romance</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=horror">Horror</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=fantasy">Fantasy</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?selectedKategorie=drama">Drama</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?Topmovies=Top60">Top60</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./ViewInfosSelectedPosterAppl.jsp?Bucketlist=Bucketlist">My Bucket List</a>
  </li>
    <li class="nav-item">     
     <input type="submit" class="btn btn-danger" name="ausloggen" value="Ausloggen">
  </li>
</ul>
</div>

<div class="container movie-display-container mt-5">
  <div class="row">
    <div class="col-md-6">
   	   
	  <h3><jsp:getProperty property="messageHtml"   name="myMessageBean"/></h3>
      <h3 class="mb-4">Movie Information</h3>
      <jsp:getProperty name="myMB" property="infosAsHtmlForSelectedPoster"/>
      <h3 class="mt-5">Reviews</h3>
      <jsp:getProperty name="myMB" property="reviewsForSelectedPoster"/>
    </div>

	 
    <div class="col-md-6">
      <form method="post" action="./ViewInfosSelectedPosterAppl.jsp" class="mb-3">
        <!-- Bucketlist Buttons -->
        <div class="mb-3">
         <p> <button type="submit" id="button" name="in Bucketlist Hinzufugen" value="<%= myMB.getSelectedMovieId() %>" class="btn btn-success">in Bucketlist Hinzufugen</button>
     		 <button type="submit" id="button" name="Entfernen von Bucketlist" value="<%= myMB.getSelectedMovieId() %>" class="btn btn-danger" >Entfernen von Bucketlist</button></p>
 
       <!-- Hidden field to pass the movie ID -->
          <input type="hidden" name="movieId" value="<%= myMB.getSelectedMovieId() %>" />
        </div>

        <!-- Movie Poster -->
        <div class="movie-poster-container mb-3">
          <img src="../img/<%= myMB.getSelectedMovieId() %>.jpg" class="movie-poster"/>
        </div>

        <!-- Add Review Form -->
        <div class="form-outline mb-4">
          <label class="form-label" for="newReview">What's your opinion about the movie?</label>
          <textarea class="form-control" id="newReview" name="newReview" rows="4"></textarea>
        </div>
        <button type="submit" name="addReview" value="Add Review" class="btn btn-primary btn-block mb-4">Add Review</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
