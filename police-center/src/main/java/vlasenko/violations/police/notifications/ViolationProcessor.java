package vlasenko.violations.police.notifications;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vlasenko.violations.police.notifications.service.NotificationRequest;

@Component
public class ViolationProcessor {
    
    private DriverNotifier driverNotifier;
    private DriverInformation driverInformation;
    
    @Autowired
    public ViolationProcessor(DriverNotifier driverNotifier,
                              DriverInformation driverInformation) {
        this.driverNotifier = driverNotifier;
        this.driverInformation = driverInformation;
    }
    
    public void sendViolation(String violation, long driverId) {
        NotificationRequest request = new NotificationRequest();
        
        JsonObject driver = driverInformation.getDriverInformation(driverId).orElseThrow(() ->
                new IllegalArgumentException("No driver was found with id " + driverId));
        
        request.setName(driver.getAsJsonPrimitive("name").toString());
        request.setSurname(driver.getAsJsonPrimitive("surname").toString());
        request.setLicenceNumber(driver.getAsJsonPrimitive("licenceNumber").toString());
        request.setEmail(driver.getAsJsonPrimitive("email").toString());
        request.setVehicleRegistrationNumber(driver.getAsJsonPrimitive("vehicleRegistrationNumber").toString());
        request.setPhoneNumber(driver.getAsJsonPrimitive("phoneNumber").toString());
        request.setViolation(violation);
    
        System.out.println("Sending violation: " + violation + " to driver " + driverId);
        driverNotifier.notifyDriver(request);
    }
    
    public void suppressViolation(String violation) {
        System.out.println("Suppressing violation: " + violation);
    }
}
