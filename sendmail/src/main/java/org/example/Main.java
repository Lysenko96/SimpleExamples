package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    private String emailAddressTo = "xxx@gmail.com";
    private String msgSubject;
    private String msgText;


    public static void main(String[] args) {
        new Main().createAndSendEmail("xxx@gmail.com", "subject", "Text");
    }



    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText){
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddressTo, "emzviudnvjlnyvmz");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAddressTo));
            message.setContent(msgText, "text/html");

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo));

            message.setSubject("Hello");
            Transport.send(message);
            System.out.println("sent successfully");
        } catch (MessagingException e){
           throw new RuntimeException(e);
        }
    }
}