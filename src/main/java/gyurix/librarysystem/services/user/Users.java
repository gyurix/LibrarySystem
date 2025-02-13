//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.05 at 03:22:26 PM CEST 
//


package gyurix.librarysystem.services.user;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Users complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Users"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passwordHash" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
  "id",
  "name",
  "email",
  "passwordHash",
  "type"
})
@ToString
public class Users {

  @XmlElement(required = true)
  protected String email;
  protected int id;
  @XmlElement(required = true)
  protected String name;
  @XmlElement(required = true)
  protected String passwordHash;
  protected int type;

  /**
   * Gets the value of the email property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the value of the email property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setEmail(String value) {
    this.email = value;
  }

  /**
   * Gets the value of the id property.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the passwordHash property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPasswordHash() {
    return passwordHash;
  }

  /**
   * Sets the value of the passwordHash property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPasswordHash(String value) {
    this.passwordHash = value;
  }

  /**
   * Gets the value of the type property.
   */
  public int getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   */
  public void setType(int value) {
    this.type = value;
  }

}
