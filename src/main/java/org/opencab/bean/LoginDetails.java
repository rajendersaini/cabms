package org.opencab.bean;

import org.opencab.db.model.User;

public class LoginDetails {

	private boolean isAccountLocked = false;
	private boolean isWarnAccountLock = false;
	private String errorMessage;
	private int numberOfInvalidLoginAttempts;
	private User user;

	public int getNumberOfInvalidLoginAttempts() {
		return numberOfInvalidLoginAttempts;
	}

	public void setNumberOfInvalidLoginAttempts(int numberOfInvalidLoginAttempts) {
		this.numberOfInvalidLoginAttempts = numberOfInvalidLoginAttempts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccountLocked() {
		return isAccountLocked;
	}

	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isWarnAccountLock() {
		return isWarnAccountLock;
	}

	public void setWarnAccountLock(boolean isWarnAccountLock) {
		this.isWarnAccountLock = isWarnAccountLock;
	}

}
