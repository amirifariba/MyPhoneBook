package Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class RoleEntity {
	@Id
	@GeneratedValue
	@Column(name = "roleId")
	private int roleId;

	@Column(name = "roleName", nullable = false, unique = true)

	private String roleName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Feature.class)
	@JoinTable(name = "ROLE_FEATURE", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
			@JoinColumn(name = "featureId") })
	private Set<Feature> features = new HashSet<Feature>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String userName) {
		this.roleName = userName;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public RoleEntity(int roleId, String roleName, Set<Feature> features) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.features = features;
	}

	public RoleEntity(String roleName, Set<Feature> features) {
		this.roleName = roleName;
		this.features = features;
	}

	public void CopyRole(RoleEntity role) {
		this.roleId = role.roleId;
		this.roleName = role.roleName;
		this.features = role.features;
	}

	public RoleEntity() {
	}

	public RoleEntity(int id, String roleName) {
		this.roleId = id;
		this.roleName = roleName;
	}
}
