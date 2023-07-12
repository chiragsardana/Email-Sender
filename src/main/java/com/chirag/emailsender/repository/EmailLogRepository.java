package com.chirag.emailsender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirag.emailsender.entities.EmailLog;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {
}
