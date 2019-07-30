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
 * @author adeveganet
 */
@Entity
@Table(name = "BILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findLastRefProviderRoot", query = "SELECT b FROM Bill b WHERE b.providerrootid= :providerRoot")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BILLID")
    private Integer documentid;
    @Size(max = 255)
    @Column(name = "PATH")
    private String path;
    //ref = "bill_"iduser+"_"+idtransaction
    @Size(max = 255)
    @Column(name = "REF")
    private String ref;
    //type 0:bill
    //1:order form
    @Column(name = "TYPEDOCUMENT")
    private Short typedocument;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    //paid 0:no    
    //paind 1:yes
    @Column(name = "PAID")
    private Short paid;
    //mode 0:cash
    //mode 1:check
    @Column(name = "MODE")
    private Short mode;
    @Size(max = 255)
    @Column(name = "BANK")
    private String bank;
    @Column(name = "CHECKDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkdate;
    @Column(name = "PAYMENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentdate;
    @Column(name = "AMOUNT")
    private Double amount;
    @JoinColumn(name = "TRANSACTION", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transaction;
    @JoinColumn(name = "PROVIDERROOTID", referencedColumnName = "PROVIDERROOTID")
    @ManyToOne
    private ProviderRoot providerrootid;
    public Bill() {
    }

    public Integer getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Integer documentid) {
        this.documentid = documentid;
    }

    public ProviderRoot getProviderrootid() {
        return providerrootid;
    }

    public void setProviderrootid(ProviderRoot providerrootid) {
        this.providerrootid = providerrootid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Short getTypedocument() {
        return typedocument;
    }

    public void setTypedocument(Short typedocument) {
        this.typedocument = typedocument;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Short getPaid() {
        return paid;
    }

    public void setPaid(Short paid) {
        this.paid = paid;
    }

    public Short getMode() {
        return mode;
    }

    public void setMode(Short mode) {
        this.mode = mode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
