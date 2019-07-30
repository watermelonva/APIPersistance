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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "VAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vat.findAll", query = "SELECT v FROM Vat v"),
    @NamedQuery(name = "Vat.findByVatid", query = "SELECT v FROM Vat v WHERE v.vatid = :vatid"),
    @NamedQuery(name = "Vat.findByVatvalue", query = "SELECT v FROM Vat v WHERE v.vatvalue = :vatvalue"),
    @NamedQuery(name = "Vat.findByName", query = "SELECT v FROM Vat v WHERE v.name = :name"),
    @NamedQuery(name = "Vat.findByIsactif", query = "SELECT v FROM Vat v WHERE v.isactif = :isactif")})
public class Vat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VATID")
    private Integer vatid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VATVALUE")
    private Float vatvalue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIF")
    private short isactif;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne
    private Account accountId;

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
    
    

    public Vat() {
    }

    public Vat(Integer vatid) {
        this.vatid = vatid;
    }

    public Vat(Integer vatid, float vatvalue, String name, short isactif) {
        this.vatid = vatid;
        this.vatvalue = vatvalue;
        this.name = name;
        this.isactif = isactif;
    }

    public Integer getVatid() {
        return vatid;
    }

    public void setVatid(Integer vatid) {
        this.vatid = vatid;
    }

    public float getVatvalue() {
        return vatvalue;
    }

    public void setVatvalue(float vatvalue) {
        this.vatvalue = vatvalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getIsactif() {
        return isactif;
    }

    public void setIsactif(short isactif) {
        this.isactif = isactif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vatid != null ? vatid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vat)) {
            return false;
        }
        Vat other = (Vat) object;
        if ((this.vatid == null && other.vatid != null) || (this.vatid != null && !this.vatid.equals(other.vatid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Vat[ vatid=" + vatid + " ]";
    }
    
}
