package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController
{

    @Autowired
    private EmailSenderService senderService;

    @PostMapping("/send")
    public String sendmail(@RequestBody Mailreq mailreq)
    {
        senderService.sendEmail(mailreq.getToEmail(),mailreq.getSubject(),mailreq.getBody());
        return "Email Send to "+mailreq.getToEmail();
    }
}
