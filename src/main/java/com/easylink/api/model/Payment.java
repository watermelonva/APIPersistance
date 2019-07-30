/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid"),
    @NamedQuery(name = "Payment.findByType", query = "SELECT p FROM Payment p WHERE p.type = :type"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByStatus", query = "SELECT p FROM Payment p WHERE p.status = :status"),
    @NamedQuery(name = "Payment.findByEcheance", query = "SELECT p FROM Payment p WHERE p.echeance = :echeance"),
    @NamedQuery(name = "Payment.findByReference", query = "SELECT p FROM Payment p WHERE p.reference = :reference"),
    @NamedQuery(name = "Payment.findByAddeddate", query = "SELECT p FROM Payment p WHERE p.addeddate = :addeddate"),
    @NamedQuery(name = "Payment.findBySens", query = "SELECT p FROM Payment p WHERE p.sens = :sens"),
    @NamedQuery(name = "Payment.findByComptabilise", query = "SELECT p FROM Payment p WHERE p.posted = :posted"),
    @NamedQuery(name = "Payment.findByIsdeleted", query = "SELECT p FROM Payment p WHERE p.isdeleted = :isdeleted"),
    @NamedQuery(name = "Payment.findByEndPayment", query = "SELECT p FROM Payment p WHERE p.providerid = :providerid AND p.adherent = :adherent ORDER BY p.datePayment DESC"),
    @NamedQuery(name = "Payment.findByDateProviderUser", query = "SELECT p FROM Payment p WHERE p.datePayment >=:trancheDateStart AND p.datePayment <=:trancheDateEnd AND p.providerid = :providerid AND p.adherent.cnprs = :adherentCnprs ORDER BY p.datePayment DESC"),
    @NamedQuery(name = "Payment.findByFixDateProviderUser", query = "SELECT p FROM Payment p WHERE p.datePayment = cast(:trancheDateStart AS date) AND p.providerid = :providerid AND p.adherent.cnprs = :adherentCnprs ORDER BY p.datePayment DESC"),
    @NamedQuery(name = "Payment.updateEcheance", query = "UPDATE Payment p SET p.echeance = :echeance WHERE p.providerid = :providerid AND p.adherent.cnprs = :adherentCnprs"),
    @NamedQuery(name = "Payment.somByDateProviderUser", query = " SELECT SUM(p.amountel) FROM Payment p WHERE p.datePayment >=:trancheDateStart AND p.datePayment <=:trancheDateEnd AND p.adherent.cnprs = :adherentCnprs"),
    @NamedQuery(name = "Payment.deleteByDateProvider", query = "DELETE  FROM Payment p WHERE p.addeddate >=:trancheDateStart AND p.addeddate <=:trancheDateEnd AND p.providerid = :providerid"),

    @NamedQuery(name = "Payment.findByDeleteddate", query = "SELECT p FROM Payment p WHERE p.deleteddate = :deleteddate")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAYMENTID")
    private Integer paymentid;
    @Size(max = 8)
    @Column(name = "TYPE")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT" , scale = 3)
    private Double amount;
    @Column(name = "NOTIMPUTED", scale = 3)
    private Double notimputed;
    @Column(name = "POSTED")
    private Short posted;
    @Column(name = "RAS")
    private Short ras;
    @Column(name = "RASVALUE")
    private Double rasValue;
    @JoinColumn(name = "JOURNALID", referencedColumnName = "JOURNALID")
    @ManyToOne
    private Journal journalid;
    @JoinColumn(name = "DESTINATIONJOURNALID", referencedColumnName = "JOURNALID")
    @ManyToOne
    private Journal destjournalid;
    @Column(name = "DATEBANK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datebank;
    @JoinColumn(name = "HANDFREEID", referencedColumnName = "HANDFREEID")
    @ManyToOne
    private HandFree handfreeid;

    public HandFree getHandfreeid() {
        return handfreeid;
    }

    public void setHandfreeid(HandFree handfreeid) {
        this.handfreeid = handfreeid;
    }
    
    

    public Date getDatebank() {
        return datebank;
    }

    public void setDatebank(Date datebank) {
        this.datebank = datebank;
    }
    
    

    public Journal getDestjournalid() {
        return destjournalid;
    }

    public void setDestjournalid(Journal destjournalid) {
        this.destjournalid = destjournalid;
    }

    public Journal getJournalid() {
        return journalid;
    }

    public void setJournalid(Journal journalid) {
        this.journalid = journalid;
    }
    
    

    public Short getPosted() {
        return posted;
    }

    public void setPosted(Short posted) {
        this.posted = posted;
    }

    public Short getRas() {
        return ras;
    }

    public void setRas(Short ras) {
        this.ras = ras;
    }

    public Double getRasValue() {
        return rasValue;
    }

    public void setRasValue(Double rasValue) {
        this.rasValue = rasValue;
    }
    
    
//    @Lob
//    @Size(max = 65535)
//    @Column(name = "CAUSE")
//    private String cause;

    public Double getNotimputed() {
        return notimputed;
    }

    public void setNotimputed(Double notimputed) {
        this.notimputed = notimputed;
    }
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ECHEANCE")
    @Temporal(TemporalType.DATE)
    private Date echeance;
    @Size(max = 100)
    @Column(name = "REFERENCE")
    private String reference;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Size(max = 3)
    @Column(name = "SENS")
    private String sens;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @OneToMany(mappedBy = "paymentid")
    private Collection<Comptimputation> comptimputationCollection;
    @JoinColumn(name = "EXTERNALBANKID", referencedColumnName = "BANKID")
    @ManyToOne
    private Bank externalbankid;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;
    @JoinColumn(name = "ADHERENT", referencedColumnName = "USERID")
    @ManyToOne
    private User adherent;
    @JoinColumn(name = "PROVIDERID", referencedColumnName = "PROVIDERID")
    @ManyToOne
    private Provider providerid;
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transactionid;
    @Column(name = "ISAID")
    private Short isaid;

    //C.S.S
    @Column(name = "DATEPAYMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePayment;
    @Column(name = "AMOUNTEL" , scale = 3)
    private Double amountel;
    @Column(name = "AMOUNTCNI" , scale = 3)
    private Double amountcni;
    @Column(name = "PAYMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date paymentdate;
    @OneToMany(mappedBy = "paymentid")
    private Collection<AccountMoveLine> amlCollection;

    public Collection<AccountMoveLine> getAmlCollection() {
        return amlCollection;
    }

    public void setAmlCollection(Collection<AccountMoveLine> amlCollection) {
        this.amlCollection = amlCollection;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }
    
    

    public Short getIsaid() {
        return isaid;
    }

    public void setIsaid(Short isaid) {
        this.isaid = isaid;
    }

//    public String getCause() {
//        return cause;
//    }
//
//    public void setCause(String cause) {
//        this.cause = cause;
//    }
    public Transaction getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transaction transactionid) {
        this.transactionid = transactionid;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public User getAdherent() {
        return adherent;
    }

    public void setAdherent(User adherent) {
        this.adherent = adherent;
    }

    public Payment() {
    }

    public Payment(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    public Double getAmountel() {
        return amountel;
    }

    public void setAmountel(Double amountel) {
        this.amountel = amountel;
    }

    public Double getAmountcni() {
        return amountcni;
    }

    public void setAmountcni(Double amountcni) {
        this.amountcni = amountcni;
    }

    @XmlTransient
    public Collection<Comptimputation> getComptimputationCollection() {
        return comptimputationCollection;
    }

    public void setComptimputationCollection(Collection<Comptimputation> comptimputationCollection) {
        this.comptimputationCollection = comptimputationCollection;
    }

    public Bank getExternalbankid() {
        return externalbankid;
    }

    public void setExternalbankid(Bank externalbankid) {
        this.externalbankid = externalbankid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Payment[ paymentid=" + paymentid + " ]";
    }

}
