package vlasenko.violations.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ViolationsStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViolationsStorageApplication.class, args);
    }
}
