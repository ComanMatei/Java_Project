package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.xdevapi.Result;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserService;

public class LogIn {

	private User user;

	@FXML
	private Button buttonLogIn;
	@FXML
	private Button buttonSignUp;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	private static LogIn instance;

	public LogIn() {
		instance = this;
	}

	public static LogIn getInstance() {
		return instance;
	}

	public void SignUpAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/SignUp1.fxml"));
		Stage window = (Stage) buttonSignUp.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	public void userLogIn(ActionEvent event) throws Exception {
		checkLogIn();
	}

	public void checkLogIn() throws Exception {
		try {
			if (username.getText().isEmpty() || password.getText().isEmpty())
				wrongLogIn.setText(Exceptions.IS_EMPTY.Message);
		} catch (Exception e) {
			System.out.println(e);
		}
		UserService userService = new UserService();
		User user = userService.findUser(username.getText(), password.getText());
		this.user = user;

		switchToManu();
	}

	public void switchToManu() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/SelectBarber.fxml"));
		Stage window = (Stage) buttonLogIn.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	public User getUser() {
		return this.user;
	}
}
