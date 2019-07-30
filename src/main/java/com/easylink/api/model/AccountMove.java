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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel TRIMECHE
 */
@Entity
@Table(name = "ACCOUNT_MOVE")
@XmlRootElement
public class AccountMove implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNTMOVEID")
    private Integer accountMoveId;
    @JoinColumn(name = "JOURNALID", referencedColumnName = "JOURNALID")
    @ManyToOne
    private Journal journal;
    @Size(max = 255)
    @Column(name = "NAME")
    @Basic(optional = false)
    private String name;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "TOTAL", scale = 3)
    private Double total;
    @Column(name = "POSTED")
    private Short posted;

    public Short getPosted() {
        return posted;
    }

    public void setPosted(Short posted) {
        this.posted = posted;
    }
    
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountMoveId() {
        return accountMoveId;
    }

    public void setAccountMoveId(Integer id) {
        this.accountMoveId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountMoveId != null ? accountMoveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountMove)) {
            return false;
        }
        AccountMove other = (AccountMove) object;
        if ((this.accountMoveId == null && other.accountMoveId != null) || (this.accountMoveId != null && !this.accountMoveId.equals(other.accountMoveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.AccountChart[ id=" + accountMoveId + " ]";
    }

}
