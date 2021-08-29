package hibernate.service;

import org.springframework.stereotype.Service;

import hibernate.dao.impl.UserDaoImpl;
import hibernate.entity.User;

@Service
public class UserService {

	private UserDaoImpl userDao;
	private static int id;

	public UserService(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public String save(User user) {
		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPassword());
		System.out.println(userDb);
		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
			userDao.save(user);
		}
		if (user.getRole() == null || user.getPassword().isEmpty() || user.getName().isEmpty()
				|| user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().isEmpty()) {
			return "redirect:/register";
		}
		return "redirect:/login";
	}
}
