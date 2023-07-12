package com.chirag.emailsender.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
// Database Table
@Table(name = "EmailLog")
// details of the database table
public class EmailLog {

    @Id
    // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // auto-incrementing column in the database
    private Long id;

    @Column(name = "recipientEmail")
    private String recipientEmail;
    private String emailBody;
    @Column(columnDefinition = "datetime")
    // SQL column definition
    private Date sentAt;

    // Default constructor
    public EmailLog() {
    }
    // Parameterized constructor
    public EmailLog(Long id, String recipientEmail, String emailBody, Date sentAt) {
        this.id = id;
        this.recipientEmail = recipientEmail;
        this.emailBody = emailBody;
        this.sentAt = sentAt;
    }
    // Getter for id
    public Long getId() {
        return this.id;
    }
    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }
    // Getter for Recipient Email
    public String getRecipientEmail() {
        return this.recipientEmail;
    }
    // Setter for Recipient Email
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
    // Getter for emailBody
    public String getEmailBody() {
        return this.emailBody;
    }
    // Setter for emailBody
    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
    // Getter for sentAt
    public Date getSentAt() {
        return this.sentAt;
    }
    // Setter for sentAt
    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
    // Override toString() method for debugging or logging purposes
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", recipientEmail='" + getRecipientEmail() + "'" +
            ", emailBody='" + getEmailBody() + "'" +
            ", sentAt='" + getSentAt() + "'" +
            "}";
    }

}
