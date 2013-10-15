package org.opencab.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	public static final int NAME_LEN = 35;
	@Transient
	public static final int ADDRESS_LEN = NAME_LEN;
	@Transient
	public static final int CITY_LEN = NAME_LEN;
	@Transient
	public static final int STATE_LEN = NAME_LEN;

	@Transient
	public static final int COUNTRY_LEN = NAME_LEN;
	@Transient
	public static final int ZIP_LEN = 10;
	@Transient
	public static final int PASSWORDHASH_LEN = 250;
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false)
	private Date updated;

	@PrePersist
	protected void onCreate() {
		updated = created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}
}