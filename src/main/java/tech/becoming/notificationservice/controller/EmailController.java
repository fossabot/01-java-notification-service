package tech.becoming.notificationservice.controller;

import org.springframework.web.bind.annotation.*;
import tech.becoming.notificationservice.repository.EmailRepository;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.service.EmailService;
import tech.becoming.notificationservice.service.EmailValidatorService;

import java.awt.*;

@RequestMapping("email")
@RestController
public class EmailController {

    private EmailService emailService;
    private EmailRepository emailRepository;
    private EmailValidatorService emailValidatorService;

    public EmailController(EmailService emailService, EmailRepository emailRepository, EmailValidatorService emailValidatorService) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
        this.emailValidatorService = emailValidatorService;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailValidatorService.validate(emailRequest);

        return emailService.register(emailRequest).getId();
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable String id) {
        return emailRepository.getById(id);
    }

}
