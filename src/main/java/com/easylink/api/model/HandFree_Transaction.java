/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel TRIMECHE
 */
@Entity
@Table(name = "HANDFREE_TRANSACTION")
@XmlRootElement
public class HandFree_Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HFTID")
    private Integer hftid;
    @Column(name = "AMOUNT", scale = 3)
    private Double amount;
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transactionid;
    @JoinColumn(name = "HANDFREEID", referencedColumnName = "HANDFREEID")
    @ManyToOne
    private HandFree handfreeid;

    public Integer getHftid() {
        return hftid;
    }

    public void setHftid(Integer hftid) {
        this.hftid = hftid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transaction transactionid) {
        this.transactionid = transactionid;
    }

    public HandFree getHandfreeid() {
        return handfreeid;
    }

    public void setHandfreeid(HandFree handfreeid) {
        this.handfreeid = handfreeid;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hftid != null ? hftid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandFree_Transaction)) {
            return false;
        }
        HandFree_Transaction other = (HandFree_Transaction) object;
        if ((this.hftid == null && other.hftid != null) || (this.hftid != null && !this.hftid.equals(other.hftid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.hftid + "-" + this.hftid;
    }

}
