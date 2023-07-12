package com.chirag.emailsender.service.impl;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.chirag.emailsender.entities.EmailLog;
import com.chirag.emailsender.repository.EmailLogRepository;
import com.chirag.emailsender.service.EmailLogService;

@Service
public class EmailLogServiceImpl implements EmailLogService {

    private final JavaMailSender mailSender;
    private final EmailLogRepository emailLogRepository;

    public EmailLogServiceImpl(JavaMailSender mailSender, EmailLogRepository emailLogRepository) {
        this.mailSender = mailSender;
        this.emailLogRepository = emailLogRepository;
    }

    @Override
    public EmailLog sendEmail(String recipientEmail, String emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Email Created By Spring Boot Project - Educational Purpose");
        message.setText(emailBody);

        mailSender.send(message);

        EmailLog emailLog = new EmailLog();
        emailLog.setRecipientEmail(recipientEmail);
        emailLog.setEmailBody(emailBody);
        emailLog.setSentAt(new Date());

        return emailLogRepository.save(emailLog);
    }

}
