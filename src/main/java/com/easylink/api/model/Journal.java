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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel TRIMECHE
 */
@Entity
@Table(name = "JOURNAL")
@XmlRootElement
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JOURNALID")
    private Integer journalid;
    @Basic(optional = false)
    @JoinColumn(name = "CREDITACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne
    private Account creditAccountId;
    @Basic(optional = false)
    @JoinColumn(name = "DEBITACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne
    private Account debitAccountId;
    @Size(max = 100)
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private JournalType type;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @OneToMany(mappedBy = "journalid")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "BANKID", referencedColumnName = "BANKID")
    @ManyToOne
    private Bank bankid;
    @OneToMany(mappedBy = "destjournalid")
    private Collection<Payment> paymentdestCollection;
    @OneToMany(mappedBy = "journalid")
    private Collection<AccountMoveLine> amlCollection;

    public Collection<AccountMoveLine> getAmlCollection() {
        return amlCollection;
    }

    public void setAmlCollection(Collection<AccountMoveLine> amlCollection) {
        this.amlCollection = amlCollection;
    }
    
    

    public Collection<Payment> getPaymentdestCollection() {
        return paymentdestCollection;
    }

    public void setPaymentdestCollection(Collection<Payment> paymentdestCollection) {
        this.paymentdestCollection = paymentdestCollection;
    }
    
    

    public Bank getBankid() {
        return bankid;
    }

    public void setBankid(Bank bankid) {
        this.bankid = bankid;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }
    
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JournalType getType() {
        return type;
    }

    public void setType(JournalType type) {
        this.type = type;
    }


    public Integer getJournalId() {
        return journalid;
    }

    public void setJournalId(Integer id) {
        this.journalid = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (journalid != null ? journalid.hashCode() : 0);
        return hash;
    }

    public Account getCreditAccountId() {
        return creditAccountId;
    }

    public void setCreditAccountId(Account creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public Account getDebitAccountId() {
        return debitAccountId;
    }

    public void setDebitAccountId(Account debitAccountId) {
        this.debitAccountId = debitAccountId;
    }

    public Amicale getAmicaleId() {
        return amicaleid;
    }

    public void setAmicaleId(Amicale amicaleId) {
        this.amicaleid = amicaleId;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journal)) {
            return false;
        }
        Journal other = (Journal) object;
        if ((this.journalid == null && other.journalid != null) || (this.journalid != null && !this.journalid.equals(other.journalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.code+"-"+this.name;
    }

}
