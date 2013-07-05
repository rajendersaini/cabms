package org.opencab.db.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class AbstractModel {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
