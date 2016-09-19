package vlasenko.violations.drivers.storage.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class DriverCommunicationId implements Serializable {
    private Driver driver;
    private CommunicationType communicationType;

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(CommunicationType communicationType) {
        this.communicationType = communicationType;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Driver getDriver() {
        return driver;
    }
}
