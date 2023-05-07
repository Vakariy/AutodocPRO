package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CredentialFactory {
    private int counter = 0;
    private final String domain = "@example.com";
    private final String prefix = "user";

    public String generateEmail() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestamp = now.format(formatter);
        String email = prefix + timestamp + counter + domain;
        counter++;
        return email;
    }
}