package com.demo.springmail.dtos;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    public String getRecipient() {
        return recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public String getAttachment() {
        return attachment;
    }
}
