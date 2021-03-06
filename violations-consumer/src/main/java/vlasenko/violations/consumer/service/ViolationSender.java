package vlasenko.violations.consumer.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import vlasenko.violations.consumer.domain.Violation;

@Service
public class ViolationSender {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public ViolationSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendViolation(Violation violation) {
        sendViolation(new Gson().toJson(violation));
    }

    public void sendViolation(JsonObject violation) {
        sendViolation(violation.toString());
    }

    private void sendViolation(String violation) {
        jmsTemplate.convertAndSend("violations", violation);
    }
}
