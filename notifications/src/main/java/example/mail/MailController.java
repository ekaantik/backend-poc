package example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
