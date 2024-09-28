package com.mswesley.user.models;




import com.mswesley.user.enums.StatusEmail;
import jakarta.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class EmailModel implements Serializable {
    private static final long serialVersionUID = -7102550235037287718L;
    private String ownerRef;
    @Email
    private String emailFrom;
    @Email
    private String emailTo;
    private String subject;
    private String text;
    private LocalDate sendDateEmail;
    private StatusEmail statusEmail;


    public EmailModel(){}

    public EmailModel(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text, LocalDate sendDateEmail) {
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
    }


    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDate sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}

