package vlasenko.violations.drivers.storage.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private long id;
    private String name;
    private String surname;

    @Column(name = "licence_number", nullable = false)
    private String licenceNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<RegisteredVehicles> registeredVehicles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryKey.driver")
    private Set<DriverCommunication> driverCommunications = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Set<RegisteredVehicles> getRegisteredVehicles() {
        return registeredVehicles;
    }

    public void setRegisteredVehicles(Set<RegisteredVehicles> registeredVehicles) {
        this.registeredVehicles = registeredVehicles;
    }

    public Set<DriverCommunication> getDriverCommunications() {
        return driverCommunications;
    }

    public void setDriverCommunications(Set<DriverCommunication> driverCommunications) {
        this.driverCommunications = driverCommunications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(licenceNumber, driver.licenceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceNumber);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", registeredVehicles=" + registeredVehicles +
                '}';
    }
}
