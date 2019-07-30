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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "Circular")
@XmlRootElement
public class Circular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CIRCULARID")
    private Integer circularid;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "ISACTIF")
    private Short isactif;
    @Column(name = "MAXSUBVENTIONTIME")
    private Integer maxsubventiontime;
    @Column(name = "UNIQPARTICIPATION")
    private Short uniqparticipation;
    @Column(name = "SCORINGTYPE")
    private Short scoringType;

    public Short getScoringType() {
        return scoringType;
    }

    public void setScoringType(Short scoringType) {
        this.scoringType = scoringType;
    }

    public Integer getCircularid() {
        return circularid;
    }

    public void setCircularid(Integer circularid) {
        this.circularid = circularid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Short getIsactif() {
        return isactif;
    }

    public void setIsactif(Short isactif) {
        this.isactif = isactif;
    }

    public Integer getMaxsubventiontime() {
        return maxsubventiontime;
    }

    public void setMaxsubventiontime(Integer maxsubventiontime) {
        this.maxsubventiontime = maxsubventiontime;
    }

    public Short getUniqparticipation() {
        return uniqparticipation;
    }

    public void setUniqparticipation(Short uniqparticipation) {
        this.uniqparticipation = uniqparticipation;
    }
    
    @Override
    public String toString() {
        return name;
    }
    

}
