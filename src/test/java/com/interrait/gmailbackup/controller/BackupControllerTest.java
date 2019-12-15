package com.interrait.gmailbackup.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.interrait.gmailbackup.enums.BackupStatus;
import com.interrait.gmailbackup.model.Backup;
import com.interrait.gmailbackup.service.BackupService;


@RunWith(SpringRunner.class)
@WebMvcTest(BackupController.class)
public class BackupControllerTest {
	
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BackupService service;

    private List<Backup> backups = new ArrayList<>();
    private List<Integer> backupsIds = new ArrayList<>();
    @Before
    public void setup() {
    	Backup b1 = new Backup(10, new Date(), BackupStatus.OK);
		Backup b2 = new Backup(20, new Date(), BackupStatus.FAILED);
		Backup b3 = new Backup(30, new Date(), BackupStatus.IN_PROGRESS);

		backups.add(b3);
		backups.add(b2);
		backups.add(b1);
    	
		
		backupsIds = Arrays.asList(1,2);
    }
    
    
    @Test
    public void testListOfBackups() throws Exception {
        when(service.getListOfBackups()).thenReturn(backups);
        mockMvc.perform(get("/backups"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].backupId", is(30)))
                .andExpect(jsonPath("$[1].backupId", is(20)))
                .andExpect(jsonPath("$[2].backupId", is(10)));
        
        verify(service, times(1)).getListOfBackups();

    }
    
    @Test
    public void testListOfBackupId() throws Exception {
        when(service.getListOfBackupIds()).thenReturn(backupsIds);
        mockMvc.perform(MockMvcRequestBuilders.post("/backups"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.backupId").exists());
        
        verify(service, times(1)).getListOfBackupIds();

    }

}
