package orm.hibernate.dao;

import java.util.List;

import orm.hibernate.entity.User;

public interface UserDao {

	void save(User user);

	User getById(int id);

	List<User> getAll();

	int update(User user);

	void deleteById(int id);
}
