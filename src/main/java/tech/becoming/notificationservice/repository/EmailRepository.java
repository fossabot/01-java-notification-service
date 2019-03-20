package tech.becoming.notificationservice.repository;

import org.springframework.stereotype.Component;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.exception.NotFoundException;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class EmailRepository {
    private Map<String, EmailRequest> requests = new ConcurrentHashMap<>();

    public EmailRequest save(EmailRequest emailRequest) {
        emailRequest.setId(UUID.randomUUID().toString());

        requests.put(emailRequest.getId(), emailRequest);

        return emailRequest;
    }

    public EmailRequest getById(String id) {
        final EmailRequest emailRequest = requests.get(id);

        if(emailRequest == null) {
            throw new NotFoundException();
        }

        return emailRequest;
    }
}
