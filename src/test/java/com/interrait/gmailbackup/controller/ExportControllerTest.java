package com.interrait.gmailbackup.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ExportController.class)
public class ExportControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void testExportBackup() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/exports/1").contentType(MediaType.APPLICATION_OCTET_STREAM)).andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
        Assert.assertEquals("application/zip", result.getResponse().getContentType());
    }

	@Test
    public void testExportBackupByLabel() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/exports/1/label").contentType(MediaType.APPLICATION_OCTET_STREAM)).andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
        Assert.assertEquals("application/zip", result.getResponse().getContentType());
    }
}
