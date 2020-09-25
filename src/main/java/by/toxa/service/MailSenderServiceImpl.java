package by.toxa.service;

import by.toxa.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {
    @Autowired
    public JavaMailSender mailSender;

    public void send( String emailTo,String subject,String massage){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("wertyal.87@mail.ru");
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(massage);
        mailSender.send(mailMessage);
    }
}