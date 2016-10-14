package vlasenko.violations.police.notifications;

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
        
        Driver driver = driverInformation.getDriverInformation(driverId).orElseThrow(() ->
                new IllegalArgumentException("No driver was found with id " + driverId));
        
        request.setName(driver.getName());
        request.setSurname(driver.getSurname());
        request.setLicenceNumber(driver.getLicenceNumber());
        request.setEmail(driver.getEmail());
        request.setVehicleRegistrationNumber(driver.getVehicleRegistrationNumber());
        request.setPhoneNumber(driver.getPhoneNumber());
        request.setViolation(violation);
    
        System.out.println("Sending violation: " + violation + " to driver " + driverId);
        driverNotifier.notifyDriver(request);
    }
    
    public void suppressViolation(String violation) {
        System.out.println("Suppressing violation: " + violation);
    }
}
