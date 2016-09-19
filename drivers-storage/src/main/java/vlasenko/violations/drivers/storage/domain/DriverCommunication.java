package vlasenko.violations.drivers.storage.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "driver_communication")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.driver", joinColumns = @JoinColumn(name = "driver_id")),
    @AssociationOverride(name = "primaryKey.communication_type", joinColumns = @JoinColumn(name = "communication_type_id")),
})
public class DriverCommunication implements Serializable {
    private DriverCommunicationId primaryKey = new DriverCommunicationId();

    @Column(nullable = false)
    private String value;

    @EmbeddedId
    public DriverCommunicationId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(DriverCommunicationId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Transient
    public Driver getDriver() {
        return primaryKey.getDriver();
    }

    public void setDriver(Driver driver) {
        primaryKey.setDriver(driver);
    }

    @Transient
    public CommunicationType getCommunicationType() {
        return primaryKey.getCommunicationType();
    }

    public void setCommunicationType(CommunicationType communicationType) {
        primaryKey.setCommunicationType(communicationType);
    }
}
