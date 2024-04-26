package org.example;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Main {

    private String emailAddressTo = "anton.lys96@gmail.com";
    private String msgSubject;
    private String msgText;


    public static void main(String[] args) {
        new Main().createAndSendEmail("anton.lys96@gmail.com", "subject", "Text");
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
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddressTo, "emzviudnvjlnyvmz");
            }
        });

        try {
            Message message = new MimeMessage(session);

            BodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            messageBodyPart.setContent(msgSubject, "text/html");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
//            String fileName = "/home/user/Documents/SimpleExamples/sendmail/file.txt";
            String fileName = "/home/user/Documents/SimpleExamples/sendmail/2024-04-25_08-16.png";
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);


            message.setFrom(new InternetAddress(emailAddressTo));
//            message.setContent(msgText, "text/html");
            message.setContent(multipart);

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("anton.lysenko.info@gmail.com"));

            message.setSubject("Hello");
            Transport.send(message);
            System.out.println("sent successfully");
        } catch (MessagingException e){
           throw new RuntimeException(e);
        }
    }
}