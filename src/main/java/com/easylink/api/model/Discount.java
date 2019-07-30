/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "DISCOUNT")
@XmlRootElement
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DISCOUNTID")
    private Integer discountid;
    @Min(value = 0L, message = "Montant min invalide.")
    @NotNull(message = "Montant min est obligatoire.")
    @Column(name = "MINAMOUNT")
    private Double minamount;
    @Min(value = 0L, message = "Montant max invalide.")
    @NotNull(message = "Montant max est obligatoire.")
    @Column(name = "MAXAMOUNT")
    private Double maxamount;
    //type 0: %
    //type 1: amount    
    @Column(name = "TYPE")
    private Short type;
    @Min(value = 0L, message = "Remise invalide.")
    @NotNull(message = "Remise est obligatoire.")
    @Column(name = "DISCOUNT")
    private Double discount;
    @JoinColumn(name = "OFFER", referencedColumnName = "OFFERID")
    @ManyToOne
    private Offer offer;
    @Transient
    private Boolean isDeleted;

    public Discount() {

    }

    public Discount(Double minamount, Double maxamount, Double discount) {
        this.minamount = minamount;
        this.maxamount = maxamount;
        this.discount = discount;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Integer getDiscountid() {
        return discountid;
    }

    public void setDiscountid(Integer discountid) {
        this.discountid = discountid;
    }

    public Double getMinamount() {
        return minamount;
    }

    public void setMinamount(Double minamount) {
        this.minamount = minamount;
    }

    public Double getMaxamount() {
        return maxamount;
    }

    public void setMaxamount(Double maxamount) {
        this.maxamount = maxamount;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.minamount);
        hash = 79 * hash + Objects.hashCode(this.maxamount);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.discount);
        hash = 79 * hash + Objects.hashCode(this.offer);
        return hash;
    }

    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Discount other = (Discount) obj;
        if (!Objects.equals(this.minamount, other.minamount)) {
            return false;
        }
        if (!Objects.equals(this.maxamount, other.maxamount)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        if (!Objects.equals(this.offer, other.offer)) {
            return false;
        }
        return true;
    }

}
