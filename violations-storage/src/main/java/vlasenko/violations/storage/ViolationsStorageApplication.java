package vlasenko.violations.storage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import vlasenko.violations.storage.service.ViolationSender;

@SpringBootApplication
@EnableJms
public class ViolationsStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViolationsStorageApplication.class, args);
    }
    
    @Bean
    CommandLineRunner lookup(ViolationSender sender) {
        return args -> {
            sender.sendViolation("BEBEB");
            System.out.println("sent");
        };
    }
}
