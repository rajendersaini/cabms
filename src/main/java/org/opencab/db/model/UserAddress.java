package org.opencab.db.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class UserAddress extends AbstractEntity {
	private static final long serialVersionUID = 2575744316494765125L;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Embedded
	private Address address;
}
