/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "DEADLINE")
@XmlRootElement
public class Deadline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEADLINEID")
    private Integer deadlineid;
    @Column(name = "MAXMONTHES")
    private Integer maxmonthes;
    @Column(name = "MINAMOUNTMONTHS")
    private Double minamountmonths;
    //type advance 0: % 
    //type advance 1: DT
    @Column(name = "TYPEADVANCE")
    private Short typeadvance;
    @Column(name = "ADVANCEAMOUNT")
    private Double advanceamount;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "WITHCOMMITMENT")
    private Short withcommitment;
    @Column(name = "WITHCHECK")
    private Short withcheck;
    @JoinColumn(name = "OFFER", referencedColumnName = "OFFERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Offer offer;
    @Transient
    private Boolean isDeleted;
     @Column(name = "TOTALTHRESHOLDMIN")
    private Double totalthreasholdmin;

    public Double getTotalthreasholdmin() {
        return totalthreasholdmin;
    }

    public void setTotalthreasholdmin(Double totalthreasholdmin) {
        this.totalthreasholdmin = totalthreasholdmin;
    }
     
     

    public Deadline() {
    }

    public Deadline(Integer maxmonthes, Double minamountmonths, Double advanceamount) {
        this.maxmonthes = maxmonthes;
        this.minamountmonths = minamountmonths;
        this.advanceamount = advanceamount;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Integer getDeadlineid() {
        return deadlineid;
    }

    public void setDeadlineid(Integer deadlineid) {
        this.deadlineid = deadlineid;
    }

    public Integer getMaxmonthes() {
        return maxmonthes;
    }

    public void setMaxmonthes(Integer maxmonthes) {
        this.maxmonthes = maxmonthes;
    }

    public Double getMinamountmonths() {
        return minamountmonths;
    }

    public void setMinamountmonths(Double minamountmonths) {
        this.minamountmonths = minamountmonths;
    }

    public Short getTypeadvance() {
        return typeadvance;
    }

    public void setTypeadvance(Short typeadvance) {
        this.typeadvance = typeadvance;
    }

    public Double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(Double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getWithcommitment() {
        return withcommitment;
    }

    public void setWithcommitment(Short withcommitment) {
        this.withcommitment = withcommitment;
    }

    public Short getWithcheck() {
        return withcheck;
    }

    public void setWithcheck(Short withcheck) {
        this.withcheck = withcheck;
    }

    public Double calculationAdvancedAmount(Double totalAmount) {
        if (typeadvance == 0) {
            return (advanceamount / 100) * totalAmount;

        } else if (typeadvance == 1) {
            return advanceamount;
        } else {
            return null;
        }

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deadlineid != null ? deadlineid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deadline)) {
            return false;
        }
        Deadline other = (Deadline) object;
        if ((this.deadlineid == null && other.deadlineid != null) || (this.deadlineid != null && !this.deadlineid.equals(other.deadlineid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format(ResourceBundle.getBundle("/Bundle_fr").getString("PaymentFormula"), this.getMaxmonthes(), this.getMinamountmonths());
//         return "Deadline{" + "maxmonthes=" + maxmonthes + ", minamountmonths=" + minamountmonths + ", typeadvance=" + typeadvance + ", advanceamount=" + advanceamount + ", withcommitment=" + withcommitment + ", withcheck=" + withcheck + '}';
    }

}
