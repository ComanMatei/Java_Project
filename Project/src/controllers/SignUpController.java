package controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserService;

public class SignUpController {
	@FXML
	private Button button_singup;
	@FXML
	private Button button_LogIn;
	@FXML
	private TextField tf_firstname;
	@FXML
	private TextField tf_lastname;
	@FXML
	private TextField tf_username;
	@FXML
	private Label lb_errors;
	@FXML
	private PasswordField tf_password;
	@FXML
	private Parent root;

	private static SignUpController instance;

	public SignUpController() {
		instance = this;
	}

	public static SignUpController getInstance() {
		return instance;
	}

	public String firstName() {
		return tf_firstname.getText();
	}

	public String lastName() {
		return tf_lastname.getText();
	}

	public String username() {
		return tf_username.getText();
	}

	public void SignUpAction(ActionEvent event) throws Exception {
		try {
			if (isEmpty())
				lb_errors.setText(Exceptions.IS_EMPTY.Message);
			else if (isValidbothNames(tf_firstname.getText(), tf_lastname.getText()))
				lb_errors.setText(Exceptions.IS_UPPERCASE.Message);
			else if ((ifContainNumber(tf_firstname.getText(), tf_lastname.getText())))
				lb_errors.setText(Exceptions.IS_NUMBER.Message);
			else if (isValidUsername(tf_username.getText()))
				lb_errors.setText(Exceptions.IS_USERNAME.Message);
			else if (isValidPassword(tf_password.getText()))
				lb_errors.setText(Exceptions.IS_PASSWORD.Message);
			else {
				UserService userService = new UserService();
				User user = new User(tf_firstname.getText(), tf_lastname.getText(), tf_username.getText(),
						tf_password.getText());
				userService.addUser(user);
				System.out.println("Merge");
				root = FXMLLoader.load(getClass().getResource("/resouces/view/AfterSingUp.fxml"));
				Stage window = (Stage) button_singup.getScene().getWindow();
				window.setScene(new Scene(root));
			}
		} catch (NullPointerException e) {
			System.out.println(e);

		}
	}

	public void toLogIn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/LogIn.fxml"));
		Stage window = (Stage) button_LogIn.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	public boolean isValidbothNames(String first, String last) {
		boolean pattern1 = Pattern.compile("^[A-Z]").matcher(first).find();
		boolean pattern2 = Pattern.compile("^[A-Z]").matcher(last).find();
		if (pattern1 && pattern2)
			return false;
		return true;
	}

	public boolean isValidUsername(String username) {
		boolean pattern = Pattern.compile("^[a-zA-Z]\\w{4,10}$").matcher(username).find();
		if (pattern)
			return false;
		return true;
	}

	public boolean isEmpty() {
		if (tf_firstname.getText().isEmpty() || tf_lastname.getText().isEmpty() || tf_username.getText().isEmpty()
				|| tf_password.getText().isEmpty())
			return true;
		return false;
	}

	public boolean ifContainNumber(String first, String last) {
		boolean p1 = Pattern.compile("[0-9]").matcher(first).find();
		boolean p2 = Pattern.compile("[0-9]").matcher(last).find();
		if (p1 || p2)
			return true;
		return false;
	}

	public boolean isValidPassword(String pass) {
		boolean pattern = Pattern
				.compile("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[._-])" + "(?=\\S+$).{4,15}$").matcher(pass)
				.find();
		if (pattern)
			return false;
		return true;
	}
}
