package vlasenko.violations.police.notifications;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class DriverInformation {
    
    public Optional<Driver> getDriverInformation(long driverId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Driver> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(
                    "http://localhost:8081/drivers/" + driverId,
                    Driver.class);
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }

        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.hasBody()) {
            return Optional.of(responseEntity.getBody());
        } else {
            return Optional.empty();
        }
    }
    
}
