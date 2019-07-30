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
@Table(name = "ooredoopreviousdb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ooredoopreviousdb.findAll", query = "SELECT o FROM Ooredoopreviousdb o"),
    @NamedQuery(name = "Ooredoopreviousdb.findByPreviousid", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.previousid = :previousid"),
    @NamedQuery(name = "Ooredoopreviousdb.findByCin", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.cin = :cin"),
    @NamedQuery(name = "Ooredoopreviousdb.findByCnrps", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.cnrps = :cnrps"),
    @NamedQuery(name = "Ooredoopreviousdb.findByCle", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.cle = :cle"),
    @NamedQuery(name = "Ooredoopreviousdb.findByBox", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.box = :box"),
    @NamedQuery(name = "Ooredoopreviousdb.findByMifi", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.mifi = :mifi"),
    @NamedQuery(name = "Ooredoopreviousdb.findByVoix", query = "SELECT o FROM Ooredoopreviousdb o WHERE o.voix = :voix")})
public class Ooredoopreviousdb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PREVIOUSID")
    private Integer previousid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CIN")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CNRPS")
    private String cnrps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLE")
    private Integer cle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOX")
    private Integer box;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIFI")
    private Integer mifi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOIX")
    private Integer voix;

    public Ooredoopreviousdb() {
    }

    public Ooredoopreviousdb(Integer previousid) {
        this.previousid = previousid;
    }

    public Ooredoopreviousdb(Integer previousid, String cin, String cnrps, int amicaleid, int cle, int box, int mifi, int voix) {
        this.previousid = previousid;
        this.cin = cin;
        this.cnrps = cnrps;
        this.cle = cle;
        this.box = box;
        this.mifi = mifi;
        this.voix = voix;
    }

    public Integer getPreviousid() {
        return previousid;
    }

    public void setPreviousid(Integer previousid) {
        this.previousid = previousid;
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


    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getMifi() {
        return mifi;
    }

    public void setMifi(int mifi) {
        this.mifi = mifi;
    }

    public int getVoix() {
        return voix;
    }

    public void setVoix(int voix) {
        this.voix = voix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previousid != null ? previousid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ooredoopreviousdb)) {
            return false;
        }
        Ooredoopreviousdb other = (Ooredoopreviousdb) object;
        if ((this.previousid == null && other.previousid != null) || (this.previousid != null && !this.previousid.equals(other.previousid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Ooredoopreviousdb[ previousid=" + previousid + " ]";
    }
    
}
