package vlasenko.violations.police.notifications;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class DriverInformation {
    
    public Optional<Driver> getDriverInformation(long driverId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Driver> responseEntity = restTemplate.getForEntity(
                "http://localhost:8081/drivers/" + driverId,
                Driver.class);
        
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.hasBody()) {
            Optional.of(responseEntity.getBody());
        } else {
            return Optional.empty();
        }
    }
    
}
