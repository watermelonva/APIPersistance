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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "PROVIDER")
@XmlRootElement


public class Provider implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "WITHREFUND")
    private Short withrefund;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @OneToMany(mappedBy = "providerid", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "PROVIDERROOTID", referencedColumnName = "PROVIDERROOTID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProviderRoot providerrootid;
    @OneToMany(mappedBy = "providerid", fetch = FetchType.LAZY)
    private Collection<Invoice> invoiceCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROVIDERID")
    private Integer providerid;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 255)
    @Column(name = "LOGO")
    private String logo;
    @Size(max = 255)
    @Column(name = "GPSLOCATION")
    private String gpslocation;
    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private Collection<Event> eventCollection;
    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private Collection<Convention> conventionCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;
    @Size(max = 50)
    @Column(name = "RCS")
    private String rcs;
    @Size(max = 50)
    @Column(name = "MF")
    private String mf;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 50)
    @Column(name = "JOB")
    private String job;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 11)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 11)
    @Column(name = "CALCUL")
    private String calcul;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User deletedby;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @JoinColumn(name = "SECTORID", referencedColumnName = "SECTORID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Sector sectorid;
    @Column(name = "STARTINGFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingfrom;
    @Size(max = 20)
    @Column(name = "CUSTCODE")
    private String cuscode;
 

    public String getCuscode() {
        return cuscode;
    }

    public void setCuscode(String cuscode) {
        this.cuscode = cuscode;
    }

    public Date getStartingfrom() {
        return startingfrom;
    }

    public void setStartingfrom(Date startingfrom) {
        this.startingfrom = startingfrom;
    }

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }

    public Sector getSectorid() {
        return sectorid;
    }

    public void setSectorid(Sector sectorid) {
        this.sectorid = sectorid;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public String getRcs() {
        return rcs;
    }

    public void setRcs(String rcs) {
        this.rcs = rcs;
    }

    public String getMf() {
        return mf;
    }

    public void setMf(String mf) {
        this.mf = mf;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdby;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Provider() {
    }

    public Provider(Integer providerid) {
        this.providerid = providerid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGpslocation() {
        return gpslocation;
    }

    public void setGpslocation(String gpslocation) {
        this.gpslocation = gpslocation;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<Convention> getConventionCollection() {
        return conventionCollection;
    }

    public void setConventionCollection(Collection<Convention> conventionCollection) {
        this.conventionCollection = conventionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerid != null ? providerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.providerid == null && other.providerid != null) || (this.providerid != null && !this.providerid.equals(other.providerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public short getWithrefund() {
        return withrefund;
    }

    public void setWithrefund(short withrefund) {
        this.withrefund = withrefund;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public ProviderRoot getProviderrootid() {
        return providerrootid;
    }

    public void setProviderrootid(ProviderRoot providerrootid) {
        this.providerrootid = providerrootid;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

}
