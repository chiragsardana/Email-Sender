package com.chirag.emailsender.service;

import com.chirag.emailsender.entities.EmailLog;

public interface EmailLogService {
    public EmailLog sendEmail(String recipientEmail, String emailBody);
}
