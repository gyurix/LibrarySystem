//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.16 at 09:04:51 PM CEST 
//


package gyurix.librarysystem.services.comment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByIdResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="komentar" type="{http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types}Komentar"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByIdResponse", propOrder = {
  "komentar"
})
public class CommentGetByIdResponse {

  @XmlElement(required = true)
  protected Komentar komentar;

  /**
   * Gets the value of the komentar property.
   *
   * @return possible object is
   * {@link Komentar }
   */
  public Komentar getKomentar() {
    return komentar;
  }

  /**
   * Sets the value of the komentar property.
   *
   * @param value allowed object is
   *              {@link Komentar }
   */
  public void setKomentar(Komentar value) {
    this.komentar = value;
  }

}
