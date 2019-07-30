/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "SUBSCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findBySubscriptionid", query = "SELECT s FROM Subscription s WHERE s.subscriptionid = :subscriptionid"),
    @NamedQuery(name = "Subscription.findByTwoParam", query = "SELECT s FROM Subscription s WHERE s.type = :type AND s.user = :user AND s.amicaleid = :amicale"),
    @NamedQuery(name = "Subscription.findByDatesubscription", query = "SELECT s FROM Subscription s WHERE s.datesubscription = :datesubscription")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SUBSCRIPTIONID")
    private Integer subscriptionid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    //type 0:cash payment
    // type 1:tranche payment
    @Column(name = "TYPE")
    private Short type;
    @Column(name = "DATESUBSCRIPTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesubscription;
    @Size(max = 255)
    @Column(name = "NOTSIGNPDF")
    private String notsignpdf;
    @Size(max = 255)
    @Column(name = "SIGNPDF")
    private String signpdf;
    @JoinColumn(name = "USER", referencedColumnName = "USERID")
    @ManyToOne
    private User user;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public String getNotsignpdf() {
        return notsignpdf;
    }

    public void setNotsignpdf(String notsignpdf) {
        this.notsignpdf = notsignpdf;
    }

    public String getSignpdf() {
        return signpdf;
    }

    public void setSignpdf(String signpdf) {
        this.signpdf = signpdf;
    }

    public Subscription() {
    }

    public Subscription(Integer subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public Integer getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(Integer subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getDatesubscription() {
        return datesubscription;
    }

    public void setDatesubscription(Date datesubscription) {
        this.datesubscription = datesubscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionid != null ? subscriptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionid == null && other.subscriptionid != null) || (this.subscriptionid != null && !this.subscriptionid.equals(other.subscriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Subscription[ subscriptionid=" + subscriptionid + " ]";
    }

}
