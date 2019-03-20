package tech.becoming.notificationservice.controller;

import org.springframework.web.bind.annotation.*;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("email")
@RestController
public class EmailController {

    private Map<String, EmailRequest> requests = new HashMap<>();

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailRequest.setId(UUID.randomUUID().toString());

        requests.put(emailRequest.getId(), emailRequest);

        return emailRequest.getId();
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable String id) {
        final EmailRequest emailRequest = requests.get(id);

        if(emailRequest == null) {
            throw new NotFoundException();
        }

        return emailRequest;
    }

}
