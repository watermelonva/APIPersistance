/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amine
 */
@Entity
@Table(name = "OAUTHACCESSTOKEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OauthAccessToken.findByAccessToken", query = "SELECT a FROM OauthAccessToken a WHERE a.accessToken = :accessToken")})
public class OauthAccessToken {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OAUTHACCESSTOKENID")
    private Integer oauthaccesstokenid;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "EXPIRES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    public Integer getOauthaccesstokenid() {
        return oauthaccesstokenid;
    }

    public void setOauthaccesstokenid(Integer oauthaccesstokenid) {
        this.oauthaccesstokenid = oauthaccesstokenid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public OauthAccessToken() {
    }

    public OauthAccessToken(String accessToken, String clientId, Date dateCreation, Date expires) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.dateCreation = dateCreation;
        this.expires = expires;
    }

}
