package Managers;

import java.util.List;

import javax.inject.Inject;

import Entities.ContactEntity;
import javax.inject.Named;

import Daoes.ContactDao;

public class ContactManager {
	ContactDao dao = new ContactDao();

	public boolean save(ContactEntity entity) {
		return dao.save(entity);
	}

	public ContactEntity load(int id) {
		return dao.load(id);
	}

	public List<ContactEntity> findAll() {
		return dao.findAll();
	}

	public boolean Delete(int id) {
		return dao.deleteContact(id);
	}

	public boolean Update(int id, ContactEntity contact) {
		return dao.updateContact(id, contact);
	}

	public ContactManager() {
	}
}
