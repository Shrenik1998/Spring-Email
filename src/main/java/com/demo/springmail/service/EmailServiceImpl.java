package com.demo.springmail.service;

import com.demo.springmail.dtos.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Email Sent Successfully";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }

    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return "";
    }
}
