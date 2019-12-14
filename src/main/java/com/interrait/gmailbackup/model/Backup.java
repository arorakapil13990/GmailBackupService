package com.interrait.gmailbackup.model;

import java.util.Date;

import com.interrait.gmailbackup.enums.BackupStatus;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "backup", notes = "Contains information about backups")
public class Backup {

	@ApiModelProperty(notes = "Primary key of backup.", name = "backupId", required = true)
	private int backupId;

	@ApiModelProperty(notes = "backup date", name = "date", required = true)
	private Date date;

	@ApiModelProperty(notes = "Backup status", name = "status", required = true)
	private BackupStatus status;

	public Backup(int backupId, Date date, BackupStatus status) {
		super();
		this.backupId = backupId;
		this.date = date;
		this.status = status;
	}

	public int getBackupId() {
		return backupId;
	}

	public Date getDate() {
		return date;
	}

	public BackupStatus getStatus() {
		return status;
	}

}
