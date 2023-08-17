package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Barber;
import model.User;
import service.BarberService;
import service.UserService;

public class CompareUsersController implements Initializable {

	private User user = LogIn.getInstance().getUser();

	@FXML
	private ListView<User> sortedList;

	@FXML
	private ListView<User> unsortedList;

	@FXML
	private Button button_barberSelect;

	@FXML
	private void toBarberSelect(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/SelectBarber.fxml"));
		Stage window = (Stage) button_barberSelect.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers();

		unsortedList.getItems().addAll(users);

		Collections.sort(users, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {
				return u1.getUsername().compareTo(u2.getUsername());
			}

		});

		sortedList.getItems().addAll(users);

	}

}
