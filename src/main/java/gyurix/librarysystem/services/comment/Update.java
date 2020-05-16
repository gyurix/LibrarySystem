//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.16 at 07:24:31 PM CEST 
//


package gyurix.librarysystem.services.comment;

import gyurix.librarysystem.models.Comment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for update complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="update"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="team_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="team_password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="entity_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Komentar" type="{http://pis.predmety.fiit.stuba.sk/pis/students/team115komentar/types}Komentar"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", propOrder = {
    "teamId",
    "teamPassword",
    "entityId",
    "komentar"
})
public class Update {

    @XmlElement(name = "team_id", required = true)
    protected String teamId;
    @XmlElement(name = "team_password", required = true)
    protected String teamPassword;
    @XmlElement(name = "entity_id")
    protected int entityId;
    @XmlElement(name = "Komentar", required = true)
    protected Comment komentar;

    /**
     * Gets the value of the teamId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * Sets the value of the teamId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamId(String value) {
        this.teamId = value;
    }

    /**
     * Gets the value of the teamPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamPassword() {
        return teamPassword;
    }

    /**
     * Sets the value of the teamPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamPassword(String value) {
        this.teamPassword = value;
    }

    /**
     * Gets the value of the entityId property.
     * 
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     */
    public void setEntityId(int value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the komentar property.
     * 
     * @return
     *     possible object is
     *     {@link Comment }
     *     
     */
    public Comment getKomentar() {
        return komentar;
    }

    /**
     * Sets the value of the komentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comment }
     *     
     */
    public void setKomentar(Comment value) {
        this.komentar = value;
    }

}
