package com.interrait.gmailbackup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interrait.gmailbackup.model.Backup;
import com.interrait.gmailbackup.service.BackupService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiOperation(value = "backupController",
notes = "Operations pertaining to gmail backups",
responseContainer = "List",
produces = "application/json")
public class BackupController {

	@Autowired
	private BackupService service;

	@PostMapping("/backups")
	@ApiOperation(value = "This API will initiate a complete backup of all emails in a customer’s Gmail account.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public Map<String,List<Integer>> initiateCompleteBackups(){
		List<Integer> backupIds = service.getListOfBackupIds();
		Map<String,List<Integer>> backups = new HashMap<>();
		backups.put("backupId", backupIds);
		return backups;
	}
	
	
	@GetMapping("/backups")
	@ApiOperation(value = "This API will list all backups that have initiated. ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!!!")})
	public List<Backup> getListOfBackups(){
		return service.getListOfBackups();
	}
	
}
