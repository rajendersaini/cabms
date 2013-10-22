package org.opencab.db.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Role extends AbstractEntity {

	private static final long serialVersionUID = 1637886886521199260L;

	private String name;

	@ManyToOne
	private User user;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
