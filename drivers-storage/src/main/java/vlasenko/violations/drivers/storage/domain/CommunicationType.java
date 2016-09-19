package vlasenko.violations.drivers.storage.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "communication_type")
public class CommunicationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communication_type_id")
    private int id;

    @Column(name = "communication_type_name", nullable = false)
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryKey.communication_type")
    private Set<DriverCommunication> driverCommunications = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        CommunicationType that = (CommunicationType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CommunicationType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
