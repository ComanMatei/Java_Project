package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.BarberDao;
import model.Barber;
import model.User;

public class BarberService {

	private BarberDao barberDao;

	public BarberService() {
		try {
			barberDao = new BarberDao(Persistence.createEntityManagerFactory("Project"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addBarber(Barber newBarber) {
		barberDao.create(newBarber);
	}

	public void updateBarber(Barber updateBarber) {
		barberDao.update(updateBarber);
	}

	public List<Barber> getAllBarbers() {
		return barberDao.findAll();
	}
}
