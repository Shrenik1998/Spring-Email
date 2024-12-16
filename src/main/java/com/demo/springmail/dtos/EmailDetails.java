package com.demo.springmail.dtos;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private MultipartFile attachment;

    public String getRecipient() {
        return recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }
}
