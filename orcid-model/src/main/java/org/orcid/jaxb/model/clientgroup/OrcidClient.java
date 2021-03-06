/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.23 at 12:45:35 PM BST 
//

package org.orcid.jaxb.model.clientgroup;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.orcid.jaxb.model.message.ErrorDesc;
import org.orcid.jaxb.model.message.OrcidType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}display-name"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}website"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}short-description"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}redirect-uris"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}client-id" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}client-secret" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}error-desc"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.orcid.org/ns/orcid}client-type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "displayName", "website", "shortDescription", "idp", "redirectUris", "clientId", "clientSecret", "errors" })
@XmlRootElement(name = "orcid-client")
public class OrcidClient implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "display-name", required = true)
    protected String displayName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String website;
    @XmlElement(name = "short-description", required = true)
    protected String shortDescription;
    @XmlElement(name = "idp", required = true)
    protected String idp;
    @XmlElement(name = "redirect-uris", required = true)
    protected RedirectUris redirectUris;
    @XmlElement(name = "client-id")
    protected String clientId;
    @XmlElement(name = "client-secret")
    protected String clientSecret;
    @XmlElement(name = "error-desc", required = false)
    protected ErrorDesc errors;
    @XmlAttribute
    protected ClientType type;
    @XmlTransient
    protected boolean persistentTokenEnabled;    

    /**
     * Gets the value of the displayName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the website property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the value of the website property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setWebsite(String value) {
        this.website = value;
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Gets the value of the redirectUris property.
     * 
     * @return possible object is {@link RedirectUris }
     * 
     */
    public RedirectUris getRedirectUris() {
        return redirectUris;
    }

    /**
     * Sets the value of the redirectUris property.
     * 
     * @param value
     *            allowed object is {@link RedirectUris }
     * 
     */
    public void setRedirectUris(RedirectUris value) {
        this.redirectUris = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the clientSecret property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Sets the value of the clientSecret property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClientSecret(String value) {
        this.clientSecret = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link ClientType }
     * 
     */
    public ClientType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *            allowed object is {@link OrcidType }
     * 
     */
    public void setType(ClientType value) {
        this.type = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @param value
     *            allowed object is {@link ErrorDesc }
     * 
     */
    public ErrorDesc getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *            allowed object is {@link ErrorDesc }
     * 
     */
    public void setErrors(ErrorDesc errors) {
        this.errors = errors;
    }

    /**
     * Gets the value of the persistentTokenEnabled property.
     * 
     * @param value
     *            allowed object is {@link boolean }
     * 
     */
    public boolean isPersistentTokenEnabled() {
        return persistentTokenEnabled;
    }

    /**
     * Sets the value of the persistentTokenEnabled property.
     * 
     * @param value
     *            allowed object is {@link boolean }
     * 
     */
    public void setPersistentTokenEnabled(boolean persistentTokenEnabled) {
        this.persistentTokenEnabled = persistentTokenEnabled;
    }

    /**
     * Gets the value of the persistentTokenEnabled property.
     * 
     * @return the value of the idp
     */
    public String getIdp() {
        return idp;
    }
    
    /**
     * Sets the value of the idp property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setIdp(String idp) {
        this.idp = idp;
    }
}
