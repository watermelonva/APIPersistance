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
@Table(name = "ooredooblacklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ooredooblacklist.findAll", query = "SELECT o FROM Ooredooblacklist o"),
    @NamedQuery(name = "Ooredooblacklist.findByBlacklistid", query = "SELECT o FROM Ooredooblacklist o WHERE o.blacklistid = :blacklistid"),
    @NamedQuery(name = "Ooredooblacklist.findByCin", query = "SELECT o FROM Ooredooblacklist o WHERE o.cin = :cin"),
    @NamedQuery(name = "Ooredooblacklist.findByCnrps", query = "SELECT o FROM Ooredooblacklist o WHERE o.cnrps = :cnrps")})
public class Ooredooblacklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BLACKLISTID")
    private Integer blacklistid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CIN")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNRPS")
    private String cnrps;

    public Ooredooblacklist() {
    }

    public Ooredooblacklist(Integer blacklistid) {
        this.blacklistid = blacklistid;
    }

    public Ooredooblacklist(Integer blacklistid, String cin, String cnrps) {
        this.blacklistid = blacklistid;
        this.cin = cin;
        this.cnrps = cnrps;
    }

    public Integer getBlacklistid() {
        return blacklistid;
    }

    public void setBlacklistid(Integer blacklistid) {
        this.blacklistid = blacklistid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blacklistid != null ? blacklistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ooredooblacklist)) {
            return false;
        }
        Ooredooblacklist other = (Ooredooblacklist) object;
        if ((this.blacklistid == null && other.blacklistid != null) || (this.blacklistid != null && !this.blacklistid.equals(other.blacklistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Ooredooblacklist[ blacklistid=" + blacklistid + " ]";
    }
    
}
