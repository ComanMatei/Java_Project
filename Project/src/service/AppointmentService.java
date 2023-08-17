package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.AppointmentDao;
import model.Appointment;


public class AppointmentService {
private AppointmentDao appointmentDao;
	
	public AppointmentService() {
		try {
			appointmentDao = new AppointmentDao(Persistence.createEntityManagerFactory("Project"));
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addAppointment(Appointment newAppointment) {
		appointmentDao.create(newAppointment);
	}
	
	public void updateAppointment(Appointment updateAppointment) {
		appointmentDao.update(updateAppointment);
	}
	
	public List<Appointment> getAllAppointments(){
		return appointmentDao.findAll();
	}
}
