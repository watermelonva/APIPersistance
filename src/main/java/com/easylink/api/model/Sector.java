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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "SECTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findBySectorid", query = "SELECT s FROM Sector s WHERE s.sectorid = :sectorid"),
    @NamedQuery(name = "Sector.findByFrenchname", query = "SELECT s FROM Sector s WHERE s.frenchname = :frenchname"),
    @NamedQuery(name = "Sector.findByArabicname", query = "SELECT s FROM Sector s WHERE s.arabicname = :arabicname")})
public class Sector implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorid")
    private Collection<Provider> providerCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SECTORID")
    private Integer sectorid;
    @Size(max = 100)
    @Column(name = "FRENCHNAME")
    private String frenchname;
    @Size(max = 100)
    @Column(name = "ARABICNAME")
    private String arabicname;

    public Sector() {
    }

    public Sector(Integer sectorid) {
        this.sectorid = sectorid;
    }

    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    public String getFrenchname() {
        return frenchname;
    }

    public void setFrenchname(String frenchname) {
        this.frenchname = frenchname;
    }

    public String getArabicname() {
        return arabicname;
    }

    public void setArabicname(String arabicname) {
        this.arabicname = arabicname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectorid != null ? sectorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.sectorid == null && other.sectorid != null) || (this.sectorid != null && !this.sectorid.equals(other.sectorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getFrenchname();
    }

    @XmlTransient
    public Collection<Provider> getProviderCollection() {
        return providerCollection;
    }

    public void setProviderCollection(Collection<Provider> providerCollection) {
        this.providerCollection = providerCollection;
    }
    
}
