/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "PRODUCT_CHARACTERISTIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCharacteristic.findAll", query = "SELECT p FROM ProductCharacteristic p"),
    @NamedQuery(name = "ProductCharacteristic.findByProductvalueid", query = "SELECT p FROM ProductCharacteristic p WHERE p.productvalueid = :productvalueid"),
    @NamedQuery(name = "ProductCharacteristic.findByValue", query = "SELECT p FROM ProductCharacteristic p WHERE p.value = :value")})
public class ProductCharacteristic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTVALUEID")
    private Integer productvalueid;
    @Size(max = 100)
    @Column(name = "VALUE")
    private String value;
    @JoinColumn(name = "VALUEID", referencedColumnName = "VALUEID")
    @ManyToOne
    private CharacteristicValue valueid;
    @JoinColumn(name = "CHARID", referencedColumnName = "CHARID")
    @ManyToOne(optional = false)
    private Characteristic charid;

    public ProductCharacteristic() {
    }

    public ProductCharacteristic(Integer productvalueid) {
        this.productvalueid = productvalueid;
    }

    public Integer getProductvalueid() {
        return productvalueid;
    }

    public void setProductvalueid(Integer productvalueid) {
        this.productvalueid = productvalueid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CharacteristicValue getValueid() {
        return valueid;
    }

    public void setValueid(CharacteristicValue valueid) {
        this.valueid = valueid;
    }

    public Characteristic getCharid() {
        return charid;
    }

    public void setCharid(Characteristic charid) {
        this.charid = charid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productvalueid != null ? productvalueid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCharacteristic)) {
            return false;
        }
        ProductCharacteristic other = (ProductCharacteristic) object;
        if ((this.productvalueid == null && other.productvalueid != null) || (this.productvalueid != null && !this.productvalueid.equals(other.productvalueid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.ProductCharacteristic[ productvalueid=" + productvalueid + " ]";
    }
    
}
