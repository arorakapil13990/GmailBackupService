package com.interrait.gmailbackup.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interrait.gmailbackup.enums.BackupStatus;
import com.interrait.gmailbackup.model.Backup;

@Service
public class BackupService {

	public List<Integer> getListOfBackupIds() {
		return Arrays.asList(1, 2, 3);
	}

	public List<Backup> getListOfBackups() {
		Backup b1 = new Backup(1, new Date(), BackupStatus.OK);
		Backup b2 = new Backup(2, new Date(), BackupStatus.FAILED);
		Backup b3 = new Backup(3, new Date(), BackupStatus.IN_PROGRESS);

		return Arrays.asList(b1, b2, b3);
	}

}
