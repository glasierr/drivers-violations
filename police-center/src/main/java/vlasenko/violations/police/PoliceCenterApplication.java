package vlasenko.violations.police;

<<<<<<< HEAD
=======
import org.activiti.engine.RuntimeService;
>>>>>>> ba1ae04cf9ed4027a876c8b9e57e49796103dd6a
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
import vlasenko.violations.police.notifier.DriverNotifier;
import vlasenko.violations.police.notifier.service.NotificationRequest;
=======

import java.util.HashMap;
import java.util.Map;
>>>>>>> ba1ae04cf9ed4027a876c8b9e57e49796103dd6a

@SpringBootApplication
public class PoliceCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoliceCenterApplication.class, args);
<<<<<<< HEAD


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
=======
    }

    @Bean
    CommandLineRunner lookup(RuntimeService runtimeService) {
        return args -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("violation", "Hell");
            variables.put("driverId", 1);
            runtimeService.startProcessInstanceByKey("violationProcession", variables);
>>>>>>> ba1ae04cf9ed4027a876c8b9e57e49796103dd6a
        };
    }
}
