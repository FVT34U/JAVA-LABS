package com.example.lab4.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.lab4.models.AuditMessage;

@Service
@RequiredArgsConstructor
public class MailingService {
    private static final String SUBJECT_TEMPLATE = "Updates in table %s";

    private static final String MESSAGE_TEMPLATE = "Updates in table:\n %s in %s";

    private final JavaMailSender emailSender;

    public void sendSimpleEmail(String toAddress, AuditMessage auditMessage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setFrom("captaintedotron55@gmail.com");
        simpleMailMessage.setSubject(SUBJECT_TEMPLATE.formatted(auditMessage.getTable()));
        simpleMailMessage.setText(MESSAGE_TEMPLATE.formatted(auditMessage.getInfo(), auditMessage.getDatetime()));
        emailSender.send(simpleMailMessage);
    }
}
