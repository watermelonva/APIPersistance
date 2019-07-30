/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PHONENUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phonenumber.findAll", query = "SELECT p FROM Phonenumber p"),
    @NamedQuery(name = "Phonenumber.findByPhonenumberid", query = "SELECT p FROM Phonenumber p WHERE p.phonenumberid = :phonenumberid"),
    @NamedQuery(name = "Phonenumber.findByPhone", query = "SELECT p FROM Phonenumber p WHERE p.phone = :phone")})
public class Phonenumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PHONENUMBERID")
    private Integer phonenumberid;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 50)
    @Column(name = "PHONENAME")
    private String phoneName;
    @OneToMany(mappedBy = "phonenumber")
    private Collection<Contain> containCollection;

    public Phonenumber() {
    }

    public Phonenumber(String phone, String phoneName) {
        this.phone = phone;
        this.phoneName = phoneName;
    }

    
    public Phonenumber(Integer phonenumberid) {
        this.phonenumberid = phonenumberid;
    }

    public Integer getPhonenumberid() {
        return phonenumberid;
    }

    public void setPhonenumberid(Integer phonenumberid) {
        this.phonenumberid = phonenumberid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    @XmlTransient
    public Collection<Contain> getContainCollection() {
        return containCollection;
    }

    public void setContainCollection(Collection<Contain> containCollection) {
        this.containCollection = containCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phonenumberid != null ? phonenumberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phonenumber)) {
            return false;
        }
        Phonenumber other = (Phonenumber) object;
        if ((this.phonenumberid == null && other.phonenumberid != null) || (this.phonenumberid != null && !this.phonenumberid.equals(other.phonenumberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Phonenumber[ phonenumberid=" + phonenumberid + " ]";
    }

}
