package org.opencab.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -2583748365277908325L;
	private Class<?> type;

	public <T> EntityNotFoundException(T entity) {
		type = entity.getClass();
	}
	public EntityNotFoundException() {
	}

	@Override
	public String getMessage() {
		return "Could not find Entity" + (type == null ? "" : type.toString());
	}

}
