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
import javax.persistence.FetchType;
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
@Table(name = "CONTAIN")
@XmlRootElement


public class Contain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTAINID")
    private Integer containid;
    @Column(name = "NBRWEEKS")
    private Integer nbrweeks;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Size(max = 255)
    @Column(name = "DETAILS")
    private String details;
    @JoinColumn(name = "PHONENUMBER", referencedColumnName = "PHONENUMBERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Phonenumber phonenumber;
    @JoinColumn(name = "FAMILY", referencedColumnName = "FAMILYID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Family family;
    @JoinColumn(name = "DOCUMENT", referencedColumnName = "DOCUMENTID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Document document;
    @JoinColumn(name = "TRANSACTION", referencedColumnName = "TRANSACTIONID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Transaction transaction;
 
    

    public Contain() {
    }

    public Contain(Integer containid) {
        this.containid = containid;
    }

    public Integer getContainid() {
        return containid;
    }

    public void setContainid(Integer containid) {
        this.containid = containid;
    }

    public Phonenumber getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Phonenumber phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getNbrweeks() {
        return nbrweeks;
    }

    public void setNbrweeks(Integer nbrweeks) {
        this.nbrweeks = nbrweeks;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (containid != null ? containid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contain)) {
            return false;
        }
        Contain other = (Contain) object;
        if ((this.containid == null && other.containid != null) || (this.containid != null && !this.containid.equals(other.containid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Contain[ containid=" + containid + " ]";
    }

}
