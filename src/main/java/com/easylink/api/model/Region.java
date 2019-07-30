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
 * @author ade
 */
@Entity
@Table(name = "REGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByRegionid", query = "SELECT r FROM Region r WHERE r.regionid = :regionid"),
    @NamedQuery(name = "Region.findByName", query = "SELECT r FROM Region r WHERE r.name = :name"),
    @NamedQuery(name = "Region.findByCode", query = "SELECT r FROM Region r WHERE r.code = :code")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REGIONID")
    private Integer regionid;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "CODE")
    private String code;
    @OneToMany(mappedBy = "region")
    private Collection<Center> centerCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Region() {
    }

    public Region(Integer regionid) {
        this.regionid = regionid;
    }

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Center> getCenterCollection() {
        return centerCollection;
    }

    public void setCenterCollection(Collection<Center> centerCollection) {
        this.centerCollection = centerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionid != null ? regionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regionid == null && other.regionid != null) || (this.regionid != null && !this.regionid.equals(other.regionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }

}
