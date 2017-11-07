package Entities;

import java.security.Principal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Security.Hash;

@Entity
@Table(name = "USER")
public class UserEntity implements Pojo,Principal {

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;

	@Column(name = "userName", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	private RoleEntity role=new RoleEntity();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;

	}

	public void setPassword(String password) {

		if (password.length() == 32) {
			this.password = password;
		} else {
			Hash hash = new Hash("MD5", password);
			this.password = hash.hashWithMD5();
		}

	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public UserEntity() {
	}

	public UserEntity(int userId, String userName, String password, RoleEntity role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role.CopyRole(role);
	}

	public UserEntity(String userName, String password, RoleEntity role) {
		this.userName = userName;
		this.setPassword(password);
		this.role.CopyRole(role);
	}

	public UserEntity(String userName, String password) {
		this.userName = userName;
		this.setPassword(password);

	}

	public void copyUser(UserEntity user) {
		this.userName = user.userName;
		this.password = user.password;
		this.role.CopyRole(user.role);;
		this.userId = user.userId;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

}
