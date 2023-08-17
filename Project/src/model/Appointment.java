package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AppointmentPK id;

	private String date;

	private String hour;

	// bi-directional many-to-one association to Barber
	@ManyToOne
	@JoinColumn(name = "idbarber")
	private Barber barber;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Appointment() {
	}

	public Appointment(AppointmentPK id, String date, String hour) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
	}

	public AppointmentPK getId() {
		return this.id;
	}

	public void setId(AppointmentPK id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Barber getBarber() {
		return this.barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return date + " && " + hour;

	}

}