//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.12 at 03:22:28 PM CEST 
//


package gyurix.librarysystem.services.email;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for notify complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="notify"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="team_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notify", propOrder = {
  "teamId",
  "password",
  "email",
  "subject",
  "message"
})
@XmlRootElement(name = "notify")
public class Notify {

  @XmlElement(required = true)
  protected String email;
  @XmlElement(required = true)
  protected String message;
  @XmlElement(required = true)
  protected String password;
  @XmlElement(required = true)
  protected String subject;
  @XmlElement(name = "team_id", required = true)
  protected String teamId;

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
   * Gets the value of the message property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the value of the message property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setMessage(String value) {
    this.message = value;
  }

  /**
   * Gets the value of the password property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the value of the password property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPassword(String value) {
    this.password = value;
  }

  /**
   * Gets the value of the subject property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the value of the subject property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setSubject(String value) {
    this.subject = value;
  }

  /**
   * Gets the value of the teamId property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTeamId() {
    return teamId;
  }

  /**
   * Sets the value of the teamId property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTeamId(String value) {
    this.teamId = value;
  }

}
