package com.chirag.emailsender.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.chirag.emailsender.dto.EmailLogRequestDto;
import com.chirag.emailsender.entities.EmailLog;
import com.chirag.emailsender.service.EmailLogService;
import org.springframework.http.MediaType;

public class EmailLogControllerTest {
    
    @Mock 
    private EmailLogService emailLogService;

    private EmailLogController emailLogController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        emailLogController = new EmailLogController(emailLogService);
        mockMvc = MockMvcBuilders.standaloneSetup(emailLogController).build();
    }

    @Test
    public void sendEmailTest() throws Exception{
        String recipientEmail = "Chiragsardana12@gmail.com";
        String emailBody = "This is Email Body";
        Long id = 1L;
        Date time = new Date();
        EmailLog emailLog = new EmailLog(id, recipientEmail, emailBody, time);
        when(emailLogService.sendEmail(recipientEmail, emailBody)).thenReturn(emailLog);
        System.out.println(emailLog+" is the Email log");

        EmailLogRequestDto emailLogRequestDto = new EmailLogRequestDto(recipientEmail, emailBody);
        System.out.println(emailLogRequestDto.toString());
        // Perform the POST request to the sendEmail endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/send-email")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"recipientEmail\":\"Chiragsardana12@gmail.com\",\"emailBody\":\"This is Email Body\"}"

                    ))
                .andDo(print())

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipientEmail").value(recipientEmail))
                .andExpect(MockMvcResultMatchers.jsonPath("$.emailBody").value(emailBody))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sentAt").value(time))
                ;
                verify(emailLogService, times(1)).sendEmail(recipientEmail, emailBody);

    }

    
}
