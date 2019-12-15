package com.interrait.gmailbackup.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.interrait.gmailbackup.compressionstrategy.CompressionStrategy;
import com.interrait.gmailbackup.enums.BackupStatus;
import com.interrait.gmailbackup.enums.Compression;
import com.interrait.gmailbackup.factory.CompressionFactory;
import com.interrait.gmailbackup.model.Backup;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiOperation(value = "exportController",
notes = "Operations pertaining to export")
public class ExportController {

	@GetMapping("/exports/{backupid}")
	@ApiOperation(value = "This API will return the content of a specified backup in a compressed archive. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public void exportBackup(HttpServletResponse response ,@PathVariable("backupid") int backupid) throws IOException {
		response.setHeader("Pragma", "public");
		response.setHeader("Expires", "0");
		response.setHeader("Cache - Control", "must - revalidate, post - check = 0, pre - check = 0");
		response.setContentType("application/zip");
		response.setHeader("Content - Disposition", "attachment; filename = -JSONSearchResultsData - "
				+ new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".zip");
		response.setHeader("Content - Transfer - Encoding", "binary");
		CompressionStrategy compressionStrategy = CompressionFactory.getCompressionStrategy(Compression.ZIP);
		byte[] zipBytes = compressionStrategy.compressBackup(new Backup(backupid, new Date(), BackupStatus.IN_PROGRESS));
		
		OutputStream outStream = response.getOutputStream();
		outStream.write(zipBytes);
		outStream.close();

	}
	
	
	@GetMapping("/exports/{backupid}/{label}")
	@ApiOperation(value = "This API will return all emails with the specified label in a specified backup. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public void exportBackupByLabel(HttpServletResponse response ,@PathVariable("backupid") int backupid,@PathVariable("label") String label) throws IOException {

		response.setHeader("Pragma", "public");
		response.setHeader("Expires", "0");
		response.setHeader("Cache - Control", "must - revalidate, post - check = 0, pre - check = 0");
		response.setContentType("application/zip");
		response.setHeader("Content - Disposition", "attachment; filename = -JSONSearchResultsData - "
				+ new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".zip");
		response.setHeader("Content - Transfer - Encoding", "binary");
		CompressionStrategy compressionStrategy = CompressionFactory.getCompressionStrategy(Compression.ZIP);
		byte[] zipBytes = compressionStrategy.compressBackup(new Backup(backupid, new Date(), BackupStatus.IN_PROGRESS));
		
		OutputStream outStream = response.getOutputStream();
		outStream.write(zipBytes);
		outStream.close();

	}
}
