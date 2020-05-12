package gyurix.librarysystem;

import gyurix.librarysystem.services.email.Notify;
import gyurix.librarysystem.services.email.NotifyResponse;
import gyurix.librarysystem.services.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class SOAPConnector extends WebServiceGatewaySupport {
  private static final Logger log = LoggerFactory.getLogger(SOAPConnector.class);
  public static SOAPConnector instance;

  public SOAPConnector() {
    super();
    instance = this;
  }

  public Object callWebService(String url, Object request) {
    return getWebServiceTemplate().marshalSendAndReceive(url, request);
  }

  public GetAllResponse getAll() {
    log.info("getAll");
    return ((JAXBElement<GetAllResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", new GetAll())).getValue();
  }

  public InsertResponse insertUser(User user) {
    Insert insert = new Insert();
    insert.setTeamId("115");
    insert.setTeamPassword("ZF4XPV");
    insert.setUser(user);

    return ((JAXBElement<InsertResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", insert)).getValue();
  }

  public GetByAttributeValueResponse getUser(String email) {
    GetByAttributeValue getByAttributeValue = new GetByAttributeValue();
    getByAttributeValue.setAttributeName("email");
    getByAttributeValue.setIds(new ArrayOfIds());
    getByAttributeValue.setAttributeValue(email);

    return ((JAXBElement<GetByAttributeValueResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", getByAttributeValue)).getValue();
  }

  public NotifyResponse sendSignupMessage(User user) {
    Notify notify = new Notify();
    notify.setTeamId("115");
    notify.setPassword("ZF4XPV");
    notify.setEmail(user.getEmail());
    notify.setSubject("[ISK] Registrácia prebehla úspešne");
    notify.setMessage("Používateľ " + user.getName() + " bol uspesne zaregistrovany");


    return ((JAXBElement<NotifyResponse>)getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/NotificationServices/Email", notify)).getValue();

  }
}
