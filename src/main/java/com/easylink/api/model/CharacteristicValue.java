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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "CHARACTERISTIC_VALUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CharacteristicValue.findAll", query = "SELECT c FROM CharacteristicValue c"),
    @NamedQuery(name = "CharacteristicValue.findByValueid", query = "SELECT c FROM CharacteristicValue c WHERE c.valueid = :valueid"),
    @NamedQuery(name = "CharacteristicValue.findByName", query = "SELECT c FROM CharacteristicValue c WHERE c.name = :name"),
    @NamedQuery(name = "CharacteristicValue.findByIsactif", query = "SELECT c FROM CharacteristicValue c WHERE c.isactif = :isactif")})
public class CharacteristicValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VALUEID")
    private Integer valueid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIF")
    private Short isactif;
    @JoinColumn(name = "CHARID", referencedColumnName = "CHARID")
    @ManyToOne(optional = false)
    private Characteristic charid;
    @OneToMany(mappedBy = "valueid")
    private Collection<ProductCharacteristic> productCharacteristicCollection;

    public CharacteristicValue() {
    }

    public CharacteristicValue(Integer valueid) {
        this.valueid = valueid;
    }

    public CharacteristicValue(Integer valueid, String name, short isactif) {
        this.valueid = valueid;
        this.name = name;
        this.isactif = isactif;
    }

    public Integer getValueid() {
        return valueid;
    }

    public void setValueid(Integer valueid) {
        this.valueid = valueid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getIsactif() {
        return isactif;
    }

    public void setIsactif(short isactif) {
        this.isactif = isactif;
    }

    public Characteristic getCharid() {
        return charid;
    }

    public void setCharid(Characteristic charid) {
        this.charid = charid;
    }

    @XmlTransient
    public Collection<ProductCharacteristic> getProductCharacteristicCollection() {
        return productCharacteristicCollection;
    }

    public void setProductCharacteristicCollection(Collection<ProductCharacteristic> productCharacteristicCollection) {
        this.productCharacteristicCollection = productCharacteristicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valueid != null ? valueid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacteristicValue)) {
            return false;
        }
        CharacteristicValue other = (CharacteristicValue) object;
        if ((this.valueid == null && other.valueid != null) || (this.valueid != null && !this.valueid.equals(other.valueid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.CharacteristicValue[ valueid=" + valueid + " ]";
    }
    
}
