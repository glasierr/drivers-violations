package vlasenko.violations.drivers.notifications.service;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class NotificationService {

    @PayloadRoot(namespace = "http://www.w3.org/ns/wsdl", localPart = "notificationRequest")
    @ResponsePayload
    public void notify(@RequestPayload JAXBElement<NotificationRequest> notificationRequest) {
        System.out.println(notificationRequest.getValue());
    }
}
