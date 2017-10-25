package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import Security.Hash;

@Entity
@Table(name = "USER")
public class UserEntity implements Pojo {

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;

	@Column(name = "userName", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "roleId", columnDefinition = "int default '3'")
	private int roleId = 3;

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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserEntity() {
	}

	public UserEntity(String userName, String password, int roleId) {
		this.userName = userName;
		this.setPassword(password);
		this.roleId = roleId;
	}

	public UserEntity(String userName, String password) {
		this.userName = userName;
		this.setPassword(password);

	}

	public void copyUser(UserEntity user) {
		this.userName = user.userName;
		this.password = user.password;
		this.roleId = user.roleId;
		this.userId = user.userId;
	}

	public UserEntity(int userId, String userName, String password, int roleId) {
		this.userId = userId;
		this.userName = userName;
		this.setPassword(password);
		this.roleId = roleId;
	}

}
