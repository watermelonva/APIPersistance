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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amine
 */
@Entity
@Table(name = "PREVIOUSUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Previoususer.findAll", query = "SELECT p FROM Previoususer p"),
    @NamedQuery(name = "Previoususer.findByPrevioususerid", query = "SELECT p FROM Previoususer p WHERE p.previoususerid = :previoususerid AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByCin", query = "SELECT p FROM Previoususer p WHERE p.cin = :cin  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByCnrps", query = "SELECT p FROM Previoususer p WHERE p.cnrps = :cnrps  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByPhone", query = "SELECT p FROM Previoususer p WHERE p.phone = :phone  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByBirthday", query = "SELECT p FROM Previoususer p WHERE p.birthday = :birthday  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByThreshold", query = "SELECT p FROM Previoususer p WHERE p.threshold = :threshold  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByFirstname", query = "SELECT p FROM Previoususer p WHERE p.firstname = :firstname  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByFirstnamear", query = "SELECT p FROM Previoususer p WHERE p.firstnamear = :firstnamear  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByLastname", query = "SELECT p FROM Previoususer p WHERE p.lastname = :lastname  AND p.amicaleid = :amicale"),
    @NamedQuery(name = "Previoususer.findByLastnamear", query = "SELECT p FROM Previoususer p WHERE p.lastnamear = :lastnamear  AND p.amicaleid = :amicale")})
public class Previoususer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PREVIOUSUSERID")
    private Integer previoususerid;
    @Size(max = 8)
    @Column(name = "CIN")
    private String cin;
    @Size(max = 10)
    @Column(name = "CNRPS")
    private String cnrps;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "THRESHOLD")
    private Double threshold;
    @Size(max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 20)
    @Column(name = "FIRSTNAMEAR")
    private String firstnamear;
    @Size(max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 20)
    @Column(name = "LASTNAMEAR")
    private String lastnamear;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "CATEGORYAMICALE", referencedColumnName = "CATEGORYAMICALEID")
    @ManyToOne
    private CategoryAmicale categoryamicaleid;

    public CategoryAmicale getCategoryamicale() {
        return categoryamicaleid;
    }

    public void setCategoryamicale(CategoryAmicale categoryamicale) {
        this.categoryamicaleid = categoryamicale;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Previoususer() {
    }

    public Previoususer(Integer previoususerid) {
        this.previoususerid = previoususerid;
    }

    public Integer getPrevioususerid() {
        return previoususerid;
    }

    public void setPrevioususerid(Integer previoususerid) {
        this.previoususerid = previoususerid;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCnrps() {
        return cnrps;
    }

    public void setCnrps(String cnrps) {
        this.cnrps = cnrps;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstnamear() {
        return firstnamear;
    }

    public void setFirstnamear(String firstnamear) {
        this.firstnamear = firstnamear;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastnamear() {
        return lastnamear;
    }

    public void setLastnamear(String lastnamear) {
        this.lastnamear = lastnamear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previoususerid != null ? previoususerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Previoususer)) {
            return false;
        }
        Previoususer other = (Previoususer) object;
        if ((this.previoususerid == null && other.previoususerid != null) || (this.previoususerid != null && !this.previoususerid.equals(other.previoususerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Previoususer[ previoususerid=" + previoususerid + " ]";
    }

}
