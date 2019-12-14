package com.interrait.gmailbackup.factory;

import com.interrait.gmailbackup.compressionstrategy.CompressionStrategy;
import com.interrait.gmailbackup.compressionstrategy.ZipCompression;
import com.interrait.gmailbackup.enums.Compression;

public class CompressionFactory {

	public static CompressionStrategy getCompressionStrategy(Compression compression) {
		CompressionStrategy compressionStrategy = null;
		switch (compression) {
		case ZIP:
			compressionStrategy = new ZipCompression();
			break;
		default:
			break;
		}
		return compressionStrategy;
	}
}
