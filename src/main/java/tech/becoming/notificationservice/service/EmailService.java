package tech.becoming.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.helper.EmailHelper;
import tech.becoming.notificationservice.properties.EmailProperties;
import tech.becoming.notificationservice.repository.EmailRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

@Service
public class EmailService {

    private Logger log = LoggerFactory.getLogger(getClass());
    private EmailRepository emailRepository;
    private EmailHelper emailHelper;
    private EmailProperties emailProperties;

    public EmailService(EmailRepository emailRepository, EmailHelper emailHelper, EmailProperties emailProperties) {
        this.emailRepository = emailRepository;
        this.emailHelper = emailHelper;
        this.emailProperties = emailProperties;
    }

    public EmailRequest register(EmailRequest emailRequest) {
        emailRequest = emailRepository.save(emailRequest);

        try {
            sendEmail(emailRequest);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }

        return emailRequest;
    }

    private void sendEmail(EmailRequest emailRequest) throws MessagingException {
        Session session = emailHelper.createSession(emailProperties.toProperties());
        Message message = emailHelper.createMessage(emailRequest, session);

        Transport.send(message);
    }


}
