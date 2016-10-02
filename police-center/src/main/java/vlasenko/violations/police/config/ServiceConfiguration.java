package vlasenko.violations.police.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import vlasenko.violations.police.notifier.DriverNotifier;

@Configuration
public class ServiceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("vlasenko.violations.police.notifier.service");
        return marshaller;
    }

    @Bean
    public DriverNotifier driverNotifier(Jaxb2Marshaller marshaller) {
        DriverNotifier notifier = new DriverNotifier();
        notifier.setMarshaller(marshaller);
        notifier.setUnmarshaller(marshaller);
        return notifier;
    }
}
