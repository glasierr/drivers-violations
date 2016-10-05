package vlasenko.violations.police.notifications;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import vlasenko.violations.police.notifications.service.NotificationRequest;

@Component
public class DriverNotifier extends WebServiceGatewaySupport {

    public void notifyDriver(NotificationRequest request) {
        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8082/ws/notificationRequest", request);
    }
}
