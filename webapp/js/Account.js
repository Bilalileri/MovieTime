function checkInput(myForm){
	//if (document.buttonClicked == "zumLoginBtn") return true;
	//Prüfung nur wenn regBtn geklickt wurde
	var myNickname = myForm.username.value;
	var myPassword = myForm.password.value;
	var myAge      = myForm.age.value;
	var myEmail    = myForm.mail.value;
//	var mySex      = myForm.sex.value;
	

	var nicknameOk =  this.checkNickname(myNickname);
	var passwordOk =  this.checkPassword(myPassword);
	var ageOk      =  this.checkAge(myAge);
	var emailOk    =  this.checkEmail(myEmail);
///	var sexOk      =  this.checkSex(mySex);
//&& sexOk
	//Formular nur abschicken, wenn alle Tests erfolgreich
	if (nicknameOk && passwordOk && ageOk && emailOk ) return true;
	else return false;
}
function checkNickname(myNickname){
	var myFehlerfeldTd = document.getElementById("UsernameFehlerMeldung");
	if (myNickname.length < 3){ myFehlerfeldTd.innerText = "Die Username muss mindestens 3 Zeichen sein.";  return false }
	else{ myFehlerfeldTd.innerText = "" ; return true ; }	
}

function checkPassword(myPassword){
	var myFehlerfeldTd = document.getElementById("PasswordFehlerMeldung");
	if (!myPassword){
		myFehlerfeldTd.innerText = "Das Passwort darf nicht leer sein.";
		return false;
	}else if(myPassword.length < 5){
		myFehlerfeldTd.innerText = "Das Passwort muss mindestens 5 Zeichen lang sein.";
		return false;
	}else{
		myFehlerfeldTd.innerText = "";
		return true;
	}
}
function checkAge(myAge){
	var myFehlerfeldTd = document.getElementById("AgeFehlerMeldung");
	var myAgeInt = parseInt(myAge)
	if (myAgeInt < 13){
		myFehlerfeldTd.innerText = "Leider sie mussen ueber 12 sein. Wir warten auf ihnen, wenn sie 13 werden.";
		return false; 
	}else if(isNaN(myAgeInt)){
		myFehlerfeldTd.innerText = "Das Alter muss ein Zahl sein.";
		return false;
	}else{
		myFehlerfeldTd.innerText = "";
		return true;
	}
}
function checkEmail(myEmail){
	var myFehlerfeldTd = document.getElementById("EmailFehlerMeldung");
	if (!myEmail){
		myFehlerfeldTd.innerText = "Die E-Mail-Adresse darf nicht leer sein.";
		return false;
	}else if(myEmail.length < 6){
		myFehlerfeldTd.innerText = "Die E-Mail-Adresse muss mindestens 6 Zeichen lang sein.";
		return false;
	}else if(myEmail.indexOf("@") <= 0){
		myFehlerfeldTd.innerText = "Die E-Mail-Adresse muss ein @ Zeichen haben.";
		return false;
	}else{
		myFehlerfeldTd.innerText = "";
		return true;
	}

}
function checkSex(mySex){
	var myFehlerfeldTd = document.getElementById("SexFehlerMeldung");
	if (mySex){
		return true;
	} else{
		myFehlerfeldTd.innerText = "Sex darf nicht leer sein.";
		return false;
	}
}



