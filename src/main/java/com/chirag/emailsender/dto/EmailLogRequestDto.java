package com.chirag.emailsender.dto;

public class EmailLogRequestDto {

    private String recipientEmail;
    private String emailBody;

    public EmailLogRequestDto() {
    }

    public EmailLogRequestDto(String recipientEmail, String emailBody) {
        this.recipientEmail = recipientEmail;
        this.emailBody = emailBody;
    }

    public String getRecipientEmail() {
        return this.recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getEmailBody() {
        return this.emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    @Override
    public String toString() {
        return "{" +
            " recipientEmail='" + getRecipientEmail() + "'" +
            ", emailBody='" + getEmailBody() + "'" +
            "}";
    }

}

