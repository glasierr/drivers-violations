package vlasenko.violations.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vlasenko.violations.consumer.Violation;
import vlasenko.violations.consumer.service.ViolationSender;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class ViolationConsumerApi {

    @Autowired
    private ViolationSender sender;

    @RequestMapping(method = RequestMethod.POST, path = "/violations")
    public void consumeViolation(@NotNull @Valid Violation violation) {
        sender.sendViolation(violation);
    }
}
