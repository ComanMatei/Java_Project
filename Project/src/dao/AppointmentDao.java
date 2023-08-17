package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Appointment;

public class AppointmentDao extends GenericDao<Appointment> {
	private EntityManagerFactory factory;

	public AppointmentDao(EntityManagerFactory factory) {
		super(Appointment.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception e) {
			System.out.println("The entity manager cannot be created");
		}
		return null;
	}

}
