package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Barber;
import model.User;
import service.BarberService;
import service.UserService;

public class BarberController implements Initializable {

	private Barber barberSelected;

	private String dateSelected;

	private Map<String, Barber> barberInformation = new HashMap<String, Barber>();

	@FXML
	private ComboBox<String> barberSelect;

	@FXML
	private DatePicker dateSelect;

	@FXML
	private Label lb_errors;

	@FXML
	public ListView<Barber> barberListView;

	@FXML
	private Button button_hour;

	private static BarberController instance;

	public BarberController() {
		instance = this;
	}

	public static BarberController getInstance() {
		return instance;
	}

	// Initialize
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BarberService barberService = new BarberService();
		List<Barber> barbers = barberService.getAllBarbers();

		List<String> barberNames = new ArrayList();

		for (Barber barber : barbers) {
			barberInformation.put(barber.getName(), barber);
			barberNames.add(barber.getName());
		}

		ObservableList<String> barber = FXCollections.observableArrayList(barberNames);
		barberSelect.setItems(barber);
	}

	// Actions
	@FXML
	private void getBarber(ActionEvent event) throws Exception {
		String barbers = barberSelect.getSelectionModel().getSelectedItem().toString();

		String barberSelectedName = barberSelect.getValue();
		barberSelected = barberInformation.get(barberSelectedName);

	}

	@FXML
	private void showDate(ActionEvent event) throws Exception {
		dateSelected = (dateSelect.getValue()).toString();

		if (barberSelected == null) {
			lb_errors.setText("Select the barber, first, please!");
		}
	}

	@FXML
	private void toHour(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/DatePick.fxml"));
		Stage window = (Stage) button_hour.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	@FXML
	public void toCompare(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/CompareUsers.fxml"));
		Stage window = (Stage) button_hour.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	public Barber getBarber() {
		return this.barberSelected;
	}

	public String getDate() {
		return this.dateSelected;
	}

}
