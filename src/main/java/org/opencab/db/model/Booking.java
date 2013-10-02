package org.opencab.db.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.opencab.util.RefGenerator;

@Entity
public class Booking extends AbstractEntity {

	private enum Status {
		CREATED, PROCESSING, CONFIRMED, CANCELLED, HOLD
	}

	@Embedded
	private Address start;

	@AttributeOverrides({
			@AttributeOverride(column = @Column(name = "end_line1", length = ADDRESS_LEN), name = "line1"),
			@AttributeOverride(column = @Column(name = "end_line2", length = ADDRESS_LEN), name = "line2"),
			@AttributeOverride(column = @Column(name = "end_city", length = CITY_LEN), name = "city"),
			@AttributeOverride(column = @Column(name = "end_state", length = STATE_LEN), name = "state"),
			@AttributeOverride(column = @Column(name = "end_country", length = COUNTRY_LEN), name = "country"),
			@AttributeOverride(column = @Column(name = "end_zip", length = ZIP_LEN), name = "zip") })
	@Embedded
	private Address end;

	@NotNull
	@ManyToOne
	private User bookedBy;

	public User getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

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

	@PrePersist
	protected void onBooking() {
		ref = RefGenerator.getInstance().genRef();
	}

	private String ref;

	public String getRef() {

		return ref;
	}

}
