package vlasenko.violations.storage.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import vlasenko.violations.storage.Violation;

@Component
public class ViolationReceiver {
    
    @JmsListener(destination = "violations")
    public void receiveMessage(String violationJson) {
        Violation violation = new Gson().fromJson(violationJson, Violation.class);
        System.out.println("-------------------------" + violation.getViolation() + " " + violation.getDriverId() + "--------------------------");
    }
}
