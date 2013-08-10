package org.opencab.db.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(nullable = false, length = AbstractEntity.ADDRESS_LEN)
	private String line1;
	@Column(length = AbstractEntity.ADDRESS_LEN)
	private String line2;
	@Column(nullable = false, length = AbstractEntity.CITY_LEN)
	private String city;
	@Column(nullable = false, length = AbstractEntity.STATE_LEN)
	private String state;
	@Column(nullable = false, length = AbstractEntity.COUNTRY_LEN)
	private String country;
	@Column(nullable = false, length = AbstractEntity.ZIP_LEN)
	private String zip;

	public Address() {

	}

	public Address(String line1, String line2, String city, String state,
			String country, String zip) {
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
