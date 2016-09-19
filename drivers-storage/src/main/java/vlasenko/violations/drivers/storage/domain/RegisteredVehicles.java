package vlasenko.violations.drivers.storage.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "registered_vehicles")
public class RegisteredVehicles implements Serializable {

    @Id
    private String vehicleNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredVehicles that = (RegisteredVehicles) o;
        return Objects.equals(vehicleNumber, that.vehicleNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber);
    }

    @Override
    public String toString() {
        return "RegisteredVehicles{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", driver=" + driver +
                '}';
    }
}
