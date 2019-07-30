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
@Table(name = "FAMILY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f"),
    @NamedQuery(name = "Family.findByFamilyid", query = "SELECT f FROM Family f WHERE f.familyid = :familyid"),
    @NamedQuery(name = "Family.findByFirstname", query = "SELECT f FROM Family f WHERE f.firstname = :firstname"),
    @NamedQuery(name = "Family.findByLastname", query = "SELECT f FROM Family f WHERE f.lastname = :lastname"),
    @NamedQuery(name = "Family.findByBirthdate", query = "SELECT f FROM Family f WHERE f.birthdate = :birthdate"),
    @NamedQuery(name = "Family.findBySchoollevel", query = "SELECT f FROM Family f WHERE f.schoollevel = :schoollevel")})
public class Family implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FAMILYID")
    private Integer familyid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 50)
    @Column(name = "FIRSTNAMEAR")
    private String firstnamear;
    @Size(max = 50)
    @Column(name = "LASTNAMEAR")
    private String lastnamear;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 255)
    @Column(name = "BIRTHCERTIFICAT")
    private String birthcertificat;
    @Size(max = 50)
    @Column(name = "SCHOOLLEVEL")
    private String schoollevel;
    @Size(max = 50)
    @Column(name = "FAMILYRELATIONSHIP")
    private String familyrelationship;
    @Size(max = 100)
    @Column(name = "OTHERRELATIONSHIP")
    private String otherrelationship;
    @Column(name = "GENDER")
    private Short gender;
    @Column(name = "ISDELETED")
    private short isdeleted;
    @Column(name = "ISACTIVE")
    private short isactive;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.DATE)
    private Date deleteddate;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;

    @OneToMany(mappedBy = "family")
    private Collection<Contain> containCollection;
    @JoinColumn(name = "PARENT", referencedColumnName = "USERID")
    @ManyToOne
    private User parent;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public short getIsactive() {
        return isactive;
    }

    public void setIsactive(short isactive) {
        this.isactive = isactive;
    }

    public String getFamilyrelationship() {
        return familyrelationship;
    }

    public void setFamilyrelationship(String familyrelationship) {
        this.familyrelationship = familyrelationship;
    }

    public Family() {
    }

    public Family(Integer familyid) {
        this.familyid = familyid;
    }

    public Integer getFamilyid() {
        return familyid;
    }

    public void setFamilyid(Integer familyid) {
        this.familyid = familyid;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    public String getOtherrelationship() {
        return otherrelationship;
    }

    public void setOtherrelationship(String otherrelationship) {
        this.otherrelationship = otherrelationship;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
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

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getFirstnamear() {
        return firstnamear;
    }

    public void setFirstnamear(String firstnamear) {
        this.firstnamear = firstnamear;
    }

    public String getLastnamear() {
        return lastnamear;
    }

    public void setLastnamear(String lastnamear) {
        this.lastnamear = lastnamear;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthcertificat() {
        return birthcertificat;
    }

    public void setBirthcertificat(String birthcertificat) {
        this.birthcertificat = birthcertificat;
    }

    public String getSchoollevel() {
        return schoollevel;
    }

    public void setSchoollevel(String schoollevel) {
        this.schoollevel = schoollevel;
    }

    @XmlTransient
    public Collection<Contain> getContainCollection() {
        return containCollection;
    }

    public void setContainCollection(Collection<Contain> containCollection) {
        this.containCollection = containCollection;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyid != null ? familyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.familyid == null && other.familyid != null) || (this.familyid != null && !this.familyid.equals(other.familyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

}
