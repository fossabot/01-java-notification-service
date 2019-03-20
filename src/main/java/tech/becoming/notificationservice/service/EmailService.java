package tech.becoming.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.exception.NotFoundException;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmailService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private Map<String, EmailRequest> requests = new ConcurrentHashMap<>();

    public EmailRequest register(EmailRequest emailRequest) {
        emailRequest.setId(UUID.randomUUID().toString());

        requests.put(emailRequest.getId(), emailRequest);

        try {
            sendEmail(emailRequest);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }

        return emailRequest;
    }

    private void sendEmail(EmailRequest emailRequest) throws MessagingException {

        Properties prop = new Properties();
        // prop.put("mail.smtp.auth", true);
        // prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "localhost");
        prop.put("mail.smtp.port", "25");
        // prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop);

        // Session session = Session.getInstance(prop, new Authenticator() {
        //     @Override
        //     protected PasswordAuthentication getPasswordAuthentication() {
        //         return new PasswordAuthentication(username, password);
        //     }
        // });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailRequest.getFrom()));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailRequest.getTo()));
        message.setSubject(emailRequest.getSubject());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(emailRequest.getMessage(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

    public EmailRequest getById(String id) {
        final EmailRequest emailRequest = requests.get(id);

        if(emailRequest == null) {
            throw new NotFoundException();
        }

        return emailRequest;
    }


}
