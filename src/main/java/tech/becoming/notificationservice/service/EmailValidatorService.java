package tech.becoming.notificationservice.service;

import org.springframework.stereotype.Service;
import tech.becoming.notificationservice.data.EmailRequest;
import tech.becoming.notificationservice.exception.UnprocessableEntity;
import tech.becoming.notificationservice.exception.ValidationFail;
import tech.becoming.notificationservice.helper.StringsHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailValidatorService {

    private String emailRegexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    private StringsHelper stringsHelper;

    public EmailValidatorService(StringsHelper stringsHelper) {this.stringsHelper = stringsHelper;}

    public void validate(EmailRequest emailRequest) {
        List<ValidationFail> fails = new ArrayList<>();

        if(stringsHelper.isNullOrEmpty(emailRequest.getTo())) {
            fails.add(new ValidationFail("to", "cannot be null nor empty"));

        } else if(!emailRequest.getTo().matches(emailRegexp)) {
            fails.add(new ValidationFail("to", "does not seems to be a e-mail address"));
        }

        if(stringsHelper.isNullOrEmpty(emailRequest.getFrom())) {
            fails.add(new ValidationFail("from", "cannot be null nor empty"));

        } else if(!emailRequest.getFrom().matches(emailRegexp)) {
            fails.add(new ValidationFail("from", "does not seems to be a e-mail address"));
        }

        if(stringsHelper.isNullOrEmpty(emailRequest.getSubject())) {
            fails.add(new ValidationFail("subject", "cannot be null nor empty"));
        }

        if(stringsHelper.isNullOrEmpty(emailRequest.getMessage())) {
            fails.add(new ValidationFail("message", "cannot be null nor empty"));
        }

        if(fails.size() > 0) {
            throw new UnprocessableEntity(fails);
        }
    }
}
