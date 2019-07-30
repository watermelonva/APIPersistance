/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * to stop selling with provider account we add a maintenance. a maintenance can
 * be for (one/many amicales) or (one/many shops) or all
 *
 * @author amine
 */
@Entity
@Table(name = "MAINTENANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maintenance.findAll", query = "SELECT m FROM Maintenance m"),
    @NamedQuery(name = "Maintenance.findByMaintenanceid", query = "SELECT m FROM Maintenance m WHERE m.maintenanceid = :maintenanceid"),
    @NamedQuery(name = "Maintenance.findByStartm", query = "SELECT m FROM Maintenance m WHERE m.startm = :startm"),
    @NamedQuery(name = "Maintenance.findByAmicaleDate", query = "SELECT m FROM Maintenance m WHERE m.startm = :startm"),
    @NamedQuery(name = "Maintenance.findByEndm", query = "SELECT m FROM Maintenance m WHERE m.endm = :endm"),
    @NamedQuery(name = "Maintenance.countByStartEndDateLevelId", query = " SELECT COUNT(m) FROM Maintenance m WHERE m.startm <= :startm AND m.endm >= :endm AND m.levelm = :levelm AND m.forid = :forid"),
    @NamedQuery(name = "Maintenance.countByStartEndDateLevel", query = " SELECT COUNT(m) FROM Maintenance m WHERE m.startm <= :startm AND m.endm >= :endm AND m.levelm = :levelm"),
    @NamedQuery(name = "Maintenance.findByStartEndDateLevelId", query = " SELECT m FROM Maintenance m WHERE m.startm <= :startm AND m.endm >= :endm AND m.levelm = :levelm AND m.forid = :forid"),
    @NamedQuery(name = "Maintenance.findByStartEndDateLevel", query = " SELECT m FROM Maintenance m WHERE m.startm <= :startm AND m.endm >= :endm AND m.levelm = :levelm"),
    @NamedQuery(name = "Maintenance.findByLevelm", query = "SELECT m FROM Maintenance m WHERE m.levelm = :levelm"),
    @NamedQuery(name = "Maintenance.findByForid", query = "SELECT m FROM Maintenance m WHERE m.forid = :forid")})
public class Maintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAINTENANCEID")
    private Integer maintenanceid;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    /**
     * start maintenance date (shop will be closed from this date)
     */
    @Column(name = "STARTM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startm;
    /**
     * end maintenance date (shop will be reopened after this date)
     */
    @Column(name = "ENDM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endm;
    /**
     * 1:for same shops 2:same amicales 3:All
     */
    @Column(name = "LEVELM")
    private Short levelm;
    /**
     * if (levelm==1) forid will get the id of the shop to block. if (levelm==2)
     * forid will get the id of amicale to block.
     */
    @Column(name = "FORID")
    private Integer forid;
    /**
     * the message that will showed to shop when it try to login
     */
    @Lob
    @Column(name = "MESSAGE")
    private String message;

    public Maintenance() {
    }

    public Maintenance(Integer maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    public Maintenance(Integer maintenanceid, Date startm, Date endm, short level, int forid, String message) {
        this.maintenanceid = maintenanceid;
        this.startm = startm;
        this.endm = endm;
        this.levelm = level;
        this.forid = forid;
        this.message = message;
    }

    public Integer getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(Integer maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Date getStartm() {
        return startm;
    }

    public void setStartm(Date startm) {
        this.startm = startm;
    }

    public Date getEndm() {
        return endm;
    }

    public void setEndm(Date endm) {
        this.endm = endm;
    }

    public short getLevelm() {
        return levelm;
    }

    public void setLevelm(short levelm) {
        this.levelm = levelm;
    }

    public int getForid() {
        return forid;
    }

    public void setForid(int forid) {
        this.forid = forid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maintenanceid != null ? maintenanceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maintenance)) {
            return false;
        }
        Maintenance other = (Maintenance) object;
        if ((this.maintenanceid == null && other.maintenanceid != null) || (this.maintenanceid != null && !this.maintenanceid.equals(other.maintenanceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Maintenance[ maintenanceid=" + maintenanceid + " ]";
    }

}
