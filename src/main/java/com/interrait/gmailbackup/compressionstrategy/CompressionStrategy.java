package com.interrait.gmailbackup.compressionstrategy;

import java.io.IOException;

import com.interrait.gmailbackup.model.Backup;

public interface CompressionStrategy {

	public byte[] compressBackup(Backup backup) throws IOException;

}
