package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.UserDao;
import model.User;

public class UserService {

	private UserDao userDao;

	public UserService() {
		try {
			userDao = new UserDao(Persistence.createEntityManagerFactory("Project"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(User newUser) {
		userDao.create(newUser);
	}

	public void updateUser(User updateUser) {
		userDao.update(updateUser);
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	// for login
	public User findUser(String user, String pass) throws Exception {
		List<User> users = userDao.find(user);
		System.out.println("Users: " + users);
		if (users.size() == 0)
			throw new Exception("User not found");
		User u = users.get(0);

		if (pass.compareTo(u.getPassword()) != 0)
			throw new Exception("Password doesn't match");
		return u;
	}
}
