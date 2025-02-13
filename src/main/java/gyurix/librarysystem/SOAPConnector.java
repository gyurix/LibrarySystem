package gyurix.librarysystem;

import gyurix.librarysystem.services.book.*;
import gyurix.librarysystem.services.comment.*;
import gyurix.librarysystem.services.email.Notify;
import gyurix.librarysystem.services.email.NotifyResponse;
import gyurix.librarysystem.services.explicit_terms.Explicittermss;
import gyurix.librarysystem.services.explicit_terms.GetAll;
import gyurix.librarysystem.services.user.ArrayOfIds;
import gyurix.librarysystem.services.user.GetByAttributeValue;
import gyurix.librarysystem.services.user.GetByAttributeValueResponse;
import gyurix.librarysystem.services.user.Insert;
import gyurix.librarysystem.services.user.InsertResponse;
import gyurix.librarysystem.services.user.Update;
import gyurix.librarysystem.services.user.UpdateResponse;
import gyurix.librarysystem.services.user.*;
import gyurix.librarysystem.services.validator.ValidateEmail;
import gyurix.librarysystem.services.validator.ValidateEmailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"unchecked", "DuplicatedCode"})
public class SOAPConnector extends WebServiceGatewaySupport {
  public static final String DB_WSDL_URL = "http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User";
  public static final String EMAIL_WSDL_URL = "http://pis.predmety.fiit.stuba.sk/pis/ws/NotificationServices/Email";
  public static final String VALIDATE_WSDL_URL = "http://pis.predmety.fiit.stuba.sk/pis/ws/Validator";
  public static final String TEAM_ID = "115";
  public static final String TEAM_PASSWORD = "ZF4XPV";
  private static final Logger log = LoggerFactory.getLogger(SOAPConnector.class);
  private static final String DB_EXPLICIT_TERMS_WSDL_URL = "http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115ExplicitTerms";
  public static SOAPConnector instance;

  public SOAPConnector() {
    super();
    instance = this;
  }

  public <T> T bookRequest(Object request, Class<T> responseClass) {
    return ((JAXBElement<T>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115Book", request)).getValue();
  }

  public Object callWebService(String url, Object request) {
    return getWebServiceTemplate().marshalSendAndReceive(url, request);
  }

  public <T> T commentRequest(Object request, Class<T> responseClass) {
    return ((JAXBElement<T>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115Komentar", request)).getValue();
  }

  public void deleteComment(int id) {
    CommentDelete request = new CommentDelete();
    request.setEntityId(id);
    request.setTeamId(TEAM_ID);
    request.setTeamPassword(TEAM_PASSWORD);
    commentRequest(request, CommentDeleteResponse.class);
  }

  public UserGetAllResponse getAllUsers() {
    log.info("getAll");
    return ((JAXBElement<UserGetAllResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", new UserGetAll())).getValue();
  }

  public Book getBookById(int bookId) {
    BookGetById request = new BookGetById();
    request.setId(bookId);
    return bookRequest(request, BookGetByIdResponse.class).getBook();
  }

  public List<Comment> getCommentsByBook(int bookId) {
    CommentGetAllResponse comments = commentRequest(new CommentGetAll(), CommentGetAllResponse.class);
    List<Users> users = userRequest(new UserGetAll(), UserGetAllResponse.class).getUsers().getUser();
    List<Books> books = bookRequest(new BookGetAll(), BookGetAllResponse.class).getBooks().getBook();
    HashMap<Integer, Books> bookCache = new HashMap<>();
    HashMap<Integer, Users> userCache = new HashMap<>();
    books.forEach(b -> bookCache.put(b.getId(), b));
    users.forEach(u -> userCache.put(u.getId(), u));
    List<Comment> out = new ArrayList<>();
    comments.getKomentars().getKomentar().forEach((e) -> {
      if (e.getBookId() == bookId) {
        Books book = bookCache.get(e.getBookId());
        Users user = userCache.get(e.getUserID());
        e.setBookName(book == null ? "Unknown Book #" + e.getBookId() : book.getName());
        e.setUserName(user == null ? "Unknown User #" + user.getId() : user.getName());
        out.add(e);
      }
    });
    return out;
  }

  public List<Comment> getCommentsByUser(int userId) {
    List<Users> users = userRequest(new UserGetAll(), UserGetAllResponse.class).getUsers().getUser();
    List<Books> books = bookRequest(new BookGetAll(), BookGetAllResponse.class).getBooks().getBook();
    CommentGetAllResponse comments = commentRequest(new CommentGetAll(), CommentGetAllResponse.class);
    HashMap<Integer, Books> bookCache = new HashMap<>();
    HashMap<Integer, Users> userCache = new HashMap<>();
    books.forEach(b -> bookCache.put(b.getId(), b));
    users.forEach(u -> userCache.put(u.getId(), u));
    List<Comment> out = new ArrayList<>();
    comments.getKomentars().getKomentar().forEach((e) -> {
      if (e.getUserID() == userId) {
        Books book = bookCache.get(e.getBookId());
        Users user = userCache.get(e.getUserID());
        e.setBookName(book == null ? "Unknown Book #" + e.getBookId() : book.getName());
        e.setUserName(user == null ? "Unknown User #" + user.getId() : user.getName());
        out.add(e);
      }
    });
    return out;
  }

  public List<Comment> getUnsolvedComments() {
    List<Users> users = userRequest(new UserGetAll(), UserGetAllResponse.class).getUsers().getUser();
    List<Books> books = bookRequest(new BookGetAll(), BookGetAllResponse.class).getBooks().getBook();
    CommentGetAllResponse comments = commentRequest(new CommentGetAll(), CommentGetAllResponse.class);
    HashMap<Integer, Books> bookCache = new HashMap<>();
    HashMap<Integer, Users> userCache = new HashMap<>();
    books.forEach(b -> bookCache.put(b.getId(), b));
    users.forEach(u -> userCache.put(u.getId(), u));
    List<Comment> out = new ArrayList<>();
    comments.getKomentars().getKomentar().forEach((e) -> {
      if (!e.isAccepted()) {
        Books book = bookCache.get(e.getBookId());
        Users user = userCache.get(e.getUserID());
        e.setBookName(book == null ? "Unknown Book #" + e.getBookId() : book.getName());
        e.setUserName(user == null ? "Unknown User #" + user.getId() : user.getName());
        out.add(e);
      }
    });
    return out;
  }

  public GetByAttributeValueResponse getUser(String email) {
    GetByAttributeValue getByAttributeValue = new GetByAttributeValue();
    getByAttributeValue.setAttributeName("email");
    getByAttributeValue.setIds(new ArrayOfIds());
    getByAttributeValue.setAttributeValue(email);

    return ((JAXBElement<GetByAttributeValueResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", getByAttributeValue)).getValue();
  }

  public GetByIdResponse getUserById(int id) {
    GetById getById = new GetById();
    getById.setId(id);
    return ((JAXBElement<GetByIdResponse>) getWebServiceTemplate().marshalSendAndReceive(DB_WSDL_URL, getById)).getValue();
  }

  public void insertComment(Komentar comment) {
    CommentInsert request = new CommentInsert();
    request.setKomentar(comment);
    request.setTeamId(TEAM_ID);
    request.setTeamPassword(TEAM_PASSWORD);
    commentRequest(request, CommentInsertResponse.class);
  }

  public void updateComment(Komentar comment, int entityId){
    CommentUpdate request = new CommentUpdate();
    request.setEntityId(entityId);
    request.setKomentar(comment);
    request.setTeamId(TEAM_ID);
    request.setTeamPassword(TEAM_PASSWORD);
    commentRequest(request, CommentUpdateResponse.class);
  }

  public Comment getCommentById(int commentId) {
    CommentGetAllResponse comments = commentRequest(new CommentGetAll(), CommentGetAllResponse.class);
     Comment out = null;
    for (Comment e : comments.getKomentars().getKomentar()) {
      if (e.getId() == commentId) out = e;
    }
    return out;
  }

  public InsertResponse insertUser(User user) {
    Insert insert = new Insert();
    insert.setTeamId("115");
    insert.setTeamPassword("ZF4XPV");
    insert.setUser(user);

    return ((JAXBElement<InsertResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", insert)).getValue();
  }

  public UpdateResponse recoverPassword(User user) {
    Update update = new Update();
    update.setTeamId(TEAM_ID);
    update.setTeamPassword(TEAM_PASSWORD);
    update.setEntityId(user.getId());
    update.setUser(user);

    return ((JAXBElement<UpdateResponse>) getWebServiceTemplate().marshalSendAndReceive(DB_WSDL_URL, update)).getValue();
  }

  public NotifyResponse sendPasswordRecoveryNotify(Users u) {
    Notify notify = new Notify();
    notify.setTeamId(TEAM_ID);
    notify.setPassword(TEAM_PASSWORD);
    notify.setSubject("[ISK] Žiadosť o zmenu hesla");
    notify.setMessage("localhost:8080/createNewPassword?user_id=" + Integer.toString(u.getId()));
    notify.setEmail(u.getEmail());

    return ((JAXBElement<NotifyResponse>) getWebServiceTemplate().marshalSendAndReceive(EMAIL_WSDL_URL, notify)).getValue();
  }

  public NotifyResponse sendCommentDeleteNotify(User u, Comment comment, String adminResponse) {
    Notify notify = new Notify();
    notify.setTeamId(TEAM_ID);
    notify.setPassword(TEAM_PASSWORD);
    notify.setSubject("[ISK] Vas komentar bol vymazany");
    notify.setMessage("Vas komentar " + comment.getText() + " bol vymazany administratorom z dovodu :\n" + adminResponse);
    notify.setEmail(u.getEmail());

    return ((JAXBElement<NotifyResponse>) getWebServiceTemplate().marshalSendAndReceive(EMAIL_WSDL_URL, notify)).getValue();
  }

  public NotifyResponse sendCommentAcceptNotify(User u, Comment comment) {
    Notify notify = new Notify();
    notify.setTeamId(TEAM_ID);
    notify.setPassword(TEAM_PASSWORD);
    notify.setSubject("[ISK] Vas komentar bol schvaleny");
    notify.setMessage("Vas komentar " + comment.getText() + " bol schvaleny administratorom");
    notify.setEmail(u.getEmail());

    return ((JAXBElement<NotifyResponse>) getWebServiceTemplate().marshalSendAndReceive(EMAIL_WSDL_URL, notify)).getValue();
  }

  public NotifyResponse sendSignupMessage(User user) {
    Notify notify = new Notify();
    notify.setTeamId("115");
    notify.setPassword("ZF4XPV");
    notify.setEmail(user.getEmail());
    notify.setSubject("[ISK] Registrácia prebehla úspešne");
    notify.setMessage("Používateľ " + user.getName() + " bol uspesne zaregistrovany");


    return ((JAXBElement<NotifyResponse>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/NotificationServices/Email", notify)).getValue();

  }

  public ValidateEmailResponse validateEmail(String email) {
    ValidateEmail validateEmail = new ValidateEmail();
    validateEmail.setEmail(email);

    return ((JAXBElement<ValidateEmailResponse>)getWebServiceTemplate().marshalSendAndReceive(VALIDATE_WSDL_URL, validateEmail)).getValue();
  }
  
  public List<String> getAllExplicitTerms() {
    gyurix.librarysystem.services.explicit_terms.GetAll getAll = new GetAll();
    
    List<Explicittermss> terms = ((JAXBElement<gyurix.librarysystem.services.explicit_terms.GetAllResponse>)getWebServiceTemplate().marshalSendAndReceive(DB_EXPLICIT_TERMS_WSDL_URL, getAll)).getValue().getExplicittermss().getExplicitterm();
    List<String> explicitTerms = new ArrayList<>();
    for (Explicittermss t: terms) {
      explicitTerms.add(t.getName());
    }

    return explicitTerms;
  }

  public <T> T userRequest(Object request, Class<T> responseClass) {
    return ((JAXBElement<T>) getWebServiceTemplate().marshalSendAndReceive("http://pis.predmety.fiit.stuba.sk/pis/ws/Students/Team115User", request)).getValue();
  }

}
