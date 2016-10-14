package vlasenko.violations.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PoliceCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoliceCenterApplication.class, args);
    }
}
