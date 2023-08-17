package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the barber database table.
 * 
 */
@Entity
@NamedQuery(name = "Barber.findAll", query = "SELECT b FROM Barber b")
public class Barber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idbarber;

	private String name;

	// bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy = "barber")
	private List<Appointment> appointments;

	public Barber() {
	}

	public int getIdbarber() {
		return this.idbarber;
	}

	public void setIdbarber(int idbarber) {
		this.idbarber = idbarber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setBarber(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setBarber(null);

		return appointment;
	}

	@Override
	public String toString() {
		return name;
	}

}