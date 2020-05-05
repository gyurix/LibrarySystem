//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.05 at 03:22:26 PM CEST 
//


package gyurix.librarysystem.services.user;

import lombok.Getter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the gyurix.librarysystem.services.user package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {
  private final static QName _DeleteResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "deleteResponse");
  private final static QName _Delete_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "delete");
  private final static QName _GetAllResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getAllResponse");
  private final static QName _GetAll_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getAll");
  private final static QName _GetByAttributeValueResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getByAttributeValueResponse");
  private final static QName _GetByAttributeValue_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getByAttributeValue");
  private final static QName _GetByIdResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getByIdResponse");
  private final static QName _GetById_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getById");
  private final static QName _GetByNumericConditionResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getByNumericConditionResponse");
  private final static QName _GetByNumericCondition_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "getByNumericCondition");
  private final static QName _InsertResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "insertResponse");
  private final static QName _Insert_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "insert");
  private final static QName _UpdateResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "updateResponse");
  private final static QName _Update_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "update");
  private final static QName _User_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "User");
  private final static QName _Users_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", "Users");
  @Getter
  private static final ObjectFactory instance = new ObjectFactory();

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gyurix.librarysystem.services.user
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link ArrayOfIds }
   */
  public ArrayOfIds createArrayOfIds() {
    return new ArrayOfIds();
  }

  /**
   * Create an instance of {@link ArrayOfUsers }
   */
  public ArrayOfUsers createArrayOfUsers() {
    return new ArrayOfUsers();
  }

  /**
   * Create an instance of {@link Delete }
   */
  public Delete createDelete() {
    return new Delete();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "delete")
  public JAXBElement<Delete> createDelete(Delete value) {
    return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
  }

  /**
   * Create an instance of {@link DeleteResponse }
   */
  public DeleteResponse createDeleteResponse() {
    return new DeleteResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "deleteResponse")
  public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
    return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
  }

  /**
   * Create an instance of {@link GetAll }
   */
  public GetAll createGetAll() {
    return new GetAll();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getAll")
  public JAXBElement<GetAll> createGetAll(GetAll value) {
    return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
  }

  /**
   * Create an instance of {@link GetAllResponse }
   */
  public GetAllResponse createGetAllResponse() {
    return new GetAllResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getAllResponse")
  public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
    return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
  }

  /**
   * Create an instance of {@link GetByAttributeValue }
   */
  public GetByAttributeValue createGetByAttributeValue() {
    return new GetByAttributeValue();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetByAttributeValue }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getByAttributeValue")
  public JAXBElement<GetByAttributeValue> createGetByAttributeValue(GetByAttributeValue value) {
    return new JAXBElement<GetByAttributeValue>(_GetByAttributeValue_QNAME, GetByAttributeValue.class, null, value);
  }

  /**
   * Create an instance of {@link GetByAttributeValueResponse }
   */
  public GetByAttributeValueResponse createGetByAttributeValueResponse() {
    return new GetByAttributeValueResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetByAttributeValueResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getByAttributeValueResponse")
  public JAXBElement<GetByAttributeValueResponse> createGetByAttributeValueResponse(GetByAttributeValueResponse value) {
    return new JAXBElement<GetByAttributeValueResponse>(_GetByAttributeValueResponse_QNAME, GetByAttributeValueResponse.class, null, value);
  }

  /**
   * Create an instance of {@link GetById }
   */
  public GetById createGetById() {
    return new GetById();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getById")
  public JAXBElement<GetById> createGetById(GetById value) {
    return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
  }

  /**
   * Create an instance of {@link GetByIdResponse }
   */
  public GetByIdResponse createGetByIdResponse() {
    return new GetByIdResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getByIdResponse")
  public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
    return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
  }

  /**
   * Create an instance of {@link GetByNumericCondition }
   */
  public GetByNumericCondition createGetByNumericCondition() {
    return new GetByNumericCondition();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetByNumericCondition }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getByNumericCondition")
  public JAXBElement<GetByNumericCondition> createGetByNumericCondition(GetByNumericCondition value) {
    return new JAXBElement<GetByNumericCondition>(_GetByNumericCondition_QNAME, GetByNumericCondition.class, null, value);
  }

  /**
   * Create an instance of {@link GetByNumericConditionResponse }
   */
  public GetByNumericConditionResponse createGetByNumericConditionResponse() {
    return new GetByNumericConditionResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GetByNumericConditionResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "getByNumericConditionResponse")
  public JAXBElement<GetByNumericConditionResponse> createGetByNumericConditionResponse(GetByNumericConditionResponse value) {
    return new JAXBElement<GetByNumericConditionResponse>(_GetByNumericConditionResponse_QNAME, GetByNumericConditionResponse.class, null, value);
  }

  /**
   * Create an instance of {@link Insert }
   */
  public Insert createInsert() {
    return new Insert();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "insert")
  public JAXBElement<Insert> createInsert(Insert value) {
    return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
  }

  /**
   * Create an instance of {@link InsertResponse }
   */
  public InsertResponse createInsertResponse() {
    return new InsertResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "insertResponse")
  public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
    return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
  }

  /**
   * Create an instance of {@link Update }
   */
  public Update createUpdate() {
    return new Update();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "update")
  public JAXBElement<Update> createUpdate(Update value) {
    return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
  }

  /**
   * Create an instance of {@link UpdateResponse }
   */
  public UpdateResponse createUpdateResponse() {
    return new UpdateResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "updateResponse")
  public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
    return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
  }

  /**
   * Create an instance of {@link User }
   */
  public User createUser() {
    return new User();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "User")
  public JAXBElement<User> createUser(User value) {
    return new JAXBElement<User>(_User_QNAME, User.class, null, value);
  }

  /**
   * Create an instance of {@link Users }
   */
  public Users createUsers() {
    return new Users();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Users }{@code >}}
   */
  @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types", name = "Users")
  public JAXBElement<Users> createUsers(Users value) {
    return new JAXBElement<Users>(_Users_QNAME, Users.class, null, value);
  }

}
