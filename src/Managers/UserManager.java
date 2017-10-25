package Managers;

import java.util.List;
import Daoes.UserDao;
import Entities.UserEntity;

public class UserManager {

	UserDao dao = new UserDao();

	public boolean save(UserEntity entity) {
		return dao.save(entity);
	}

	public UserEntity load(int id) {
		return dao.load(id);
	}

	public List<UserEntity> findAll() {
		return dao.findAll();
	}

	public boolean Delete(int id) {
		return dao.deleteUser(id);
	}

	public boolean Update(int id, UserEntity user) {
		return dao.updateUser(id, user);
	}

	public UserEntity validateUser(UserEntity user) {
		return dao.validateUser(user.getUserName(), user.getPassword());
	}

	public UserManager() {
	}
}
