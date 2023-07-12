package com.chirag.emailsender.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirag.emailsender.dto.EmailLogRequestDto;
import com.chirag.emailsender.entities.EmailLog;
import com.chirag.emailsender.service.EmailLogService;

@RestController
public class EmailLogController {
    private final EmailLogService emailLogService;

    public EmailLogController(EmailLogService emailLogService) {
        this.emailLogService = emailLogService;
    }

    @PostMapping("/send-email")
    public EmailLog sendEmail(@RequestBody EmailLogRequestDto emailRequest) {
        String recipientEmail = emailRequest.getRecipientEmail();
        String emailBody = emailRequest.getEmailBody();

        return emailLogService.sendEmail(recipientEmail, emailBody);
    }

}
