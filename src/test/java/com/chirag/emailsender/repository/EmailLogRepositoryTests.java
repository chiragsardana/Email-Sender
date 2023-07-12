package com.chirag.emailsender.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.chirag.emailsender.entities.EmailLog;


@DataJpaTest
public class EmailLogRepositoryTests {

    @Autowired
    private EmailLogRepository emailLogRepository;

    @Test
    public void createEmailLogTest(){
        EmailLog emailLog = new EmailLog();   
        emailLog.setRecipientEmail("test@example.com");
        emailLog.setEmailBody("This is a test email");
        emailLog.setSentAt(new Date());

        EmailLog savedEmailLog = emailLogRepository.save(emailLog);

        EmailLog retrievedEmailLog = emailLogRepository.findById(savedEmailLog.getId()).orElse(null);

        assertEquals(savedEmailLog.getRecipientEmail(), retrievedEmailLog.getRecipientEmail());
        assertEquals(savedEmailLog.getId(), retrievedEmailLog.getId());


    }
}
