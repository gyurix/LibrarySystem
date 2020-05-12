package gyurix.librarysystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
  public static SOAPConnector client;

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("gyurix.librarysystem.services");
    return marshaller;
  }

  @Bean
  public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
    SOAPConnector client = new SOAPConnector();
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    Config.client = client;
    return client;
  }
}
