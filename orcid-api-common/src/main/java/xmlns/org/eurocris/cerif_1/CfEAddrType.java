//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.26 at 11:29:18 AM GMT 
//


package xmlns.org.eurocris.cerif_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for cfEAddr__Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cfEAddr__Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cfEAddrId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type"/>
 *         &lt;element name="cfPAddrId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type" minOccurs="0"/>
 *         &lt;element name="cfURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="cfOrgUnit_EAddr">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="cfOrgUnitId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type"/>
 *                     &lt;group ref="{urn:xmlns:org:eurocris:cerif-1.6-2}cfCoreClassWithFraction__Group"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="cfPers_EAddr">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="cfPersId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type"/>
 *                     &lt;group ref="{urn:xmlns:org:eurocris:cerif-1.6-2}cfCoreClassWithFraction__Group"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="cfEAddr_Class" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfCoreClassWithFraction__Type"/>
 *           &lt;element name="cfFedId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfFedId__EmbType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cfEAddr__Type", propOrder = {
    "cfEAddrId",
    "cfPAddrId",
    "cfURI",
    "cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass"
})
public class CfEAddrType {

    @XmlElement(required = true)
    protected String cfEAddrId;
    protected String cfPAddrId;
    protected String cfURI;
    @XmlElements({
        @XmlElement(name = "cfOrgUnit_EAddr", type = CfEAddrType.CfOrgUnitEAddr.class),
        @XmlElement(name = "cfPers_EAddr", type = CfEAddrType.CfPersEAddr.class),
        @XmlElement(name = "cfEAddr_Class", type = CfCoreClassWithFractionType.class),
        @XmlElement(name = "cfFedId", type = CfFedIdEmbType.class)
    })
    protected List<Object> cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass;

    /**
     * Gets the value of the cfEAddrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfEAddrId() {
        return cfEAddrId;
    }

    /**
     * Sets the value of the cfEAddrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfEAddrId(String value) {
        this.cfEAddrId = value;
    }

    /**
     * Gets the value of the cfPAddrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfPAddrId() {
        return cfPAddrId;
    }

    /**
     * Sets the value of the cfPAddrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfPAddrId(String value) {
        this.cfPAddrId = value;
    }

    /**
     * Gets the value of the cfURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfURI() {
        return cfURI;
    }

    /**
     * Sets the value of the cfURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfURI(String value) {
        this.cfURI = value;
    }

    /**
     * Gets the value of the cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CfEAddrType.CfOrgUnitEAddr }
     * {@link CfEAddrType.CfPersEAddr }
     * {@link CfCoreClassWithFractionType }
     * {@link CfFedIdEmbType }
     * 
     * 
     */
    public List<Object> getCfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass() {
        if (cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass == null) {
            cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass = new ArrayList<Object>();
        }
        return this.cfOrgUnitEAddrOrCfPersEAddrOrCfEAddrClass;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cfOrgUnitId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type"/>
     *         &lt;group ref="{urn:xmlns:org:eurocris:cerif-1.6-2}cfCoreClassWithFraction__Group"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cfOrgUnitId",
        "cfClassId",
        "cfClassSchemeId",
        "cfStartDate",
        "cfEndDate",
        "cfFraction"
    })
    public static class CfOrgUnitEAddr {

        @XmlElement(required = true)
        protected String cfOrgUnitId;
        @XmlElement(required = true)
        protected String cfClassId;
        @XmlElement(required = true)
        protected String cfClassSchemeId;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar cfStartDate;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar cfEndDate;
        protected Float cfFraction;

        /**
         * Gets the value of the cfOrgUnitId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfOrgUnitId() {
            return cfOrgUnitId;
        }

        /**
         * Sets the value of the cfOrgUnitId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfOrgUnitId(String value) {
            this.cfOrgUnitId = value;
        }

        /**
         * Gets the value of the cfClassId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfClassId() {
            return cfClassId;
        }

        /**
         * Sets the value of the cfClassId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfClassId(String value) {
            this.cfClassId = value;
        }

        /**
         * Gets the value of the cfClassSchemeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfClassSchemeId() {
            return cfClassSchemeId;
        }

        /**
         * Sets the value of the cfClassSchemeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfClassSchemeId(String value) {
            this.cfClassSchemeId = value;
        }

        /**
         * Gets the value of the cfStartDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCfStartDate() {
            return cfStartDate;
        }

        /**
         * Sets the value of the cfStartDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCfStartDate(XMLGregorianCalendar value) {
            this.cfStartDate = value;
        }

        /**
         * Gets the value of the cfEndDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCfEndDate() {
            return cfEndDate;
        }

        /**
         * Sets the value of the cfEndDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCfEndDate(XMLGregorianCalendar value) {
            this.cfEndDate = value;
        }

        /**
         * Gets the value of the cfFraction property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getCfFraction() {
            return cfFraction;
        }

        /**
         * Sets the value of the cfFraction property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setCfFraction(Float value) {
            this.cfFraction = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cfPersId" type="{urn:xmlns:org:eurocris:cerif-1.6-2}cfId__Type"/>
     *         &lt;group ref="{urn:xmlns:org:eurocris:cerif-1.6-2}cfCoreClassWithFraction__Group"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cfPersId",
        "cfClassId",
        "cfClassSchemeId",
        "cfStartDate",
        "cfEndDate",
        "cfFraction"
    })
    public static class CfPersEAddr {

        @XmlElement(required = true)
        protected String cfPersId;
        @XmlElement(required = true)
        protected String cfClassId;
        @XmlElement(required = true)
        protected String cfClassSchemeId;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar cfStartDate;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar cfEndDate;
        protected Float cfFraction;

        /**
         * Gets the value of the cfPersId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfPersId() {
            return cfPersId;
        }

        /**
         * Sets the value of the cfPersId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfPersId(String value) {
            this.cfPersId = value;
        }

        /**
         * Gets the value of the cfClassId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfClassId() {
            return cfClassId;
        }

        /**
         * Sets the value of the cfClassId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfClassId(String value) {
            this.cfClassId = value;
        }

        /**
         * Gets the value of the cfClassSchemeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCfClassSchemeId() {
            return cfClassSchemeId;
        }

        /**
         * Sets the value of the cfClassSchemeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCfClassSchemeId(String value) {
            this.cfClassSchemeId = value;
        }

        /**
         * Gets the value of the cfStartDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCfStartDate() {
            return cfStartDate;
        }

        /**
         * Sets the value of the cfStartDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCfStartDate(XMLGregorianCalendar value) {
            this.cfStartDate = value;
        }

        /**
         * Gets the value of the cfEndDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCfEndDate() {
            return cfEndDate;
        }

        /**
         * Sets the value of the cfEndDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCfEndDate(XMLGregorianCalendar value) {
            this.cfEndDate = value;
        }

        /**
         * Gets the value of the cfFraction property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getCfFraction() {
            return cfFraction;
        }

        /**
         * Sets the value of the cfFraction property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setCfFraction(Float value) {
            this.cfFraction = value;
        }

    }

}
