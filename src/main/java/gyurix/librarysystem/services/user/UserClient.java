package gyurix.librarysystem.services.user;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UserClient extends WebServiceGatewaySupport {
    public InsertResponse insertUser(User user) {
        Insert insert = new Insert();
        insert.setTeamId(Integer.toString(115));
        insert.setTeamPassword("ZF4XPV");
        insert.setUser(user);

        InsertResponse response = (InsertResponse)getWebServiceTemplate().marshalSendAndReceive(insert);
        return response;

    }

    public GetByIdResponse getUser(int userId) {
        GetById id = new GetById();
        id.setId(userId);

        GetByIdResponse response = (GetByIdResponse)getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User?WSDL", id);
        return response;
    }
}
