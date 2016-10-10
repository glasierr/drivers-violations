package vlasenko.violations.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViolationSender {
    private final JmsTemplate jmsTemplate;
    
    @Autowired
    public ViolationSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    public void sendViolation(String violation) {
        jmsTemplate.convertAndSend("violations", violation);
    }
}
