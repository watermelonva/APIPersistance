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
@Table(name = "ACCOUNT_MOVE_LINE")
@XmlRootElement
public class AccountMoveLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNTMOVELINEID")
    private Integer accountMoveLineId;
    @JoinColumn(name = "JOURNALID", referencedColumnName = "JOURNALID")
    @ManyToOne
    private Journal journalid;
    @Size(max = 255)
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATE")
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "DEBIT", scale = 3)
    private Double debit;
    @Column(name = "CREDIT", scale = 3)
    private Double credit;
    @JoinColumn(name = "ACCOUNTMOVEID", referencedColumnName = "ACCOUNTMOVEID")
    @ManyToOne
    @Basic(optional = false)
    private AccountMove accountMoveId;
    @JoinColumn(name = "PROVIDERID", referencedColumnName = "PROVIDERID")
    @ManyToOne
    private Provider providerid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private User userid;
    @Column(name = "POSTED")
    private Short posted;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne
    private Account accountid;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "INVOICEID")
    @ManyToOne
    private Invoice invoiceid;
    @JoinColumn(name = "PAYMENTID", referencedColumnName = "PAYMENTID")
    @ManyToOne
    private Payment paymentid;

    public Invoice getInvoiceId() {
        return invoiceid;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceid = invoiceId;
    }

    public Payment getPaymentId() {
        return paymentid;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentid = paymentId;
    }
    
    

    public Account getAccountId() {
        return accountid;
    }

    public void setAccountId(Account accountId) {
        this.accountid = accountId;
    }

    public Short getPosted() {
        return posted;
    }

    public void setPosted(Short posted) {
        this.posted = posted;
    }

    public Integer getAccountMoveLineId() {
        return accountMoveLineId;
    }

    public void setAccountMoveLineId(Integer accountMoveLineId) {
        this.accountMoveLineId = accountMoveLineId;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public AccountMove getAccountMoveId() {
        return accountMoveId;
    }

    public void setAccountMoveId(AccountMove accountMoveId) {
        this.accountMoveId = accountMoveId;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
    
    

    public Journal getJournalid() {
        return journalid;
    }

    public void setJournalid(Journal journal) {
        this.journalid = journal;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountMoveId != null ? accountMoveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountMoveLine)) {
            return false;
        }
        AccountMoveLine other = (AccountMoveLine) object;
        if ((this.accountMoveLineId == null && other.accountMoveLineId != null) || (this.accountMoveLineId != null && !this.accountMoveLineId.equals(other.accountMoveLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.AccountChart[ id=" + accountMoveLineId + " ]";
    }

}
