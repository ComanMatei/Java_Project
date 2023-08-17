package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Barber;

public class BarberDao extends GenericDao<Barber> {
	private EntityManagerFactory factory;

	public BarberDao(EntityManagerFactory factory) {
		super(Barber.class);
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
