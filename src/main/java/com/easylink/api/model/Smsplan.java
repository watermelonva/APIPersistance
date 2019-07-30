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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "SMSPLAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smsplan.findAll", query = "SELECT s FROM Smsplan s"),
    @NamedQuery(name = "Smsplan.findBySmsplanid", query = "SELECT s FROM Smsplan s WHERE s.smsplanid = :smsplanid"),
    @NamedQuery(name = "Smsplan.findByName", query = "SELECT s FROM Smsplan s WHERE s.name = :name"),
    @NamedQuery(name = "Smsplan.findByQuantity", query = "SELECT s FROM Smsplan s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Smsplan.findByIsfree", query = "SELECT s FROM Smsplan s WHERE s.isfree = :isfree"),
    @NamedQuery(name = "Smsplan.findByAddeddate", query = "SELECT s FROM Smsplan s WHERE s.addeddate = :addeddate"),
    @NamedQuery(name = "Smsplan.findByIsdeleted", query = "SELECT s FROM Smsplan s WHERE s.isdeleted = :isdeleted"),
    @NamedQuery(name = "Smsplan.findByDeleteddate", query = "SELECT s FROM Smsplan s WHERE s.deleteddate = :deleteddate")})
public class Smsplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SMSPLANID")
    private Integer smsplanid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISFREE")
    private Short isfree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;
    @Column(name = "REST")
    private int rest;

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }
    
    

    public Smsplan() {
    }

    public Smsplan(Integer smsplanid) {
        this.smsplanid = smsplanid;
    }

    public Smsplan(Integer smsplanid, String name, int quantity, short isfree, Date addeddate, short isdeleted) {
        this.smsplanid = smsplanid;
        this.name = name;
        this.quantity = quantity;
        this.isfree = isfree;
        this.addeddate = addeddate;
        this.isdeleted = isdeleted;
    }

    public Integer getSmsplanid() {
        return smsplanid;
    }

    public void setSmsplanid(Integer smsplanid) {
        this.smsplanid = smsplanid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public short getIsfree() {
        return isfree;
    }

    public void setIsfree(short isfree) {
        this.isfree = isfree;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
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
        hash += (smsplanid != null ? smsplanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smsplan)) {
            return false;
        }
        Smsplan other = (Smsplan) object;
        if ((this.smsplanid == null && other.smsplanid != null) || (this.smsplanid != null && !this.smsplanid.equals(other.smsplanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Smsplan[ smsplanid=" + smsplanid + " ]";
    }
    
}
