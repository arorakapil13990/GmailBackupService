package com.interrait.gmailbackup.controller;

import java.util.Date;

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
	public void exportBackup(@PathVariable("backupid") int backupid) {

		CompressionStrategy compressionStrategy = CompressionFactory.getCompressionStrategy(Compression.ZIP);
		// get backup with specified backup id
		compressionStrategy.compressBackup(new Backup(1, new Date(), BackupStatus.IN_PROGRESS));

	}
	
	
	@GetMapping("/exports/{backupid}/{label}")
	@ApiOperation(value = "This API will return all emails with the specified label in a specified backup. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public void exportBackupByLabel(@PathVariable("backupid") int backupid,@PathVariable("label") String label) {

		CompressionStrategy compressionStrategy = CompressionFactory.getCompressionStrategy(Compression.ZIP);
		// get backup with specified backup id and label
		compressionStrategy.compressBackup(new Backup(1, new Date(), BackupStatus.IN_PROGRESS));

	}
}
