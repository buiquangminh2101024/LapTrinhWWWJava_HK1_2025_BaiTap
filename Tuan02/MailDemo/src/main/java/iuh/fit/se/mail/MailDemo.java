package iuh.fit.se.mail;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class MailDemo {
    public void sendMail(String recipient, String subject, String body) {
        String attachmentPath = "";
        String senderEmail = "";
        String password = "";
        String host = "smtp.gmail.com";
        int port = 587;

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        try {
            // Tạo đối tượng mặc định MimeMessage.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(recipient)));
            message.setSubject(subject);

            // Tạo đối tượng BodyPart của email.
            BodyPart messageBodyPart = new MimeBodyPart();

            // Nội dung của email.
            messageBodyPart.setText(body);

            // Email sẽ gồm 2 part (text, file attached)
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Phần xử lý với file attached
            if (attachmentPath != null && !attachmentPath.isEmpty()) {
                MimeBodyPart attachPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachmentPath);
                attachPart.setDataHandler(new DataHandler(source));
                attachPart.setFileName(source.getName());
                multipart.addBodyPart(attachPart);
            }
            message.setContent(multipart);

            // Gửi email
            Transport.send(message);
            System.out.println("Sent message successfully to " + recipient);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMail() {
        sendMail("", "Subject Of Email", "Hello,\nThis is a test email.");
    }

    public static void main(String[] args) {
        MailDemo mailDemo = new MailDemo();
        mailDemo.sendMail();
    }
}
