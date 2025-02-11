<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanLogin"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="../css/styles.css">
</head>
<body class="login-page">

<jsp:useBean id="myMABL" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanLogin" scope="session"/>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <!-- Display Message -->
      <h3 class="text-center text-info">
        <jsp:getProperty property="messageHtml" name="myMessageBean"/>
      </h3>

      <!-- Login Form -->
      <form action="./LoginAppl.jsp" method="get">
        <!-- Nickname input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="form2Example1">Nickname</label>
          <input type="text" id="form2Example1" class="form-control" name="username" value="<jsp:getProperty property='username' name='myMABL'/>" />
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="form2Example2">Passwort</label>
          <input type="password" id="form2Example2" class="form-control" name="password" />
        </div>

        <!-- Submit button -->
        <div class="d-grid gap-2">
          <button type="submit" name="BtnzumLogin" value="Anmelden" class="btn btn-primary btn-block">Anmelden</button>
        </div>

        <!-- Register Link -->
        <div class="text-center mt-3">
          <p>Noch Kein Account? Registrieren Sie sich <a href="./LoginAppl.jsp?zurReg=zurReg">hier</a>!</p>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>