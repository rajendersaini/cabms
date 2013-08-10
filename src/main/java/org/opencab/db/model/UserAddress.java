package org.opencab.db.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class UserAddress extends AbstractEntity {

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Embedded
	private Address address;
}
