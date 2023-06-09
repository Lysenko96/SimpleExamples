package org.gweep.prodmvc;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {


    private String emailAddressTo = "anton.lys96@gmail.com"; // from
    private String msgSubject;
    private String msgText;


    public static void main(String[] args) {
        new Main().createAndSendEmail("anton.lys96@gmail.com", "subject", "Textdfsgdfdgdgfd");
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
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return new PasswordAuthentication(emailAddressTo, "emzviudnvjlnyvmz");
                return new PasswordAuthentication(emailAddressTo, "nbbedifaetenazbw");
                //return new PasswordAuthentication(emailAddressTo, "mawrbilhksvprmmx");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("anton.lys96@gmail.com"));
            message.setContent(msgText, "text/html");

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("anton.lys96@gmail.com")); // to

            message.setSubject("Hello");
            Transport.send(message);
            System.out.println("sent successfully");
        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}
