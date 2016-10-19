package vlasenko.violations.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vlasenko.violations.consumer.domain.Violation;
import vlasenko.violations.consumer.repository.ViolationsRepository;
import vlasenko.violations.consumer.service.ViolationSender;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/violations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViolationConsumerApi {

    private ViolationSender sender;
    private ViolationsRepository violationsRepository;

    @Autowired
    public ViolationConsumerApi(ViolationSender violationSender, ViolationsRepository violationsRepository) {
        this.sender = violationSender;
        this.violationsRepository = violationsRepository;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void consumeViolation(@RequestBody @NotNull @Valid Violation violation) {
        violationsRepository.save(violation);
        sender.sendViolation(violation);
    }
}
