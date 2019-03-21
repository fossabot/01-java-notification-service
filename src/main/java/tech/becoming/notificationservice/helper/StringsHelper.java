package tech.becoming.notificationservice.helper;

import org.springframework.stereotype.Component;

@Component
public class StringsHelper {

    public boolean isNullOrEmpty(String string) {
        return string == null || string.replaceAll(" ", "").equals("");
    }

}
