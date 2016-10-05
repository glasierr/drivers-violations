package vlasenko.violations.police;

import org.activiti.engine.RuntimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PoliceCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoliceCenterApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(RuntimeService runtimeService) {
        return args -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("violation", "Hell");
            variables.put("driverId", 1);
            runtimeService.startProcessInstanceByKey("violationProcession", variables);
        };
    }
}
