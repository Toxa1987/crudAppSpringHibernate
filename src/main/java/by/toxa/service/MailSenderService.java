package by.toxa.service;

public interface MailSenderService {
    void send(String emailTo,String subject,String massage);
}
