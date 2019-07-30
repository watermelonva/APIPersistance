/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "PROVIDER_ROOT")
@XmlRootElement

public class ProviderRoot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROVIDERROOTID")
    private Integer providerrootid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerrootid", fetch = FetchType.LAZY)
    private Collection<Provider> providerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerrootid", fetch = FetchType.LAZY)
    private Collection<Bill> billCollection;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "LOGO")
    private String logo;
    @Size(max = 150)
    @Basic(optional = false)
    @Column(name = "RS")
    private String rs;
    @Size(max = 20)
    @Basic(optional = false)
    @Column(name = "VATCODE")
    private String vatcode;
    @Size(max = 20)
    @Column(name = "RCS")
    private String rcs;
    @Size(max = 255)
    @Column(name = "BILLINGADDRESS")
    private String billingaddress;
    @Column(name = "ISDELETED")
    private Byte isdeleted;
    
    public byte getIsDeleted() {
        return isdeleted;
    }

    public void setIsDeleted(byte isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getVatcode() {
        return vatcode;
    }

    public void setVatcode(String vatcode) {
        this.vatcode = vatcode;
    }

    public String getRcs() {
        return rcs;
    }

    public void setRcs(String rcs) {
        this.rcs = rcs;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ProviderRoot() {
    }

    public ProviderRoot(Integer providerrootid) {
        this.providerrootid = providerrootid;
    }

    public Integer getProviderrootid() {
        return providerrootid;
    }

    public void setProviderrootid(Integer providerrootid) {
        this.providerrootid = providerrootid;
    }

    @XmlTransient
    public Collection<Provider> getProviderCollection() {
        return providerCollection;
    }

    public void setProviderCollection(Collection<Provider> providerCollection) {
        this.providerCollection = providerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerrootid != null ? providerrootid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProviderRoot)) {
            return false;
        }
        ProviderRoot other = (ProviderRoot) object;
        if ((this.providerrootid == null && other.providerrootid != null) || (this.providerrootid != null && !this.providerrootid.equals(other.providerrootid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.easylink.entities2.ProviderRoot[ providerrootid=" + providerrootid + " ]";
    }

}
