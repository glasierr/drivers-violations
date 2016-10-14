package vlasenko.violations.drivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("vlasenko.violations.drivers")
@EnableJpaRepositories("vlasenko.violations.drivers.repository")
public class DriversStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DriversStorageApplication.class, args);
    }
}
