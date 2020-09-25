package by.toxa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:mail.properties")

public class MailConfig {

    @Value("${mail.host}")
    private String host;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.protocol}")
    private String protocol;
    @Value("${mail.debug}")
    private String debug;


    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setPort(port);


        Properties properties=mailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol",protocol);
        properties.setProperty("mail.debug",debug);
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        return  mailSender;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer prop(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
