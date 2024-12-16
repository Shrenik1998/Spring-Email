package com.demo.springmail.controller;

import com.demo.springmail.dtos.EmailDetails;
import com.demo.springmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
}
