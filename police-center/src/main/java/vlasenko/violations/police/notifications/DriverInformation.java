package vlasenko.violations.police.notifications;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverInformation {
    
    public Optional<JsonObject> getDriverInformation(long driverId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "name");
        jsonObject.addProperty("surname", "surname");
        jsonObject.addProperty("licenceNumber", "licenceNumber");
        jsonObject.addProperty("vehicleRegistrationNumber", "vehicleRegistrationNumber");
        jsonObject.addProperty("email", "email");
        jsonObject.addProperty("phoneNumber", "phoneNumber");
        return Optional.of(jsonObject);
    }
    
}
