package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Appointment;
import model.AppointmentPK;
import model.Barber;
import model.User;
import service.AppointmentService;

public class HourController implements Initializable {

	private List<String> hoursOption = new ArrayList(
			Arrays.asList("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"));

	private Barber barber = BarberController.getInstance().getBarber();

	private User user = LogIn.getInstance().getUser();

	private int barberId = this.barber.getIdbarber();

	private int userId = this.user.getUserId();

	private String date = BarberController.getInstance().getDate();

	private String hourSelected;

	@FXML
	private ComboBox<String> hourSelect;

	@FXML
	private Label viewAppointment, viewInfo, viewBarber;

	// Initialize
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> hour = FXCollections.observableArrayList(hoursOption);
		hourSelect.setItems(hour);
	}

	@FXML
	private void getHour(ActionEvent event) throws Exception {

		ObservableList<String> hours = FXCollections.observableArrayList(hoursOption);
		hourSelect.setItems(hours);
		hourSelected = hourSelect.getValue();
	}

	@FXML
	private void finishAppointment(ActionEvent event) throws Exception {

		AppointmentService appointmentService = new AppointmentService();

		// create object
		Appointment appointment = new Appointment();

		// create PK for object
		AppointmentPK appointmentPK = new AppointmentPK();
		appointmentPK.setUserId(userId);
		appointmentPK.setIdbarber(barberId);

		appointment.setId(appointmentPK);
		appointment.setHour(hourSelected);
		appointment.setDate(date);
		appointment.setUser(user);
		appointment.setBarber(barber);

		appointmentService.addAppointment(appointment);

		viewInfo.setText("Your appointment looks like this!");
		viewBarber.setText("Your barber is " + barber);
		viewAppointment.setText("Your date and hour is " + appointment);

	}

}
