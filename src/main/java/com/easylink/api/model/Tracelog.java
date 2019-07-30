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
import javax.persistence.Lob;
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
 * @author user
 */
@Entity
@Table(name = "TRACELOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracelog.findAll", query = "SELECT t FROM Tracelog t"),
    @NamedQuery(name = "Tracelog.findByLogid", query = "SELECT t FROM Tracelog t WHERE t.logid = :logid"),
    @NamedQuery(name = "Tracelog.findByIp", query = "SELECT t FROM Tracelog t WHERE t.ip = :ip"),
    @NamedQuery(name = "Tracelog.findByActiondate", query = "SELECT t FROM Tracelog t WHERE t.actiondate = :actiondate"),
    @NamedQuery(name = "Tracelog.findByClient", query = "SELECT t FROM Tracelog t WHERE t.client = :client")})
public class Tracelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOGID")
    private Integer logid;
    @Size(max = 20)
    @Column(name = "IP")
    private String ip;
    @Column(name = "ACTIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actiondate;
    @Lob
    @Size(max = 65535)
    @Column(name = "ACTION")
    private String action;
    @Column(name = "CLIENT")
    private Short client;
    @JoinColumn(name = "CONVENTIONEDITED", referencedColumnName = "CONVETIONID")
    @ManyToOne
    private Convention conventionedited;
    @JoinColumn(name = "EDITEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User editedby;
    @JoinColumn(name = "OFFEREDITED", referencedColumnName = "OFFERID")
    @ManyToOne
    private Offer offeredited;
    @JoinColumn(name = "TRANSACTIONEDITED", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transactionedited;
    @JoinColumn(name = "USEREDITED", referencedColumnName = "USERID")
    @ManyToOne
    private User useredited;

    public Tracelog() {
    }

    public Tracelog(Integer logid) {
        this.logid = logid;
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getActiondate() {
        return actiondate;
    }

    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Short getClient() {
        return client;
    }

    public void setClient(Short client) {
        this.client = client;
    }

    public Convention getConventionedited() {
        return conventionedited;
    }

    public void setConventionedited(Convention conventionedited) {
        this.conventionedited = conventionedited;
    }

    public User getEditedby() {
        return editedby;
    }

    public void setEditedby(User editedby) {
        this.editedby = editedby;
    }

    public Offer getOfferedited() {
        return offeredited;
    }

    public void setOfferedited(Offer offeredited) {
        this.offeredited = offeredited;
    }

    public Transaction getTransactionedited() {
        return transactionedited;
    }

    public void setTransactionedited(Transaction transactionedited) {
        this.transactionedited = transactionedited;
    }

    public User getUseredited() {
        return useredited;
    }

    public void setUseredited(User useredited) {
        this.useredited = useredited;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logid != null ? logid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracelog)) {
            return false;
        }
        Tracelog other = (Tracelog) object;
        if ((this.logid == null && other.logid != null) || (this.logid != null && !this.logid.equals(other.logid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "a.Tracelog[ logid=" + logid + " ]";
    }
    
}
