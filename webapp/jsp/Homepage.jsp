<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>
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
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>
<jsp:useBean id="myMB" class= "de.hwg_lu.bw4s.beans.MovieBean" scope="session"/>
<jsp:useBean id="myMABL" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanLogin" scope="session"/>
<% if(myMABL.isLoggedIn()==false){ response.sendRedirect("./LoginView.jsp");} %>


<form action="./HomepageAppl.jsp" method="get">

<header class = "header-container">
    <a href="./HomepageAppl.jsp?BacktoOriginalView=BacktoOriginalView" class="text-dark text-decoration-none  fs-1">
      <img alt="Logo" src="../img/logo.jpg" width="75" height="75" class="me-2">
      Movie Time 
    </a>
</header>

<div class="d-flex justify-content-center">
<ul class="nav nav-underline fs-4">
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?BacktoOriginalView=BacktoOriginalView">Home Page</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=action">Action</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=comedy">Comedy</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=romance">Romance</a>
  </li>
    <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=horror">Horror</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=fantasy">Fantasy</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?selectedKategorie=drama">Drama</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?Topmovies=Top60">Top60</a>
  </li>
  <li class="nav-item me-5">
    <a class="nav-link" href="./HomepageAppl.jsp?Bucketlist=Bucketlist">My Bucket List</a>  
  </li>
  <li class="nav-item"> 
            
        <input type="submit" class="btn btn-danger" name="ausloggen" value="Ausloggen">
    
            </li>
  
</ul>
</div>



<h3><jsp:getProperty property="messageHtml"   name="myMessageBean"/></h3>

<div class="container movie-display-container">
  <div class="row">
  	
    <jsp:getProperty property="moviesFromDB" name="myMB"/>
   
  </div>
</div>



   

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>




</form>


</body>
</html>