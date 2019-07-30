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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "REFUND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refund.findAll", query = "SELECT r FROM Refund r"),
    @NamedQuery(name = "Refund.findByRefundid", query = "SELECT r FROM Refund r WHERE r.refundid = :refundid"),
    @NamedQuery(name = "Refund.findByMin", query = "SELECT r FROM Refund r WHERE r.min = :min"),
    @NamedQuery(name = "Refund.findByMax", query = "SELECT r FROM Refund r WHERE r.max = :max"),
    @NamedQuery(name = "Refund.findByValue", query = "SELECT r FROM Refund r WHERE r.value = :value"),
    @NamedQuery(name = "Refund.findByAddeddate", query = "SELECT r FROM Refund r WHERE r.addeddate = :addeddate"),
    @NamedQuery(name = "Refund.findByIsdeleted", query = "SELECT r FROM Refund r WHERE r.isdeleted = :isdeleted"),
    @NamedQuery(name = "Refund.findByDeleteddate", query = "SELECT r FROM Refund r WHERE r.deleteddate = :deleteddate")})
public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REFUNDID")
    private Integer refundid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MIN")
    private Double min;
    @Column(name = "MAX")
    private Double max;
    @Column(name = "VALUE")
    private Float value;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;
    @JoinColumn(name = "PROVIDERID", referencedColumnName = "PROVIDERID")
    @ManyToOne
    private Provider providerid;
    @Transient
    private Boolean infinite;

    public boolean isInfinite() {
        return infinite;
    }

    public void setInfinite(boolean infinite) {
        this.infinite = infinite;
    }
    
    

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }
    
    

    public Refund() {
    }

    public Refund(Integer refundid) {
        this.refundid = refundid;
    }

    public Integer getRefundid() {
        return refundid;
    }

    public void setRefundid(Integer refundid) {
        this.refundid = refundid;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refundid != null ? refundid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refund)) {
            return false;
        }
        Refund other = (Refund) object;
        if ((this.refundid == null && other.refundid != null) || (this.refundid != null && !this.refundid.equals(other.refundid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Refund[ refundid=" + refundid + " ]";
    }
    
}
