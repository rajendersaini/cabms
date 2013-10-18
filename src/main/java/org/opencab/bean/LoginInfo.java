package org.opencab.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginInfo {

	@NotNull
	@NotEmpty
	@NotBlank
	@Email
	@Size(max = 45)
	public String email;

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 6)
	public String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
