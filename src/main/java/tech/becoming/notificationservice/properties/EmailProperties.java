package tech.becoming.notificationservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties("mail.smtp")
public class EmailProperties {

    private Boolean auth;
    private String starttlsEnable;
    private String host;
    private String port;
    private String sslTrust;

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public void setStarttlsEnable(String starttlsEnable) {
        this.starttlsEnable = starttlsEnable;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setSslTrust(String sslTrust) {
        this.sslTrust = sslTrust;
    }

    public Properties toProperties() {
        Properties prop = new Properties();
        // prop.put("mail.smtp.auth", this.auth);
        // prop.put("mail.smtp.starttls.enable", this.starttlsEnable);
        prop.put("mail.smtp.host", this.host);
        prop.put("mail.smtp.port", this.port);
        // prop.put("mail.smtp.ssl.trust", this.sslTrust);

        return prop;
    }

}
