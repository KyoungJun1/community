package com.oo.kj.community.common.mail;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;

public class Mail {

    public static void sendMail(String _email, String _emailcode) {


        String subject = "Mail_Send";
        String fromMail = "rhdkfk6027@naver.com";
        String fromName = "DIREA";
        String toMail = _email;

        StringBuffer contents = new StringBuffer();
        contents.append("<h1>MAIL</h1>\n");
        contents.append("<p>" + "http://192.168.1.81:11111/userAdmission?ky=" + _emailcode + "</p><br>");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.naver.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.naver.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromMail, "dnfmrht123");
                    }
                });

        try {
            MimeMessage message = new MimeMessage(mailSession);

            message.setFrom(new InternetAddress(fromMail, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 한글의 경우 encoding 필요
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toMail)
            );
            message.setSubject(subject);
            message.setContent(contents.toString(), "text/html;charset=UTF-8"); // 내용 설정 (HTML 형식)
            message.setSentDate(new java.util.Date());

            Transport t = mailSession.getTransport("smtp");
            t.connect(fromMail, "dnfmrht123");
            t.sendMessage(message, message.getAllRecipients());
            t.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
