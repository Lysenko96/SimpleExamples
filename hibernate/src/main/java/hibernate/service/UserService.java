package hibernate.service;

import hibernate.dao.impl.UserDaoImpl;
import hibernate.entity.User;

public class UserService {

	private UserDaoImpl userDao;
	private static int id;

	public UserService(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

//	public String add(User user) {
//		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPassword());
//		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()
//				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
//			userDao.add(user);
//		}
//		if (user.getRole() == null || user.getPassword().isEmpty() || user.getName().isEmpty()
//				|| user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().name().isEmpty()) {
//			return "redirect:/register";
//		}
//		return "redirect:/login";
//	}
}
