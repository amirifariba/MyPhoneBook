package Daoes;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Entities.ContactEntity;

@Named("contactDao")
public class ContactDao {
	public ContactDao() {
	}

	// -----------------save one contact---------------------//
	public boolean save(ContactEntity entity) {
		int id = 0;
		Transaction t = null;
		Session session = null;
		boolean success = false;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			id = (Integer) session.save(entity);
			t.commit();
			success = true;
			return success;
		} catch (HibernateException e) {
			t.rollback();
			success = false;
			System.out.println("not added");
			return success;

		} /*
			 * finally { session.close(); }
			 */

	}

	// -------------------find one contact-----------------//
	public ContactEntity load(int id) {
		Transaction t = null;
		ContactEntity contact = null;
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			contact = new ContactEntity();
			contact = session.get(ContactEntity.class, id);
			t.commit();
			System.out.println(contact.getContactLastName());
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return contact;
	}

	// ------------------find all contact---------------------//
	public List<ContactEntity> findAll() {
		List<ContactEntity> allContacts = new ArrayList<ContactEntity>();
		Transaction t = null;
		Session session = null;
		try {
			session = SessionConfiguration.getSession();
			t = session.beginTransaction();
			allContacts = (ArrayList<ContactEntity>) session.createCriteria(ContactEntity.class).list();
			t.commit();
			System.out.println(allContacts.get(0).getContactLastName());
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return allContacts;
	}

	// ------------------------delete one contact----------------------------//
	public boolean deleteContact(int id) {
		boolean success = false;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionConfiguration.getSession();
			tx = session.beginTransaction();
			session.createQuery("delete from ContactEntity where contactId='" + id + "'").executeUpdate();
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

	// --------------------------update contact----------------------/
	public boolean updateContact(int id, ContactEntity contact) {
		boolean success = false;
		Session session = null;
		Transaction tx = null;

		try {
			session = SessionConfiguration.getSession();
			tx = session.beginTransaction();
			ContactEntity contact1 = new ContactEntity();
			contact1 = session.get(ContactEntity.class, id);
			contact1.copyContact(contact);
			session.update(contact1);
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
