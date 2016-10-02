package vlasenko.violations.police;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vlasenko.violations.police.notifier.DriverNotifier;
import vlasenko.violations.police.notifier.service.NotificationRequest;

@SpringBootApplication
public class PoliceCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoliceCenterApplication.class, args);


    }

    @Bean
    CommandLineRunner lookup(DriverNotifier driverNotifier) {
        System.out.println("here");
        NotificationRequest request = new NotificationRequest();
        request.setName("Name");
        request.setSurname("Surname");
        request.setEmail("Email");
        request.setPhoneNumber("Phone");
        request.setLicenceNumber("licence");
        request.setVehicleRegistrationNumber("vehicle");
        request.setViolation("Bad boy");
        driverNotifier.notifyDriver(request);
        return args -> {
            driverNotifier.notifyDriver(request);
        };
    }
}
