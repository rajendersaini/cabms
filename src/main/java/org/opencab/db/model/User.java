package org.opencab.db.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cabuser")
public class User extends AbstractEntity {

	private String firstName;
	private String middleName;
	private String lastName;
	@OneToMany
	private List<Address> addresses;

	public User(){}
	public User(String firstName, String middleName, String lastName,
			List<Address> addresses) {
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
