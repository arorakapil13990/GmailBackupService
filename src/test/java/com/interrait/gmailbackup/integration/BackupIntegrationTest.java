package com.interrait.gmailbackup.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BackupIntegrationTest {
	@Autowired
    private MockMvc mvc;


    @Test
    public void testListOfBackups() throws Exception {
    	 mvc.perform(get("/backups"))
         .andDo(MockMvcResultHandlers.print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
         .andExpect(jsonPath("$", hasSize(3)))
         .andExpect(jsonPath("$[0].backupId", is(1)))
         .andExpect(jsonPath("$[1].backupId", is(2)))
         .andExpect(jsonPath("$[2].backupId", is(3)));
    }
    
    @Test
    public void testListOfBackupIds() throws Exception {
    	 mvc.perform(MockMvcRequestBuilders.post("/backups"))
         .andDo(MockMvcResultHandlers.print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
         .andExpect(MockMvcResultMatchers.jsonPath("$.backupId").exists());
    }
}
