package vlasenko.violations.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import vlasenko.violations.consumer.Violation;

@Service
public class ViolationSender {
    private final JmsTemplate jmsTemplate;
    
    @Autowired
    public ViolationSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    public void sendViolation(Violation violation) {
        jmsTemplate.convertAndSend("violations", violation);
    }
}
