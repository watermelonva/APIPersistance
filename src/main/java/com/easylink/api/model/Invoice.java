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
@Table(name = "INVOICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceid", query = "SELECT i FROM Invoice i WHERE i.invoiceid = :invoiceid"),
    @NamedQuery(name = "Invoice.findByReference", query = "SELECT i FROM Invoice i WHERE i.reference = :reference"),
    @NamedQuery(name = "Invoice.findByEcheance", query = "SELECT i FROM Invoice i WHERE i.echeance = :echeance"),
    @NamedQuery(name = "Invoice.findByTotalht", query = "SELECT i FROM Invoice i WHERE i.totalht = :totalht"),
    @NamedQuery(name = "Invoice.findByTotalttc", query = "SELECT i FROM Invoice i WHERE i.totalttc = :totalttc"),
    @NamedQuery(name = "Invoice.findByPaidamount", query = "SELECT i FROM Invoice i WHERE i.paidamount = :paidamount"),
    @NamedQuery(name = "Invoice.findBySens", query = "SELECT i FROM Invoice i WHERE i.sens = :sens"),
    @NamedQuery(name = "Invoice.findByName", query = "SELECT i FROM Invoice i WHERE i.name = :name"),
    @NamedQuery(name = "Invoice.findByFile", query = "SELECT i FROM Invoice i WHERE i.file = :file"),
    @NamedQuery(name = "Invoice.findByDescription", query = "SELECT i FROM Invoice i WHERE i.description = :description"),
    @NamedQuery(name = "Invoice.findByStatus", query = "SELECT i FROM Invoice i WHERE i.status = :status"),
    @NamedQuery(name = "Invoice.findByIsdeleted", query = "SELECT i FROM Invoice i WHERE i.isdeleted = :isdeleted"),
    @NamedQuery(name = "Invoice.findByDeleteddate", query = "SELECT i FROM Invoice i WHERE i.deleteddate = :deleteddate"),
    @NamedQuery(name = "Invoice.findByAddeddate", query = "SELECT i FROM Invoice i WHERE i.addeddate = :addeddate")})
public class Invoice implements Serializable {
 

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private Integer invoiceid;
    @Size(max = 100)
    @Column(name = "REFERENCE")
    private String reference;
    @Column(name = "ECHEANCE")
    @Temporal(TemporalType.DATE)
    private Date echeance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALHT")
    private Double totalht;
    @Column(name = "TOTALTTC")
    private Double totalttc;
    @Column(name = "PAIDAMOUNT")
    private Double paidamount;
    @Size(max = 3)
    @Column(name = "SENS")
    private String sens;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "FILE")
    private String file;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 3)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @OneToMany(mappedBy = "invoiceid")
    private Collection<Comptimputation> comptimputationCollection;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;
    @JoinColumn(name = "PROVIDERID", referencedColumnName = "PROVIDERID")
    @ManyToOne
    private Provider providerid;
    @Column(name = "POSTED")
    private Short posted;

    public Short getPosted() {
        return posted;
    }

    public void setPosted(Short posted) {
        this.posted = posted;
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

    public Invoice() {
    }

    public Invoice(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Double getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(Double totalttc) {
        this.totalttc = totalttc;
    }

    public Double getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(Double paidamount) {
        this.paidamount = paidamount;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    @XmlTransient
    public Collection<Comptimputation> getComptimputationCollection() {
        return comptimputationCollection;
    }

    public void setComptimputationCollection(Collection<Comptimputation> comptimputationCollection) {
        this.comptimputationCollection = comptimputationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Invoice[ invoiceid=" + invoiceid + " ]";
    }

 
    
}
