package com.demo.springmail.controller;

import com.demo.springmail.dtos.EmailDetails;
import com.demo.springmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMailWithoutAttachment")
    public String
    sendMailWithoutAttachment(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestParam("recipient") String recipient,
                                         @RequestParam("msgBody") String msgBody,
                                         @RequestParam("subject") String subject,
                                         @RequestParam("attachment") MultipartFile attachment) {
        EmailDetails details = new EmailDetails();
        details.setRecipient(recipient);
        details.setMsgBody(msgBody);
        details.setSubject(subject);
        details.setAttachment(attachment);

        String status = emailService.sendMailWithAttachment(details);
        return status;
    }
}
