package org.opencab.db.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cabuser")
public class User extends AbstractEntity {
	private static final long serialVersionUID = -8796486571223627990L;

	@Column(length = NAME_LEN)
	private String firstName;

	@Column(length = NAME_LEN)
	private String middleName;

	@Column(length = NAME_LEN)
	private String lastName;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "cabuser_id")
	private List<UserAddress> addresses;

	@NotNull
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;

	@NotNull
	@OneToMany(orphanRemoval = true, cascade=CascadeType.ALL)
	@JoinColumn(name = "cabuser_id")
	private List<Role> roles;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
	}

	public User(String firstName, String middleName, String lastName,
			List<UserAddress> addresses, Profile userProfile, List<Role> roles) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.addresses = addresses;
		this.profile = userProfile;
		this.roles = roles;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

}
