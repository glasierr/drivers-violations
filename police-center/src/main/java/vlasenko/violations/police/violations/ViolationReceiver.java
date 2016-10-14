package vlasenko.violations.police.violations;

import com.google.gson.Gson;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ViolationReceiver {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @JmsListener(destination = "violations")
    public void receiveMessage(String violationJson) {
        Violation violation = new Gson().fromJson(violationJson, Violation.class);
        
        Map<String, Object> variables = new HashMap<>();
        variables.put("violation", violation.getViolation());
        variables.put("driverId", violation.getDriverId());
        
        runtimeService.startProcessInstanceByKey("violationProcession", variables);
    }
}
