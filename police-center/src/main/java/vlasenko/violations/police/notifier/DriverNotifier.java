package vlasenko.violations.police.notifier;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import vlasenko.violations.police.notifier.service.NotificationRequest;

public class DriverNotifier extends WebServiceGatewaySupport {

    public void notifyDriver(NotificationRequest request) {
        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8082/ws/notificationRequest", request);
    }
}
