package Daoes;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.RoleEntity;
import Entities.UserEntity;
import Security.Hash;

@Named("userDao")
public class UserDao {
	// -----------------save one user---------------------//
	public boolean save(UserEntity entity) {
		boolean success = false;
		Transaction t = null;
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			session.save(entity);
			t.commit();
			success = true;
		} catch (HibernateException e) {
			t.rollback();
			success = false;
		} finally {
			session.close();
		}
		return success;
	}

	// -------------------find one user by id-----------------//
	public UserEntity load(int id) {
		Transaction t = null;
		UserEntity user = null;
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			user = new UserEntity();
			user = session.get(UserEntity.class, id);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	// -------------------find a user by username and
	// password-----------------//
	public UserEntity validateUser(String username, String password) {
		Transaction t = null;
		UserEntity user = new UserEntity();
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();

			user = (UserEntity) session.createQuery(
					"from UserEntity where userName='" + username + "'" + "and password='" + password + "'")
					.uniqueResult();
			t.commit();
			if (user == null)
				throw new NullPointerException();

		} catch (NullPointerException e) {
			user = new UserEntity("guest", "81dc9bdb52d04dc20036dbd8313ed055", new RoleEntity(4, "guest"));
			System.out.println("user or pass is not valid");
			return user;

		} catch (HibernateException e) {
			t.rollback();

		} finally {
			session.close();
			return user;
		}

	}

	// ------------------find all users---------------------//
	public List<UserEntity> findAll() {
		List<UserEntity> allUser = new ArrayList<UserEntity>();
		Transaction t = null;
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			allUser.addAll((ArrayList<UserEntity>) session.createCriteria(UserEntity.class).list());
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return allUser;
	}

	// ------------------------delete one user----------------------------//
	public boolean deleteUser(int id) {
		boolean success = false;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionConfiguration.getSession();
			tx = session.beginTransaction();
			session.createQuery("delete from UserEntity where userId='" + id + "'").executeUpdate();
			tx.commit();
			success = true;
			return success;
		} catch (HibernateException e) {
			tx.rollback();
			success = false;
			return success;
		} finally {
			session.close();
		}

	}

	// --------------------------update user----------------------/
	public boolean updateUser(int id, UserEntity user) {
		boolean success = false;
		Session session = null;
		Transaction tx = null;

		try {
			session = SessionConfiguration.getSession();
			tx = session.beginTransaction();
			UserEntity user1 = new UserEntity();
			user1 = session.get(UserEntity.class, id);
			System.out.println(user1.getPassword());
			user1.copyUser(user);
			session.update(user1);
			tx.commit();
			success = true;// update was successfully;
			return success;
		} catch (HibernateException e) {
			tx.rollback();
			success = false;
			return success;
		} finally {
			session.close();
		}

	}
}
