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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "ooredoopreviousamount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ooredoopreviousamount.findAll", query = "SELECT o FROM Ooredoopreviousamount o"),
    @NamedQuery(name = "Ooredoopreviousamount.findByPreviousamountid", query = "SELECT o FROM Ooredoopreviousamount o WHERE o.previousamountid = :previousamountid"),
    @NamedQuery(name = "Ooredoopreviousamount.findByCin", query = "SELECT o FROM Ooredoopreviousamount o WHERE o.cin = :cin"),
    @NamedQuery(name = "Ooredoopreviousamount.findByCnrps", query = "SELECT o FROM Ooredoopreviousamount o WHERE o.cnrps = :cnrps"),
    @NamedQuery(name = "Ooredoopreviousamount.findByAmount", query = "SELECT o FROM Ooredoopreviousamount o WHERE o.amount = :amount")})
public class Ooredoopreviousamount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PREVIOUSAMOUNTID")
    private Integer previousamountid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CIN")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CNRPS")
    private String cnrps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private Float amount;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }
    
    public Ooredoopreviousamount() {
    }

    public Ooredoopreviousamount(Integer previousamountid) {
        this.previousamountid = previousamountid;
    }

    public Ooredoopreviousamount(Integer previousamountid, String cin, String cnrps, float amount) {
        this.previousamountid = previousamountid;
        this.cin = cin;
        this.cnrps = cnrps;
        this.amount = amount;
    }

    public Integer getPreviousamountid() {
        return previousamountid;
    }

    public void setPreviousamountid(Integer previousamountid) {
        this.previousamountid = previousamountid;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCnrps() {
        return cnrps;
    }

    public void setCnrps(String cnrps) {
        this.cnrps = cnrps;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previousamountid != null ? previousamountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ooredoopreviousamount)) {
            return false;
        }
        Ooredoopreviousamount other = (Ooredoopreviousamount) object;
        if ((this.previousamountid == null && other.previousamountid != null) || (this.previousamountid != null && !this.previousamountid.equals(other.previousamountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Ooredoopreviousamount[ previousamountid=" + previousamountid + " ]";
    }
    
}
