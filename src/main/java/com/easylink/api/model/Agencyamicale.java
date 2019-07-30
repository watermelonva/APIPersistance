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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adeveganet
 */
@Entity
@Table(name = "AGENCYAMICALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencyamicale.findAll", query = "SELECT a FROM Agencyamicale a"),
    @NamedQuery(name = "Agencyamicale.findByAgencyamicaleid", query = "SELECT a FROM Agencyamicale a WHERE a.agencyamicaleid = :agencyamicaleid"),
    @NamedQuery(name = "Agencyamicale.findByAutovalidationbuy", query = "SELECT a FROM Agencyamicale a WHERE a.autovalidationbuy = :autovalidationbuy"),
    @NamedQuery(name = "Agencyamicale.findByThreshold", query = "SELECT a FROM Agencyamicale a WHERE a.threshold = :threshold"),
    @NamedQuery(name = "Agencyamicale.findByAutovalidationuser", query = "SELECT a FROM Agencyamicale a WHERE a.autovalidationuser = :autovalidationuser")})
public class Agencyamicale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGENCYAMICALEID")
    private Integer agencyamicaleid;
    /**
     * 0: l'achat passe par obligatoirement validation 1: l'achat passe par
     * validation si elle depasse le seuil 2: l'achat est valide automatiquement
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTOVALIDATIONBUY")
    private Boolean autovalidationbuy;
    /**
     * montant du seuil
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "THRESHOLD")
    private Float threshold;
    /**
     * validation user (signature dans le pdf) 0:non 1:oui
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTOVALIDATIONUSER")
    private Boolean autovalidationuser;


    @JoinColumn(name = "AGENCY", referencedColumnName = "AGENCYID")
    @ManyToOne
    private Agency agency;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicale;

    public Agencyamicale() {
    }

    public Agencyamicale(Integer agencyamicaleid) {
        this.agencyamicaleid = agencyamicaleid;
    }

    public Agencyamicale(Integer agencyamicaleid, Boolean autovalidationbuy, Float threshold, Boolean autovalidationuser) {
        this.agencyamicaleid = agencyamicaleid;
        this.autovalidationbuy = autovalidationbuy;
        this.threshold = threshold;
        this.autovalidationuser = autovalidationuser;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Integer getAgencyamicaleid() {
        return agencyamicaleid;
    }

    public void setAgencyamicaleid(Integer agencyamicaleid) {
        this.agencyamicaleid = agencyamicaleid;
    }

    public Boolean getAutovalidationbuy() {
        return autovalidationbuy;
    }

    public void setAutovalidationbuy(Boolean autovalidationbuy) {
        this.autovalidationbuy = autovalidationbuy;
    }

    public Float getThreshold() {
        return threshold;
    }

    public void setThreshold(Float threshold) {
        this.threshold = threshold;
    }

    public Boolean getAutovalidationuser() {
        return autovalidationuser;
    }

    public void setAutovalidationuser(Boolean autovalidationuser) {
        this.autovalidationuser = autovalidationuser;
    }

 

    public Amicale getAmicale() {
        return amicale;
    }

    public void setAmicale(Amicale amicale) {
        this.amicale = amicale;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agencyamicaleid != null ? agencyamicaleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencyamicale)) {
            return false;
        }
        Agencyamicale other = (Agencyamicale) object;
        if ((this.agencyamicaleid == null && other.agencyamicaleid != null) || (this.agencyamicaleid != null && !this.agencyamicaleid.equals(other.agencyamicaleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Agencyamicale[ agencyamicaleid=" + agencyamicaleid + " ]";
    }

}
