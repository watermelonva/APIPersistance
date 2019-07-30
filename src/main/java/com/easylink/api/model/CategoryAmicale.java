/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author ade
 */
@Entity
@Table(name = "CATEGORYAMICALE")
@XmlRootElement
public class CategoryAmicale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CATEGORYAMICALEID")
    private Integer categoryamicaleid;
    @Column(name = "CEILING")
    private Float ceiling;
    @Column(name = "RETIREAGE")
    private Integer retireage;
    @Size(max = 255)
    @Column(name = "CATEGORYNAME")
    private String categoryname;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;
    @OneToMany(mappedBy = "categoryamicale", fetch = FetchType.LAZY)
    private Collection<User> userCollection;
    @OneToMany(mappedBy = "categoryamicaleid", fetch = FetchType.LAZY)
    private Collection<Previoususer> previoususersCollection;

    public CategoryAmicale() {
    }

    public Collection<Previoususer> getPrevioususersCollection() {
        return previoususersCollection;
    }

    public void setPrevioususersCollection(Collection<Previoususer> previoususersCollection) {
        this.previoususersCollection = previoususersCollection;
    }

    public Integer getCategoryamicaleid() {
        return categoryamicaleid;
    }

    public void setCategoryamicaleid(Integer categoryamicaleid) {
        this.categoryamicaleid = categoryamicaleid;
    }

    public float getCeiling() {
        return ceiling;
    }

    public void setCeiling(float ceiling) {
        this.ceiling = ceiling;
    }

    public Integer getRetireage() {
        return retireage;
    }

    public void setRetireage(Integer retireage) {
        this.retireage = retireage;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryamicaleid != null ? categoryamicaleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoryAmicale other = (CategoryAmicale) obj;
        if (!Objects.equals(this.categoryamicaleid, other.categoryamicaleid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return categoryname + ": " + ceiling + " DT / " + retireage + "ans";
    }
}
