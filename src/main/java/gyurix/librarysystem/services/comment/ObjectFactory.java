//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.16 at 07:24:31 PM CEST 
//


package gyurix.librarysystem.services.comment;

import gyurix.librarysystem.models.Comment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gyurix.librarysystem.services.comment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetById_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getById");
    private final static QName _Komentar_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "Komentar");
    private final static QName _GetByIdResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getByIdResponse");
    private final static QName _GetByAttributeValue_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getByAttributeValue");
    private final static QName _Komentars_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "Komentars");
    private final static QName _GetByAttributeValueResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getByAttributeValueResponse");
    private final static QName _GetByNumericCondition_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getByNumericCondition");
    private final static QName _GetByNumericConditionResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getByNumericConditionResponse");
    private final static QName _GetAll_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getAll");
    private final static QName _GetAllResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "getAllResponse");
    private final static QName _Insert_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "insert");
    private final static QName _InsertResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "insertResponse");
    private final static QName _Update_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "updateResponse");
    private final static QName _Delete_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "delete");
    private final static QName _DeleteResponse_QNAME = new QName("http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", "deleteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gyurix.librarysystem.services.comment
     * 
     */
    public ObjectFactory() {
    }


    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createKomentar() {
        return new Comment();
    }

     /**
     * Create an instance of {@link CommentGetAll }
     * 
     */
    public CommentGetAll createGetAll() {
        return new CommentGetAll();
    }

    /**
     * Create an instance of {@link CommentGetAllResponse }
     * 
     */
    public CommentGetAllResponse createGetAllResponse() {
        return new CommentGetAllResponse();
    }

    /**
     * Create an instance of {@link CommentInsert }
     * 
     */
    public CommentInsert createInsert() {
        return new CommentInsert();
    }

    /**
     * Create an instance of {@link CommentInsertResponse }
     * 
     */
    public CommentInsertResponse createInsertResponse() {
        return new CommentInsertResponse();
    }

    /**
     * Create an instance of {@link CommentUpdate }
     * 
     */
    public CommentUpdate createUpdate() {
        return new CommentUpdate();
    }

    /**
     * Create an instance of {@link CommentUpdateResponse }
     * 
     */
    public CommentUpdateResponse createUpdateResponse() {
        return new CommentUpdateResponse();
    }

    /**
     * Create an instance of {@link CommentDelete }
     * 
     */
    public CommentDelete createDelete() {
        return new CommentDelete();
    }

    /**
     * Create an instance of {@link CommentDeleteResponse }
     * 
     */
    public CommentDeleteResponse createDeleteResponse() {
        return new CommentDeleteResponse();
    }

    /**
     * Create an instance of {@link ArrayOfIds }
     * 
     */
    public ArrayOfIds createArrayOfIds() {
        return new ArrayOfIds();
    }

    /**
     * Create an instance of {@link ArrayOfKomentars }
     * 
     */
    public ArrayOfKomentars createArrayOfKomentars() {
        return new ArrayOfKomentars();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "Komentar")
    public JAXBElement<Comment> createKomentar(Comment value) {
        return new JAXBElement<>(_Komentar_QNAME, Comment.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "Komentars")
    public JAXBElement<Comment> createKomentars(Comment value) {
        return new JAXBElement<>(_Komentars_QNAME, Comment.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentGetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "getAll")
    public JAXBElement<CommentGetAll> createGetAll(CommentGetAll value) {
        return new JAXBElement<>(_GetAll_QNAME, CommentGetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentGetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "getAllResponse")
    public JAXBElement<CommentGetAllResponse> createGetAllResponse(CommentGetAllResponse value) {
        return new JAXBElement<>(_GetAllResponse_QNAME, CommentGetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentInsert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "insert")
    public JAXBElement<CommentInsert> createInsert(CommentInsert value) {
        return new JAXBElement<>(_Insert_QNAME, CommentInsert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "insertResponse")
    public JAXBElement<CommentInsertResponse> createInsertResponse(CommentInsertResponse value) {
        return new JAXBElement<>(_InsertResponse_QNAME, CommentInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "update")
    public JAXBElement<CommentUpdate> createUpdate(CommentUpdate value) {
        return new JAXBElement<>(_Update_QNAME, CommentUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "updateResponse")
    public JAXBElement<CommentUpdateResponse> createUpdateResponse(CommentUpdateResponse value) {
        return new JAXBElement<>(_UpdateResponse_QNAME, CommentUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "delete")
    public JAXBElement<CommentDelete> createDelete(CommentDelete value) {
        return new JAXBElement<>(_Delete_QNAME, CommentDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types", name = "deleteResponse")
    public JAXBElement<CommentDeleteResponse> createDeleteResponse(CommentDeleteResponse value) {
        return new JAXBElement<>(_DeleteResponse_QNAME, CommentDeleteResponse.class, null, value);
    }

}
