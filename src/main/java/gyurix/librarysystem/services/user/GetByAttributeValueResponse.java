//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.05 at 03:22:26 PM CEST 
//


package gyurix.librarysystem.services.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByAttributeValueResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getByAttributeValueResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="users" type="{http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types}ArrayOfUsers"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByAttributeValueResponse", propOrder = {
        "users"
})
public class GetByAttributeValueResponse {

  @XmlElement(required = true)
  protected ArrayOfUsers users;

  /**
   * Gets the value of the users property.
   *
   * @return possible object is
   * {@link ArrayOfUsers }
   */
  public ArrayOfUsers getUsers() {
    return users;
  }

  /**
   * Sets the value of the users property.
   *
   * @param value allowed object is
   *              {@link ArrayOfUsers }
   */
  public void setUsers(ArrayOfUsers value) {
    this.users = value;
  }

}
