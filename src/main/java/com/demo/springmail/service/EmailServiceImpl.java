package com.demo.springmail.service;

import com.demo.springmail.dtos.EmailDetails;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
            return "Error while sending email: " + e.getMessage();
        }

    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        try {
            // Create a MimeMessage
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            // Set up MimeMessageHelper for attachments
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setSubject(details.getSubject());
            mimeMessageHelper.setText(details.getMsgBody());

            // Handle attachment if provided
            MultipartFile attachment = details.getAttachment();
            if (attachment != null && !attachment.isEmpty()) {
                mimeMessageHelper.addAttachment(attachment.getOriginalFilename(), attachment);
            }

            // Send the email
            javaMailSender.send(mimeMessage);
            return "Email Sent Successfully with attachment";
        } catch (Exception e) {
            return "Error while sending email: " + e.getMessage();
        }
    }
}
