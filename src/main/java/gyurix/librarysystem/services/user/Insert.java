//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.03 at 07:46:26 PM CEST 
//


package gyurix.librarysystem.services.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insert complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="insert"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="team_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="team_password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="User" type="{http://pis.predmety.fiit.stuba.sk/pis/students/team115user/types}User"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insert", propOrder = {
        "teamId",
        "teamPassword",
        "user"
})
public class Insert {

  @XmlElement(name = "team_id", required = true)
  protected String teamId;
  @XmlElement(name = "team_password", required = true)
  protected String teamPassword;
  @XmlElement(name = "User", required = true)
  protected User user;

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

  /**
   * Gets the value of the teamPassword property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTeamPassword() {
    return teamPassword;
  }

  /**
   * Sets the value of the teamPassword property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTeamPassword(String value) {
    this.teamPassword = value;
  }

  /**
   * Gets the value of the user property.
   *
   * @return possible object is
   * {@link User }
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the value of the user property.
   *
   * @param value allowed object is
   *              {@link User }
   */
  public void setUser(User value) {
    this.user = value;
  }

}
