package com.interrait.gmailbackup.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interrait.gmailbackup.enums.BackupStatus;
import com.interrait.gmailbackup.model.Backup;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiOperation(value = "backupController",
notes = "Operations pertaining to gmail backups",
responseContainer = "List",
produces = "application/json")
public class BackupController {


	@PostMapping("/backups")
	@ApiOperation(value = "This API will initiate a complete backup of all emails in a customer’s Gmail account.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public Map<String,List<Integer>> initiateCompleteBackups(){
		Map<String,List<Integer>> backups = new HashMap<>();
		backups.put("backupId", Arrays.asList(1,2,3));
		return backups;
	}
	
	
	@GetMapping("/backups")
	@ApiOperation(value = "This API will list all backups that have initiated. ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public List<Backup> getListOfBackups(){
		Backup b1 = new Backup(1, new Date(), BackupStatus.OK);
		Backup b2 = new Backup(2, new Date(), BackupStatus.FAILED);
		Backup b3 = new Backup(3, new Date(), BackupStatus.IN_PROGRESS);
		return Arrays.asList(b1,b2,b3);
	}
	
}
