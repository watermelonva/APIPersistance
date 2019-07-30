/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "OFFER")
@XmlRootElement
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFFERID")
    private Integer offerid;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DISCOUNT")
    private Short discount;
    @Column(name = "TRANCHEPAYMENT")
    private Short tranchepayment;
    @Column(name = "CASHPAYMENT")
    private Short cashpayment;
    //typediscount 0:fixed
    //typediscount 1:variable
    @Column(name = "TYPEDISCOUNT")
    private Short typediscount;
    //typedeadline 0:fixed
    //typedeadline 1:variable
    @Column(name = "TYPEDEADLINE")
    private Short typedeadline;
    @Column(name = "DATA")
    private Short data;
    @Column(name = "PRICEOFFER")
    private Double priceoffer;
    @Column(name = "NBRPERSON")
    private Integer nbrperson;
    @Column(name = "NBRFAMILY")
    private Integer nbrfamily;
    @JoinColumn(name = "CONVENTION", referencedColumnName = "CONVETIONID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Convention convention;
    @OneToMany(mappedBy = "offer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Discount> discountCollection;
    @OneToMany(mappedBy = "offer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Deadline> deadlineCollection;
    @OneToMany(mappedBy = "offer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection;
    @Size(max = 255)
    @Column(name = "POSTER")
    private String poster;
    @Column(name = "ISACTIF")
    private Short isactif;
    @Transient
    private Boolean isDeleted;
    @Transient
    private Boolean hided;
    @Column(name = "MAXOFFER")
    private Short maxoffer;
    @Column(name = "OFFER_ID")
    private String offeridstring;
    @Column(name = "SERVICE_ID")
    private String service_id;
    @Column(name = "WITHOUTAUTOVALIDATION")
    private Short withoutautovalidation;
    @Column(name = "WITHDELIVERY")
    private Short withdelivery;
    @Column(name = "PAYONDELIVERY")
    private Short payondelivery;
    @Size(max = 100)
    @Column(name = "SUPPPORTNUM")
    private String supportnum;
    @Column(name = "DELIVERYAMOUNT", scale = 3)
    private Double deliveryamount;
    @Column(name = "WITHRESERVATION")
    private Short withreservation;

    @ManyToMany
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    public Short getWithreservation() {
        return withreservation;
    }

    public void setWithreservation(Short withreservation) {
        this.withreservation = withreservation;
    }

    public Short getPayondelivery() {
        return payondelivery;
    }

    public void setPayondelivery(Short payondelivery) {
        this.payondelivery = payondelivery;
    }

    public String getSupportnum() {
        return supportnum;
    }

    public void setSupportnum(String supportnum) {
        this.supportnum = supportnum;
    }

    public Double getDeliveryamount() {
        return deliveryamount;
    }

    public void setDeliveryamount(Double deliveryamount) {
        this.deliveryamount = deliveryamount;
    }

    public Short getWithdelivery() {
        return withdelivery;
    }

    public void setWithdelivery(Short withdelivery) {
        this.withdelivery = withdelivery;
    }

    public String getOffer_id() {
        return offeridstring;
    }

    public void setOffer_id(String offeridstring) {
        this.offeridstring = offeridstring;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Short getMaxoffer() {
        return maxoffer;
    }

    public void setMaxoffer(Short maxoffer) {
        this.maxoffer = maxoffer;
    }

    public Offer() {
    }

    public boolean isHided() {
        return hided;
    }

    public void setHided(boolean hided) {
        this.hided = hided;
    }

    public Short getIsactif() {
        return isactif;
    }

    public void setIsactif(Short isactif) {
        this.isactif = isactif;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Short getCashpayment() {
        return cashpayment;
    }

    public void setCashpayment(Short cashpayment) {
        this.cashpayment = cashpayment;
    }

    public Short getData() {
        return data;
    }

    public void setData(Short data) {
        this.data = data;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOfferid() {
        return offerid;
    }

    public void setOfferid(Integer offerid) {
        this.offerid = offerid;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    public Collection<Discount> getDiscountCollection() {
        return discountCollection;
    }

    public Double getFirstMinAmount() {
        return deadlineCollection.iterator().next().getMinamountmonths();
    }

    public void setDiscountCollection(Collection<Discount> discountCollection) {
        this.discountCollection = discountCollection;
    }

    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    public Collection<Deadline> getDeadlineCollection() {
        return deadlineCollection;
    }

    public void setDeadlineCollection(Collection<Deadline> deadlineCollection) {
        this.deadlineCollection = deadlineCollection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public Short getTranchepayment() {
        return tranchepayment;
    }

    public void setTranchepayment(Short tranchepayment) {
        this.tranchepayment = tranchepayment;
    }

    public Short getTypediscount() {
        return typediscount;
    }

    public void setTypediscount(Short typediscount) {
        this.typediscount = typediscount;
    }

    public Short getTypedeadline() {
        return typedeadline;
    }

    public void setTypedeadline(Short typedeadline) {
        this.typedeadline = typedeadline;
    }

    public Double getPriceoffer() {
        return priceoffer;
    }

    public void setPriceoffer(Double priceoffer) {
        this.priceoffer = priceoffer;
    }

    public Integer getNbrperson() {
        return nbrperson;
    }

    public void setNbrperson(Integer nbrperson) {
        this.nbrperson = nbrperson;
    }

    public Integer getNbrfamily() {
        return nbrfamily;
    }

    public void setNbrfamily(Integer nbrfamily) {
        this.nbrfamily = nbrfamily;
    }

    public Short getWithoutautovalidation() {
        return withoutautovalidation;
    }

    public void setWithoutautovalidation(Short withoutautovalidation) {
        this.withoutautovalidation = withoutautovalidation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.offerid);
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
        final Offer other = (Offer) obj;
        if (!Objects.equals(this.offerid, other.offerid)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return title;
    }

    public Offer(Integer offerid,Double priceoffer,Convention convention) {
        this.convention = convention;
        this.offerid=offerid;
        this.priceoffer=priceoffer;
    }
    public Offer(Integer offerid,Double priceoffer,Convention convention,Set<Product> products) {
        this.convention = convention;
        this.offerid=offerid;
        this.priceoffer=priceoffer;
        this.products=products;
    }

}
