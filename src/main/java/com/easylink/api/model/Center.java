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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "CENTER")
@XmlRootElement

public class Center implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CENTERID")
    private Integer centerid;
    @Size(max = 10)
    @Column(name = "Code")
    private String code;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "NAMEAR")
    private String namear;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 255)
    @Column(name = "GPSLOCATION")
    private String gpslocation;
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Column(name = "FAX")
    private String fax;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User deletedby;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "BYVALIDATION")
    private Short byvalidation;

    public Short getByvalidation() {
        return byvalidation;
    }

    public void setByvalidation(Short byvalidation) {
        this.byvalidation = byvalidation;
    }   

    @JoinColumn(name = "REGION", referencedColumnName = "REGIONID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Region region;
    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    @OneToMany(mappedBy = "ncenter", fetch = FetchType.LAZY)
    private Collection<Notification> notificationCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;
    @OneToMany(mappedBy = "centerid", fetch = FetchType.LAZY)
    private Collection<Stock> stockCollection;
    @JoinColumn(name = "CATEGORYAMICALEID", referencedColumnName = "CATEGORYAMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private CategoryAmicale categoryamicaleid;

    public CategoryAmicale getCategoryamicaleid() {
        return categoryamicaleid;
    }

    public void setCategoryamicaleid(CategoryAmicale categoryamicaleid) {
        this.categoryamicaleid = categoryamicaleid;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Center() {
    }

    public Center(Integer centerid) {
        this.centerid = centerid;
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

    public Integer getCenterid() {
        return centerid;
    }

    public void setCenterid(Integer centerid) {
        this.centerid = centerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNamear() {
        return namear;
    }

    public void setNamear(String namear) {
        this.namear = namear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpslocation() {
        return gpslocation;
    }

    public void setGpslocation(String gpslocation) {
        this.gpslocation = gpslocation;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centerid != null ? centerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Center)) {
            return false;
        }
        Center other = (Center) object;
        if ((this.centerid == null && other.centerid != null) || (this.centerid != null && !this.centerid.equals(other.centerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

}
