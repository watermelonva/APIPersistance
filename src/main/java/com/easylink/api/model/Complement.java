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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "COMPLEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complement.findAll", query = "SELECT c FROM Complement c"),
    @NamedQuery(name = "Complement.findByComplementid", query = "SELECT c FROM Complement c WHERE c.complementid = :complementid AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Complement.findByEntitled", query = "SELECT c FROM Complement c WHERE c.entitled = :entitled AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Complement.findByDatecreate", query = "SELECT c FROM Complement c WHERE c.datecreate = :datecreate AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Complement.findByAmount", query = "SELECT c FROM Complement c WHERE c.amount = :amount AND c.amicaleid = :amicale")})
public class Complement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMPLEMENTID")
    private Integer complementid;
    @Size(max = 255)
    @Column(name = "ENTITLED")
    private String entitled;
    @Column(name = "DATECREATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @JoinColumn(name = "BUDGETID", referencedColumnName = "BUDGETID")
    @ManyToOne
    private Budget budgetid;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }
    
    public Complement() {
    }

    public Complement(Integer complementid) {
        this.complementid = complementid;
    }

    public Integer getComplementid() {
        return complementid;
    }

    public void setComplementid(Integer complementid) {
        this.complementid = complementid;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Budget getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Budget budgetid) {
        this.budgetid = budgetid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complementid != null ? complementid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complement)) {
            return false;
        }
        Complement other = (Complement) object;
        if ((this.complementid == null && other.complementid != null) || (this.complementid != null && !this.complementid.equals(other.complementid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Complement[ complementid=" + complementid + " ]";
    }
    
}
