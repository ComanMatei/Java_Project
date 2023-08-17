package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoggedIn implements Initializable {

	@FXML
	private Button button_loggedIn;
	@FXML
	private Label lb_congrats;
	@FXML
	private Label lb_usern;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setName(SignUpController.getInstance().firstName() + " " + SignUpController.getInstance().lastName());
		setUsername(SignUpController.getInstance().username());
	}

	public void setName(String user) {
		this.lb_congrats.setText("Congratulation " + user + "!");
	}

	public void setUsername(String user) {
		this.lb_usern.setText("Your username is " + user + "!");
	}

	public void toLogIn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/LogIn.fxml"));
		Stage window = (Stage) button_loggedIn.getScene().getWindow();
		window.setScene(new Scene(root));
	}
}
