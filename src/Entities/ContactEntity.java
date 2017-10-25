package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class ContactEntity implements Pojo {

	@Id
	@GeneratedValue
	@Column(name = "contactId")
	private int contactId;

	@Column(name = "contactName", nullable = false)
	private String contactName;

	@Column(name = "contactLastName", nullable = false)
	private String contactLastName;

	@Column(name = "homePhoneNumber", nullable = false)
	private String homePhoneNumber;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContactEntity() {
	}

	public ContactEntity(String contactName, String contactLastName, String homePhoneNumber, String phoneNumber,
			String email) {
		this.contactName = contactName;
		this.contactLastName = contactLastName;
		this.homePhoneNumber = homePhoneNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void copyContact(ContactEntity contact) {
		this.contactName = contact.contactName;
		this.contactLastName = contact.contactLastName;
		this.homePhoneNumber = contact.homePhoneNumber;
		this.phoneNumber = contact.phoneNumber;
		this.email = contact.email;
	}

	@Override
	public boolean equals(Object contact) {
		ContactEntity contact1 = new ContactEntity();
		contact1 = (ContactEntity) contact;
		boolean equal = false;
		if (this.contactId == contact1.contactId && this.contactName == contact1.contactName
				&& this.contactLastName == contact1.contactLastName && this.homePhoneNumber == contact1.homePhoneNumber
				&& this.phoneNumber == contact1.phoneNumber && this.email == contact1.email) {
			equal = true;
		} else
			equal = false;
		return equal;
	}

}
