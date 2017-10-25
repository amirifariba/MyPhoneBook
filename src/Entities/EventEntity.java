package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EVENT")
public class EventEntity implements Pojo {

	@Id
	@GeneratedValue
	@Column(name = "eventId")
	private int eventId;

	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity user;

	@Column(name = "description")
	private String description;

	@Column(name = "dateTime", columnDefinition = "DATETIME")
	private Date dateTime;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user.copyUser(user);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public EventEntity(UserEntity user, String description, Date dateTime) {
		this.user.copyUser(user);
		this.description = description;
		this.dateTime = dateTime;
	}

	EventEntity() {
	}

}
