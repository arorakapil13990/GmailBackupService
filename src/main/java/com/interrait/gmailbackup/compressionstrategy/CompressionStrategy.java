package com.interrait.gmailbackup.compressionstrategy;

import com.interrait.gmailbackup.model.Backup;

public interface CompressionStrategy {

	public void compressBackup(Backup backup);

}
