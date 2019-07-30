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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel TRIMECHE
 */
@Entity
@Table(name = "HAND_FREE")
@XmlRootElement
public class HandFree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HANDFREEID")
    private Integer handfreeid;
    @Column(name = "AMOUNT" , scale = 3)
    private Double amount;
    @Column(name = "DRAFT")
    private Short draft;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Size(max = 255)
    @Column(name = "DOC")
    private String docpath;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @JoinColumn(name = "ADHERENTID", referencedColumnName = "USERID")
    @ManyToOne
    private User adherentid;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    

    public Integer getHandfreeid() {
        return handfreeid;
    }

    public void setHandfreeid(Integer handfreeid) {
        this.handfreeid = handfreeid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Short getDraft() {
        return draft;
    }

    public void setDraft(Short draft) {
        this.draft = draft;
    }

    public String getDocpath() {
        return docpath;
    }

    public void setDocpath(String docpath) {
        this.docpath = docpath;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public User getAdherentid() {
        return adherentid;
    }

    public void setAdherentid(User adherentid) {
        this.adherentid = adherentid;
    }

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }
    
    
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (handfreeid != null ? handfreeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandFree)) {
            return false;
        }
        HandFree other = (HandFree) object;
        if ((this.handfreeid == null && other.handfreeid != null) || (this.handfreeid != null && !this.handfreeid.equals(other.handfreeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.handfreeid+"-"+this.handfreeid;
    }

}
