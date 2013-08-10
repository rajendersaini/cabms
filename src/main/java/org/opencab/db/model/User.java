package org.opencab.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cabuser")
public class User extends AbstractEntity {

	@Column(length=NAME_LEN)
	private String firstName;
	@Column(length=NAME_LEN)
	private String middleName;
	@Column(length=NAME_LEN)
	private String lastName;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name="cabuser_id")
	private List<UserAddress> addresses;

	public User() {
	}

	public User(String firstName, String middleName, String lastName,
			List<UserAddress> addresses) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.addresses = addresses;
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
