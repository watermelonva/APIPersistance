/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "CHARACTERISTIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Characteristic.findAll", query = "SELECT c FROM Characteristic c"),
    @NamedQuery(name = "Characteristic.findByCharid", query = "SELECT c FROM Characteristic c WHERE c.charid = :charid"),
    @NamedQuery(name = "Characteristic.findByName", query = "SELECT c FROM Characteristic c WHERE c.name = :name"),
    @NamedQuery(name = "Characteristic.findByChartype", query = "SELECT c FROM Characteristic c WHERE c.chartype = :chartype"),
    @NamedQuery(name = "Characteristic.findByMandatorychar", query = "SELECT c FROM Characteristic c WHERE c.mandatorychar = :mandatorychar"),
    @NamedQuery(name = "Characteristic.findByIsactif", query = "SELECT c FROM Characteristic c WHERE c.isactif = :isactif")})
public class Characteristic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHARID")
    private Integer charid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHARTYPE")
    private Integer chartype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MANDATORYCHAR")
    private Short mandatorychar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIF")
    private Short isactif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "charid")
    private Collection<CharacteristicValue> characteristicValueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "charid")
    private Collection<ProductCharacteristic> productCharacteristicCollection;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category categoryid;

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }
    
    

    public Characteristic() {
    }

    public Characteristic(Integer charid) {
        this.charid = charid;
    }

    public Characteristic(Integer charid, String name, int chartype, short mandatorychar, short isactif) {
        this.charid = charid;
        this.name = name;
        this.chartype = chartype;
        this.mandatorychar = mandatorychar;
        this.isactif = isactif;
    }

    public Integer getCharid() {
        return charid;
    }

    public void setCharid(Integer charid) {
        this.charid = charid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChartype() {
        return chartype;
    }

    public void setChartype(int chartype) {
        this.chartype = chartype;
    }

    public short getMandatorychar() {
        return mandatorychar;
    }

    public void setMandatorychar(short mandatorychar) {
        this.mandatorychar = mandatorychar;
    }

    public short getIsactif() {
        return isactif;
    }

    public void setIsactif(short isactif) {
        this.isactif = isactif;
    }

    @XmlTransient
    public Collection<CharacteristicValue> getCharacteristicValueCollection() {
        return characteristicValueCollection;
    }

    public void setCharacteristicValueCollection(Collection<CharacteristicValue> characteristicValueCollection) {
        this.characteristicValueCollection = characteristicValueCollection;
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
        hash += (charid != null ? charid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Characteristic)) {
            return false;
        }
        Characteristic other = (Characteristic) object;
        if ((this.charid == null && other.charid != null) || (this.charid != null && !this.charid.equals(other.charid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Characteristic[ charid=" + charid + " ]";
    }
    
}
