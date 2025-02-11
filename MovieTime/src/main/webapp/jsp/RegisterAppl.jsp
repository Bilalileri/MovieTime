
<%@page import="de.hwg_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hwg_lu.bw4s.beans.MovieAccountBeanRegister"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myMessageBean" class= "de.hwg_lu.bw4s.beans.MessageBean" scope="session"/>
<jsp:useBean id="myMABR" class= "de.hwg_lu.bw4s.beans.MovieAccountBeanRegister" scope="session"/>
<%
//--------------------Retrieving and Storing----------------------------------

	String Username = request.getParameter("username");
	String Password = request.getParameter("password"); 	
	String AgeasString = request.getParameter("age");
	String Mail = request.getParameter("mail");
	String Sex = request.getParameter("sex");

	String zumLogin = request.getParameter("zumLogin"); 
	String BtnRegister = request.getParameter("BtnRegister");
	
//--------------------cleaning and triming----------------------------------	
		
	if(zumLogin == null){zumLogin="";}
	if(BtnRegister == null){BtnRegister="";}
	
	if(Sex ==null){Sex="";}
	
	int Age= 0;
	try{ 
		Age = Integer.parseInt(AgeasString);
	}catch(NumberFormatException nfe){
		nfe.printStackTrace();
	}
	
//--------------------Instructions-----------------------------------------
	
		if(BtnRegister.equals("Registrieren")){ 
			myMABR.setUsername(Username);
			myMABR.setPassword(Password);
			myMABR.setAge(Age);
			myMABR.setEmail(Mail);
			myMABR.setSex(Sex);
		
 			boolean accountAngelegt = false;
 			try{
 				accountAngelegt = myMABR.insertAccountIfNotExists();
 				if (accountAngelegt){
 						myMessageBean.setRegSuccessful(Username) ;
 						response.sendRedirect("./LoginView.jsp");
 				}else{
 						myMessageBean.setRegFailed() ;
 						response.sendRedirect("./RegisterView.jsp");
				}
 			}catch(Exception e){
 				
 			}
 		}else if(zumLogin.equals("zumLogin")){
 			myMessageBean.setGeneralWelcome();
 			response.sendRedirect("./LoginView.jsp");
		}else response.sendRedirect("./RegisterView.jsp");
	
	
	
	
	
	
	
	
	
	

%>
</body>
</html>