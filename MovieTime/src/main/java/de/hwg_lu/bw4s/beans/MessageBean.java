package de.hwg_lu.bw4s.beans;

public class MessageBean {
	
	String infoMsg;
	String actionMsg;

	public MessageBean() {
		this.setGeneralWelcome();
	}

	public String getMessageHtml() {
	    String html = "<h4 style='color: white; text-align: center;'>" ;
	    html +=  this.getInfoMsg() + "<br>";
	    html +=  this.getActionMsg() + "</h4>\n";
	    return html;
	}
	
	//-------------------Login messages----------------------------
	
	public void setLoginFailed() {
		this.setInfoMsg("We're sorry, but it looks like something went wrong during the login process.");
		this.setActionMsg("Please try logging in again. If the problem persists, feel free to contact our support team for assistance.");
	}
	
	public void setLogoutSuccessful() {
		this.setInfoMsg("You have been successfully logged out.");
		this.setActionMsg("We hope you enjoyed your time on Movie Time. Looking forward to seeing you again soon!");
	}
	
	public void setAccountAlreadyExists(String userid) {
		this.setInfoMsg("It looks like the you're not registred.");
		this.setActionMsg("Please go to the registration.");
	}
	
	public void setHomepagewelcomeMsg(String userid) {
		this.setInfoMsg("welcome '"+userid+"' to the cinematic world.");
		this.setActionMsg("Alot of masterpieces to be watched.");
	}
	
	//-------------------Registration messages----------------------------
	
	public void setRegWelcome() {
		this.setInfoMsg("Willkommen an Movie Time");
		this.setActionMsg("Bitte füllen Sie alle erforderlichen Felder aus, um Ihr Konto zu erstellen und mit der Erkundung zu beginnen!");
	}
	
	public void setRegSuccessful(String userid) {
		this.setInfoMsg("Congratulations '"+userid+"'! Your registration with Movie Time has been successfully completed.");
		this.setActionMsg("");
	}
	
	public void setRegFailed() {
		this.setInfoMsg("We're sorry, but it looks like something went wrong during the register process.");
		this.setActionMsg("Please try registering in again. If the problem persists, feel free to contact our support team for assistance.");
	}
	
	//-------------Homepage and Categories messages-------------
	
	public void setGeneralWelcome() {
		this.setInfoMsg("We're thrilled to have you join our community of film enthusiasts. We've got something for every movie lover.");
		this.setActionMsg("Please feel free to login in.");
	}
	
	public void setMovieInfosWelcome() {
		this.setInfoMsg("Great choice my friend!");
		this.setActionMsg("Dive into the details and discover everything about your selected movie!");
	}
	
	public void setactionWelcome() {
		this.setInfoMsg("Brace yourself for some heart-pounding action! Time to turn your living room into a stunt zone.");
		this.setActionMsg("Choose your next adrenaline rush from our action-packed selection!");
	}
	
	public void setdramaWelcome() {
		this.setInfoMsg("Grab your tissues and prepare for the feels. The drama is about to unfold!");
		this.setActionMsg("Time for some emotional roller coasters. Choose a drama and get ready for the feels!");
	}
	
	public void setromanceWelcome() {
		this.setInfoMsg("Love is in the air! Get ready to swoon over our collection of romantic gems.");
		this.setActionMsg("Love is in the air! Choose a romance movie and let your heart flutter.");
	}
	
	public void sethorrorWelcome() {
		this.setInfoMsg("Feeling brave? Welcome to the fright zone. We promise to keep the nightmares under your bed.");
		this.setActionMsg("Feeling daring? Select a horror movie... if you dare!");
	}
	
	public void setcomedyWelcome() {
		this.setInfoMsg("Get ready to laugh till you drop! We've got enough comedy to make even a statue giggle.");
		this.setActionMsg("Ready for some belly laughs? Pick a comedy and let the fun begin!");
	}
	
	public void setfantasyWelcome() {
		this.setInfoMsg("Welcome to a world of magic and wonder! Time to escape reality and enter the realm of fantasy");
		this.setActionMsg("Choose a fantasy movie and let your imagination soar!");
	}
		
	public void setTop60Welcome() {
		this.setInfoMsg("Discover the top 60 movies of all time, handpicked for their unparalleled storytelling and cinematic brilliance.");
		this.setActionMsg("");
	}	
	
	//---------------------Bucketlist messages---------------------------
	
	public void setMovieAddedSuccefuly() {
		this.setInfoMsg("Your movie has been added to your Bucketlist, hope you enjoy it.");
		this.setActionMsg("");
	}
	public void setMovieRemovedSuccefuly() {
		this.setInfoMsg("Movie has been succefuly removed as wished.");
		this.setActionMsg("");
	}
	public void setBucketlistWelcome() {
		this.setInfoMsg("Welcom to your Bucketlist.");
		this.setActionMsg("By clicking on the poster, you can find out more about the movie!");
	}
	public void setMovieAlreadyExists() {
		this.setInfoMsg("Movie exists already in your Bucketlist");
		this.setActionMsg("we have other simular Movies, just click on the Category link.");
	}
	public void setMovieIsntSelected() {
		this.setInfoMsg("Movie isn't in your Bucketlist");
		this.setActionMsg("you should add it first");
	}
	

	public String getInfoMsg() {
		return infoMsg;
	}
	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}
	public String getActionMsg() {
		return actionMsg;
	}
	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
}
