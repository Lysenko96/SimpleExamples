package com.example.springmail.service;

import com.example.springmail.model.Loggable;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class MailService {

    private JavaMailSender javaMailSender;


    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Loggable
    public MimeMessage sendMailMessage(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessage mimeMessage1 = null;
        try {
        MimeMessageHelper helper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
            helper.addAttachment("application.properties", new File("/home/user/Documents/SimpleExamples/springmail/src/main/resources/application.properties"));
            helper.addTo("anton.lysenko.info@gmail.com");
            helper.setText("text");
            mimeMessage1 = helper.getMimeMessage();
//            Multipart multipart = new MimeMultipart();
//            mimeMessage.setRecipients(Message.RecipientType.TO, "anton.lysenko.info@gmail.com");
//            DataSource dataSource = new FileDataSource("/home/user/Documents/SimpleExamples/springmail/src/main/resources/application.properties");
//            BodyPart bodyPart = new MimeBodyPart();
//            bodyPart.setDataHandler(new DataHandler(dataSource));
//            bodyPart.setFileName("application.properties");
//            multipart.addBodyPart(bodyPart);
//            bodyPart = new MimeBodyPart();
//            bodyPart.setText("properties");
//            multipart.addBodyPart(bodyPart);
//            mimeMessage.setContent(multipart);
            javaMailSender.send(mimeMessage1);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        javaMailSender.send(message);
        return mimeMessage1;
    }
}
