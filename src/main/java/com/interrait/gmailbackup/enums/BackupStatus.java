package com.interrait.gmailbackup.enums;

public enum BackupStatus {

	IN_PROGRESS("In Progress"), OK("Ok"), FAILED("Failed");

	private String status;

	private BackupStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
