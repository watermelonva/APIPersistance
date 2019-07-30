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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adeveganet
 */
@Entity
@Table(name = "AGENCY")
@XmlRootElement
public class Agency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGENCYID")
    private Integer agencyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IPADRESS")
    private String ipadress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Column(name = "ADRESS")
    private String adress;
    @Size(max = 20)
    @Column(name = "CITY")
    private String city;
    @Size(max = 10)
    @Column(name = "POSTALCODE")
    private String postalcode;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "agencyid", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
    private Collection<Agencyamicale> agencyamicaleCollectio;

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<Agencyamicale> getAgencyamicaleCollectio() {
        return agencyamicaleCollectio;
    }

    public void setAgencyamicaleCollectio(Collection<Agencyamicale> agencyamicaleCollectio) {
        this.agencyamicaleCollectio = agencyamicaleCollectio;
    }

    public Agency() {
    }

    public Agency(Integer agencyid) {
        this.agencyid = agencyid;
    }

    public Agency(Integer agencyid, String ipadress, String name) {
        this.agencyid = agencyid;
        this.ipadress = ipadress;
        this.name = name;
    }

    public Integer getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(Integer agencyid) {
        this.agencyid = agencyid;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agencyid != null ? agencyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agency)) {
            return false;
        }
        Agency other = (Agency) object;
        if ((this.agencyid == null && other.agencyid != null) || (this.agencyid != null && !this.agencyid.equals(other.agencyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+this.name;
    }

}
