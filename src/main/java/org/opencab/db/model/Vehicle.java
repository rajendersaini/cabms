package org.opencab.db.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Vehicle extends AbstractEntity {
	private static final long serialVersionUID = -8264185412746945007L;
	private String make;
	private Date Model;
	private int capacity;

	public Vehicle() {
	}

	public Vehicle(String make, Date model, int capacity) {
		super();
		this.make = make;
		Model = model;
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Date getModel() {
		return Model;
	}

	public void setModel(Date model) {
		Model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
