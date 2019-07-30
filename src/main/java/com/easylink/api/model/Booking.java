/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingid", query = "SELECT b FROM Booking b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Booking.findByAddeddate", query = "SELECT b FROM Booking b WHERE b.addeddate = :addeddate"),
    @NamedQuery(name = "Booking.findByDocument", query = "SELECT b FROM Booking b WHERE b.document = :document"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKINGID")
    private Integer bookingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDEDDATE")
    private Integer addeddate;
    @Size(max = 255)
    @Column(name = "DOCUMENT")
    private String document;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Short status;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "ADHERENT", referencedColumnName = "USERID")
    @ManyToOne
    private User adherent;
    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User addedby;
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transactionid;
    @JoinColumn(name = "OFFERID", referencedColumnName = "OFFERID")
    @ManyToOne
    private Offer offerid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public User getAdherent() {
        return adherent;
    }

    public void setAdherent(User adherent) {
        this.adherent = adherent;
    }

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }

    public Transaction getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transaction transactionid) {
        this.transactionid = transactionid;
    }

    public Offer getOfferid() {
        return offerid;
    }

    public void setOfferid(Offer offerid) {
        this.offerid = offerid;
    }
    
    public Booking() {
    }

    public Booking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking(Integer bookingid, int addeddate, short status) {
        this.bookingid = bookingid;
        this.addeddate = addeddate;
        this.status = status;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public int getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(int addeddate) {
        this.addeddate = addeddate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.easylink.entities.Booking[ bookingid=" + bookingid + " ]";
    }
    
}
