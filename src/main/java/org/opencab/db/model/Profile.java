package org.opencab.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Profile implements Serializable {

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = -8607206136291999692L;

	@Id
	@Column(nullable = false, unique = true)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private Long profileId;

	@NotNull
	@Column(length = AbstractEntity.NAME_LEN)
	private String email;

	@NotNull
	@Column(length = AbstractEntity.PASSWORDHASH_LEN)
	private String passwordhash;

	@NotNull
	@Max(5)
	private int attampts;

	private boolean locked;

	@NotNull
	private Date lastLogin;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	
	public Profile(){}
	public Profile(String email, String passwordhash, int attampts,
			boolean locked, Date lastLogin, User user) {
		this.email = email;
		this.passwordhash = passwordhash;
		this.attampts = attampts;
		this.locked = locked;
		this.lastLogin = lastLogin;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public int getAttampts() {
		return attampts;
	}

	public void setAttampts(int attampts) {
		this.attampts = attampts;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
