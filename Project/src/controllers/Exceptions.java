package controllers;

public enum Exceptions {

	IS_EMPTY("Please enter all the information"), 
	IS_UPPERCASE("Your name dosen't start with an uppercase"),
	IS_NUMBER("Your name shoudn't contain numbers"), 
	IS_USERNAME("Your username shoud have 4 to 10 caracters"),
	IS_PASSWORD("Your password must contains each a-z A-Z 0-9 .-_");

	String Message;

	Exceptions(String Message) {
		this.Message = Message;
	}

}
