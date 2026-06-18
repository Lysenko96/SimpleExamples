package com.lysenko.shoppingcart.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@RequiredArgsConstructor
@Component
public class CommonUtil {

    private final JavaMailSender mailSender;

    public Boolean sendMail(String resetUrl, String email) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("anton.lysenko.info@gmail.com", "Shopping Cart");
        helper.setTo(email);
        String content = "<p>Reset password. Click link change password</p>" +
                "<p><a href=\"" + resetUrl +"\">Change password</a>";
        helper.setSubject("Password Reset");
        helper.setText(content, true);
        mailSender.send(message);
        return true;
    }

    public String generateUrl(HttpServletRequest request) {
        return request.getRequestURL().toString().replace(request.getServletPath(), "");
    }
}
