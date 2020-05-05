package gyurix.librarysystem;

import gyurix.librarysystem.services.user.GetAll;
import gyurix.librarysystem.services.user.GetAllResponse;
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
}
