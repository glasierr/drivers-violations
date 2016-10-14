package vlasenko.violations.consumer.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "violations")
public class Violation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @NotEmpty
    private String violation;

    @NotNull
    private Long driverId;
    
    public Violation(String violation, Long driverId) {
        this.violation = violation;
        this.driverId = driverId;
    }
    
    public String getViolation() {
        return violation;
    }
    
    public void setViolation(String violation) {
        this.violation = violation;
    }
    
    public Long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    
    public int getId() {
        return id;
    }
}
