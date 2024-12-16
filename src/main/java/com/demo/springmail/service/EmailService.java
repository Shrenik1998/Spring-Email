package com.demo.springmail.service;


import com.demo.springmail.dtos.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
