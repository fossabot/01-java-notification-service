package tech.becoming.notificationservice.controller;

import org.springframework.web.bind.annotation.*;
import tech.becoming.notificationservice.repository.EmailRepository;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.service.EmailService;

@RequestMapping("email")
@RestController
public class EmailController {

    private EmailService emailService;
    private EmailRepository emailRepository;

    public EmailController(EmailService emailService, EmailRepository emailRepository) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        return emailService.register(emailRequest).getId();
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable String id) {
        return emailRepository.getById(id);
    }

}
