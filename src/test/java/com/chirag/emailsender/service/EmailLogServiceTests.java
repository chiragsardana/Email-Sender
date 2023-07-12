package com.chirag.emailsender.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.chirag.emailsender.entities.EmailLog;
import com.chirag.emailsender.repository.EmailLogRepository;
import com.chirag.emailsender.service.impl.EmailLogServiceImpl;


public class EmailLogServiceTests {

    @Mock
    private EmailLogRepository emailLogRepository;

    @Mock
    private JavaMailSender mailSender;

    private EmailLogService emailLogService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        emailLogService = new EmailLogServiceImpl(this.mailSender, this.emailLogRepository);
    }

    @Test
    public void createEmailLogTest() {
        EmailLog emailLog = new EmailLog();
        String recipientEmail = "Chiragsardana12@gmail.com";
        String emailBody = "This is Spring Boot Mail Sender Body Test";
        emailLog.setRecipientEmail(recipientEmail);
        emailLog.setEmailBody(emailBody);
        emailLog.setSentAt(new Date());
        emailLog.setId(1L);

        when(emailLogRepository.save(Mockito.any(EmailLog.class))).thenReturn(emailLog);

        EmailLog savedEmailLog = emailLogService.sendEmail(recipientEmail, emailBody);

        assertEquals(emailLog.getId(), savedEmailLog.getId());
        assertEquals(emailLog.getSentAt(), savedEmailLog.getSentAt());
        // System.out.println(emailLog + " and " + savedEmailLog);
        verify(emailLogRepository, times(1)).save(Mockito.any(EmailLog.class));
    }
    @Test
    public void sendEmailTest(){
        String recipientEmail = "Chiragsardana12@gmail.com";
        String emailBody = "This is Spring Boot Mail Sender Body Test";

        emailLogService.sendEmail(recipientEmail, emailBody);

        verify(mailSender, times(1)).send(Mockito.any(SimpleMailMessage.class));

    }
}