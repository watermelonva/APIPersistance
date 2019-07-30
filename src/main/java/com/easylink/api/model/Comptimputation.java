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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "COMPTIMPUTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptimputation.findAll", query = "SELECT c FROM Comptimputation c"),
    @NamedQuery(name = "Comptimputation.findByImputationid", query = "SELECT c FROM Comptimputation c WHERE c.imputationid = :imputationid"),
    @NamedQuery(name = "Comptimputation.findByAddeddate", query = "SELECT c FROM Comptimputation c WHERE c.addeddate = :addeddate"),
    @NamedQuery(name = "Comptimputation.findByAmount", query = "SELECT c FROM Comptimputation c WHERE c.amount = :amount")})
public class Comptimputation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IMPUTATIONID")
    private Integer imputationid;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @JoinColumn(name = "PAYMENTID", referencedColumnName = "PAYMENTID")
    @ManyToOne
    private Payment paymentid;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "INVOICEID")
    @ManyToOne
    private Invoice invoiceid;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }
    
    public Comptimputation() {
    }

    public Comptimputation(Integer imputationid) {
        this.imputationid = imputationid;
    }

    public Integer getImputationid() {
        return imputationid;
    }

    public void setImputationid(Integer imputationid) {
        this.imputationid = imputationid;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Payment getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Payment paymentid) {
        this.paymentid = paymentid;
    }

    public Invoice getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Invoice invoiceid) {
        this.invoiceid = invoiceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imputationid != null ? imputationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comptimputation)) {
            return false;
        }
        Comptimputation other = (Comptimputation) object;
        if ((this.imputationid == null && other.imputationid != null) || (this.imputationid != null && !this.imputationid.equals(other.imputationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Comptimputation[ imputationid=" + imputationid + " ]";
    }
    
}
