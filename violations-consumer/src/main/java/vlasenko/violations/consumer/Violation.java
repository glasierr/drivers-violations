package vlasenko.violations.consumer;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Violation implements Serializable {
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
}
