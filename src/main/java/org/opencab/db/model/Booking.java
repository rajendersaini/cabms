package org.opencab.db.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Booking extends AbstractEntity {

	private enum Status {
		CREATED, PROCESSING, CONFIRMED, CANCELLED, HOLD
	}

	@Embedded	
	private Address start;

	@AttributeOverrides({
	@AttributeOverride(column = @Column(name="end_line1"), name = "line1"),
	@AttributeOverride(column = @Column(name="end_line2"), name = "line2"),
	@AttributeOverride(column = @Column(name="end_city"), name = "city"),
	@AttributeOverride(column = @Column(name="end_state"), name = "state"),
	@AttributeOverride(column = @Column(name="end_country"), name = "country"),
	@AttributeOverride(column = @Column(name="end_zip"), name = "zip")})
	@Embedded
	private Address end;

	public Address getStart() {
		return start;
	}

	public void setStart(Address start) {
		this.start = start;
	}

	public Address getEnd() {
		return end;
	}

	public void setEnd(Address end) {
		this.end = end;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private Status status;

	public String getRef() {

		return null;
	}

}
