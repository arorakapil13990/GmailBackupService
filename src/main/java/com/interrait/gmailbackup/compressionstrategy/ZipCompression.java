package com.interrait.gmailbackup.compressionstrategy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interrait.gmailbackup.model.Backup;

public class ZipCompression implements CompressionStrategy {

	@Override
	public byte[] compressBackup(Backup backup) throws IOException {
		Map<String, String> jsonList = new HashMap<>();
		String jsonString = new ObjectMapper().writeValueAsString(backup);
		jsonList.put(String.valueOf(backup.getBackupId()),jsonString);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream zipOutputStream = new ZipOutputStream(baos);
			for (Entry<String, String> entry : jsonList.entrySet()) {
				ZipEntry e = new ZipEntry(
						entry.getKey() + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "." + "json");
				e.setSize(entry.getValue().length());
				e.setTime(System.currentTimeMillis());
				zipOutputStream.putNextEntry(e);
				InputStream is = new ByteArrayInputStream(entry.getValue().getBytes());
				IOUtils.copy(is, zipOutputStream);
				is.close();
				zipOutputStream.closeEntry();
			}
			zipOutputStream.close();
			return baos.toByteArray();
	}

}
