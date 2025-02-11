<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../js/Account.js"></script>
</head>
<body class="login-page">

<jsp:useBean id="myMABR" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanRegister" scope="session"/>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      
      <!-- Message Display -->
      <h3 class="text-center text-info">
        <jsp:getProperty property="messageHtml" name="myMessageBean"/>
      </h3>
      
      <!-- Registration Form -->
      <form action="./RegisterAppl.jsp" method="get" onsubmit="return checkInput(this)">
        <!-- Username input -->
        <div class="form-outline mb-4">
          <input type="text" id="username" class="form-control" name="username" value="<jsp:getProperty property='username' name='myMABR'/>" />
          <label class="form-label" for="username">Username</label>
          <div id="UsernameFehlerMeldung" class="form-text" style="color: white"></div>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <input type="password" id="password" class="form-control" name="password" value="<jsp:getProperty property='password' name='myMABR'/>" />
          <label class="form-label" for="password">Password</label>
          <div id="PasswordFehlerMeldung" class="form-text" style="color: white"></div>
        </div>

        <!-- Age input -->
        <div class="form-outline mb-4">
          <input type="text" id="age" class="form-control" name="age" value="<jsp:getProperty property='age' name='myMABR'/>" />
          <label class="form-label" for="age">Age</label>
          <div id="AgeFehlerMeldung" class="form-text" style="color: white"></div>
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
          <input type="text" id="mail" class="form-control" name="mail" value="<jsp:getProperty property='email' name='myMABR'/>" />
          <label class="form-label" for="mail">Email</label>
          <div id="EmailFehlerMeldung" class="form-text" style="color: white" ></div>
        </div>

        <!-- Sex input -->
        <div class="form-outline mb-4">
          <label class="form-label">Sex</label><br/>
          <input type="radio" id="sexMale" name="sex" value="male" />
          <label for="sexMale" class="form-label">Male</label>
          <input type="radio" id="sexFemale" name="sex" value="female" />
          <label for="sexFemale" class="form-label">Female</label>
        </div>

        <!-- Submit button -->
        <button type="submit" name="BtnRegister" value="Registrieren" class="btn btn-primary btn-block mb-4">Registrieren</button>

        <!-- Login link -->
        <div class="text-center">
          <p>Sie haben schon ein Konto? dann klicken sie <a href="./RegisterAppl.jsp?zumLogin=zumLogin">hier</a>!</p>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>