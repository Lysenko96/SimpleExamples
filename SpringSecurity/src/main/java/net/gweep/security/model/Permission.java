package net.gweep.security.model;

public enum Permission {

	USER_READ("user:read"), USER_WRITE("user:write");

	private final String status;

	private Permission(String status) {
		this.status = status;
	}

	public String getPermission() {
		return status;
	}

}
