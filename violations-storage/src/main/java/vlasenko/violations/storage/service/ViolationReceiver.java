package vlasenko.violations.storage.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ViolationReceiver {
    
    @JmsListener(destination = "violations")
    public void receiveMessage(String violation) {
        System.out.println("-------------------------" + violation + "--------------------------");
    }
}
