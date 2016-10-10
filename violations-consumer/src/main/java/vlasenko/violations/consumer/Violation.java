package vlasenko.violations.consumer;

import java.io.Serializable;

public class Violation implements Serializable {
    private String violation;
    private long driverId;
    
    public Violation(String violation, long driverId) {
        this.violation = violation;
        this.driverId = driverId;
    }
    
    public String getViolation() {
        return violation;
    }
    
    public void setViolation(String violation) {
        this.violation = violation;
    }
    
    public long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}
