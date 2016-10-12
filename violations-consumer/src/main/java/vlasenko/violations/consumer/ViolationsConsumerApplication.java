package vlasenko.violations.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import vlasenko.violations.consumer.service.ViolationSender;

@SpringBootApplication
public class ViolationsConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViolationsConsumerApplication.class, args);
    }
    
    @Bean
    CommandLineRunner lookup(ViolationSender sender) {
        return args -> {
            sender.sendViolation("BIG VIOLATION");
            System.out.println("sent");
        };
    }
}
