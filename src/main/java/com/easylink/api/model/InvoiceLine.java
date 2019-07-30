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
@Table(name = "INVOICE_LINE")
@XmlRootElement
public class InvoiceLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INVOICELINEID")
    private Integer invoiceLineId;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "INVOICEID")
    @ManyToOne
    private Invoice invoiceid;
    @Size(max = 1000)
    @Column(name = "PRODUCT")
    @Basic(optional = false)
    private String product;
    @Column(name = "QUANTITY", scale = 3)
    private Double quantity;
    @Column(name = "UNITPRICE", scale = 3)
    private Double unitPrice;
    @Column(name = "TOTALHT", scale = 3)
    private Double totalHt;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
    @ManyToOne
    private Account accountId;
    @JoinColumn(name = "VATID", referencedColumnName = "VATID")
    @ManyToOne
    private Vat vatId;

    public Integer getInvoiceLineId() {
        return invoiceLineId;
    }

    public void setInvoiceLineId(Integer invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public Invoice getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Invoice invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(Double totalHt) {
        this.totalHt = totalHt;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Vat getVatId() {
        return vatId;
    }

    public void setVatId(Vat vatId) {
        this.vatId = vatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceLineId != null ? invoiceLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLine)) {
            return false;
        }
        InvoiceLine other = (InvoiceLine) object;
        if ((this.invoiceLineId == null && other.invoiceLineId != null) || (this.invoiceLineId != null && !this.invoiceLineId.equals(other.invoiceLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.AccountChart[ id=" + invoiceLineId + " ]";
    }

}
