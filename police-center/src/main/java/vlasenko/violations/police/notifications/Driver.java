package vlasenko.violations.police.notifications;

import java.io.Serializable;

public class Driver implements Serializable {

    private long id;
    private String name;
    private String surname;

    private String licenceNumber;

    private String vehicleRegistrationNumber;

    private String email;

    private String phoneNumber;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
