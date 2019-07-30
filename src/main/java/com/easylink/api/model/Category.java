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
@Table(name = "CATEGORY")
@XmlRootElement

public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATEGORYID")
    private Integer categoryid;
    @Size(max = 50)
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @OneToMany(mappedBy = "categoryid")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "catCategoryid")
    private Collection<Category> categoryCollection;
    @JoinColumn(name = "CAT_CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category catCategoryid;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ISACTIF")
    private Short isactif;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getIsactif() {
        return isactif;
    }

    public void setIsactif(Short isactif) {
        this.isactif = isactif;
    }
    
    

    public Category() {
    }

    public Category(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
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

   

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Category getCatCategoryid() {
        return catCategoryid;
    }

    public void setCatCategoryid(Category catCategoryid) {
        this.catCategoryid = catCategoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryid != null ? categoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid))) {
            return false;
        }
        return true;
    }

    public Category(Integer categoryid,@Size(max = 50) String picture, Short isdeleted, Date deleteddate, Date addeddate, @Size(max = 255) String name, Short isactif) {
        this.categoryid=categoryid;
        this.picture = picture;
        this.isdeleted = isdeleted;
        this.deleteddate = deleteddate;
        this.addeddate = addeddate;
        this.name = name;
        this.isactif = isactif;
    }
    public Category(Integer categoryid,@Size(max = 50) String picture, Short isdeleted, Date deleteddate, Date addeddate, @Size(max = 255) String name, Short isactif,Collection<Product> productCollection) {
        this.categoryid=categoryid;
        this.picture = picture;
        this.isdeleted = isdeleted;
        this.deleteddate = deleteddate;
        this.addeddate = addeddate;
        this.name = name;
        this.isactif = isactif;
        this.productCollection=productCollection;
    }



}
