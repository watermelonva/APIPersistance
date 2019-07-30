/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByPayments", query = "SELECT p FROM Product p WHERE p.payments = :payments"),
    @NamedQuery(name = "Product.findBySn", query = "SELECT p FROM Product p WHERE p.sn = :sn"),
    @NamedQuery(name = "Product.findByReference", query = "SELECT p FROM Product p WHERE p.reference = :reference"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock"),
    @NamedQuery(name = "Product.findBySoldstock", query = "SELECT p FROM Product p WHERE p.soldstock = :soldstock"),
    @NamedQuery(name = "Product.findByIsnew", query = "SELECT p FROM Product p WHERE p.isnew = :isnew"),
    @NamedQuery(name = "Product.findByIspromotion", query = "SELECT p FROM Product p WHERE p.ispromotion = :ispromotion"),
    @NamedQuery(name = "Product.findByIsdeleted", query = "SELECT p FROM Product p WHERE p.isdeleted = :isdeleted"),
    @NamedQuery(name = "Product.findByIsactif", query = "SELECT p FROM Product p WHERE p.isactif = :isactif"),
    @NamedQuery(name = "Product.findByDeleteddate", query = "SELECT p FROM Product p WHERE p.deleteddate = :deleteddate"),
    @NamedQuery(name = "Product.findByAddeddate", query = "SELECT p FROM Product p WHERE p.addeddate = :addeddate"),
    @NamedQuery(name = "Product.findByPricetype", query = "SELECT p FROM Product p WHERE p.pricetype = :pricetype"),
    @NamedQuery(name = "Product.findByPublicprice", query = "SELECT p FROM Product p WHERE p.publicprice = :publicprice"),
    @NamedQuery(name = "Product.findByConventionprice", query = "SELECT p FROM Product p WHERE p.conventionprice = :conventionprice"),
    @NamedQuery(name = "Product.findBySpecs", query = "SELECT p FROM Product p WHERE p.specs = :specs"),
    @NamedQuery(name = "Product.findByTerms", query = "SELECT p FROM Product p WHERE p.terms = :terms"),
    @NamedQuery(name = "Product.findByWaranty", query = "SELECT p FROM Product p WHERE p.waranty = :waranty"),
    @NamedQuery(name = "Product.findByDisplayoutofstock", query = "SELECT p FROM Product p WHERE p.displayoutofstock = :displayoutofstock")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 8)
    @Column(name = "PAYMENTS")
    private String payments;
    @Column(name = "SERIALIZED")
    private Short serialized;
    @Size(max = 50)
    @Column(name = "SN")
    private String sn;
    @Size(max = 50)
    @Column(name = "REFERENCE")
    private String reference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STOCK")
    private Float stock;
    @Column(name = "SOLDSTOCK")
    private Float soldstock;
    @Column(name = "ISNEW")
    private Short isnew;
    @Column(name = "ISPROMOTION")
    private Short ispromotion;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "ISACTIF")
    private Short isactif;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Size(max = 7)
    @Column(name = "PRICETYPE")
    private String pricetype;
    @Column(name = "PUBLICPRICE")
    private Float publicprice;
    @Column(name = "PRICEHT")
    private Float priceht;
    @Column(name = "CONVENTIONPRICE")
    private Float conventionprice;
    @Size(max = 1000)
    @Column(name = "SPECS")
    private String specs;
    @Column(name = "TERMS")
    private Integer terms;
    @Column(name = "WARANTY")
    private Integer waranty;
    @Column(name = "DISPLAYOUTOFSTOCK")
    private Short displayoutofstock;
    @OneToMany(mappedBy = "productid")
    private Collection<Picture> pictureCollection;
    @OneToMany(mappedBy = "productid")
    private Collection<Transaction> transactionCollection;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category categoryid;
    @Transient
    private Collection<Picture> pictureCollectionws;
    @Column(name = "LENGTH")
    private Float length;
    @Column(name = "HEIGHT")
    private Float height;
    @Column(name = "DEPTH")
    private Float depth;
    @Column(name = "WEIGHT")
    private Float weight;
    @Column(name = "WITHDELIVERY")
    private Short withdelivery;
    @Column(name = "FREEDELIVERY")
    private Short freedelivery;
    @Column(name = "DELIVERYFEES")
    private Float deliveryfees;
    @JoinColumn(name = "VATID", referencedColumnName = "VATID")
    @ManyToOne
    private Vat vatid;
    @Column(name = "VALIDATION")
    private Short validation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VALIDATIONDATE")
    private Date validationdate;
    @Size(max = 255)
    @Column(name = "REJECTIONCAUSE")
    private String rejectioncause;
    @JoinColumn(name = "VALIDATIONBY", referencedColumnName = "USERID")
    @ManyToOne
    private User validationby;
    @Size(max = 255)
    @Column(name = "SKU")
    private String sku;
    @JoinColumn(name = "BRANDID", referencedColumnName = "BRANDID")
    @ManyToOne
    private Brand brandid;

    @ManyToMany
    private Set<Offer> offers;

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
    }

    public Short getValidation() {
        return validation;
    }

    public void setValidation(Short validation) {
        this.validation = validation;
    }

    public Date getValidationdate() {
        return validationdate;
    }

    public void setValidationdate(Date validationdate) {
        this.validationdate = validationdate;
    }

    public String getRejectioncause() {
        return rejectioncause;
    }

    public void setRejectioncause(String rejectioncause) {
        this.rejectioncause = rejectioncause;
    }

    public User getValidationby() {
        return validationby;
    }

    public void setValidationby(User validationby) {
        this.validationby = validationby;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Short getWithdelivery() {
        return withdelivery;
    }

    public void setWithdelivery(Short withdelivery) {
        this.withdelivery = withdelivery;
    }

    public Short getFreedelivery() {
        return freedelivery;
    }

    public void setFreedelivery(Short freedelivery) {
        this.freedelivery = freedelivery;
    }

    public Float getDeliveryfees() {
        return deliveryfees;
    }

    public void setDeliveryfees(Float deliveryfees) {
        this.deliveryfees = deliveryfees;
    }

    public Vat getVatid() {
        return vatid;
    }

    public void setVatid(Vat vatid) {
        this.vatid = vatid;
    }

    public Collection<Picture> getPictureCollectionws() {
        return pictureCollectionws;
    }

    public void setPictureCollectionws(Collection<Picture> pictureCollectionws) {
        this.pictureCollectionws = pictureCollectionws;
    }

    public Product() {
    }

    public Product(Integer productid) {
        this.productid = productid;
    }

    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    public Float getPriceht() {
        return priceht;
    }

    public void setPriceht(Float priceht) {
        this.priceht = priceht;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public Short getSerialized() {
        return serialized;
    }

    public void setSerialized(Short serialized) {
        this.serialized = serialized;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Float getSoldstock() {
        return soldstock;
    }

    public void setSoldstock(Float soldstock) {
        this.soldstock = soldstock;
    }

    public Short getIsnew() {
        return isnew;
    }

    public void setIsnew(Short isnew) {
        this.isnew = isnew;
    }

    public Short getIspromotion() {
        return ispromotion;
    }

    public void setIspromotion(Short ispromotion) {
        this.ispromotion = ispromotion;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Short getIsactif() {
        return isactif;
    }

    public void setIsactif(Short isactif) {
        this.isactif = isactif;
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

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public Float getPublicprice() {
        return publicprice;
    }

    public void setPublicprice(Float publicprice) {
        this.publicprice = publicprice;
    }

    public Float getConventionprice() {
        return conventionprice;
    }

    public void setConventionprice(Float conventionprice) {
        this.conventionprice = conventionprice;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public Integer getWaranty() {
        return waranty;
    }

    public void setWaranty(Integer waranty) {
        this.waranty = waranty;
    }

    public Short getDisplayoutofstock() {
        return displayoutofstock;
    }

    public void setDisplayoutofstock(Short displayoutofstock) {
        this.displayoutofstock = displayoutofstock;
    }

    @XmlTransient
    public Collection<Picture> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Collection<Picture> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    public Float calculDiscount() {
        return ((this.publicprice - this.conventionprice) / this.publicprice) * 100;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities2.Product[ productid=" + productid + " ]";
    }

    public Product(Integer productid,@Size(max = 200) String name,String description,String payments,short serialized,String sn,String reference,float stock,float soldstock ,short isnew) {
        this.name = name;
        this.productid=productid;
        this.description=description;
        this.payments=payments;
        this.serialized=serialized;
        this.sn=sn;
        this.reference=reference;
        this.stock=stock;
        this.soldstock=soldstock;
        this.isnew=isnew;
    }
}
