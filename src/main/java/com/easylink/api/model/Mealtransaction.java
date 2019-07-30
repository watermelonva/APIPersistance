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
@Table(name = "MEALTRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mealtransaction.findAll", query = "SELECT m FROM Mealtransaction m"),
    @NamedQuery(name = "Mealtransaction.findByMealtransactionid", query = "SELECT m FROM Mealtransaction m WHERE m.mealtransactionid = :mealtransactionid"),
    @NamedQuery(name = "Mealtransaction.findByDate", query = "SELECT m FROM Mealtransaction m WHERE m.date = :date"),
    @NamedQuery(name = "Mealtransaction.findByPayedamount", query = "SELECT m FROM Mealtransaction m WHERE m.payedamount = :payedamount"),
    @NamedQuery(name = "Mealtransaction.findRestAmount", query = "SELECT  SUM(m.restamount) FROM Mealtransaction m WHERE m.payedamount != 0 AND m.userid = :userid AND m.userid.amicaleid = :amicale"),
    @NamedQuery(name = "Mealtransaction.findMealUserCommand", query = "SELECT m FROM Mealtransaction m WHERE m.userid = :userid AND m.commandid = :commandid AND m.userid.amicaleid = :amicale"),
    @NamedQuery(name = "Mealtransaction.CashRegister", query = "SELECT SUM(m.payedamount) FROM Mealtransaction m WHERE m.commandid = :commandid"),

//        @NamedQuery(name = "Mealtransaction.findTotalPaymentAmount", query = "SELECT m FROM Mealtransaction m WHERE m.commandid = :"),
    @NamedQuery(name = "Mealtransaction.resetRestAmountByUser", query = "UPDATE Mealtransaction m SET m.restamount =0 WHERE m.userid = :userid AND m.userid.amicaleid = :amicale"),

    @NamedQuery(name = "Mealtransaction.findByRestamount", query = "SELECT m FROM Mealtransaction m WHERE m.restamount = :restamount")})
public class Mealtransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEALTRANSACTIONID")
    private Integer mealtransactionid;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYEDAMOUNT")
    private Double payedamount;
    @Column(name = "RESTAMOUNT")
    private Double restamount;
    @Size(max = 255)
    @Column(name = "PATHRECEIVEDOCUMENT")
    private String pathreceivedocument;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private User userid;
    @JoinColumn(name = "COMMANDID", referencedColumnName = "COMMANDID")
    @ManyToOne
    private Command commandid;

    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User createdby;

    @JoinColumn(name = "DELIVEREDTO", referencedColumnName = "USERID")
    @ManyToOne
    private User deliveredto;
    @Column(name="DELIVERED")
    private Short delivered;
    @JoinColumn(name = "BOOKID", referencedColumnName = "BOOKID")
    @ManyToOne
    private Book bookid;

    public Book getBookid() {
        return bookid;
    }

    public void setBookid(Book bookid) {
        this.bookid = bookid;
    }
    
    

    public Short getDelivered() {
        return delivered;
    }

    public void setDelivered(Short delivered) {
        this.delivered = delivered;
    }

    public Mealtransaction() {
    }

    public Mealtransaction(Integer mealtransactionid) {
        this.mealtransactionid = mealtransactionid;
    }

    public Integer getMealtransactionid() {
        return mealtransactionid;
    }

    public void setMealtransactionid(Integer mealtransactionid) {
        this.mealtransactionid = mealtransactionid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPayedamount() {
        return payedamount;
    }

    public void setPayedamount(Double payedamount) {
        this.payedamount = payedamount;
    }

    public Double getRestamount() {
        return restamount;
    }

    public void setRestamount(Double restamount) {
        this.restamount = restamount;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Command getCommandid() {
        return commandid;
    }

    public void setCommandid(Command commandid) {
        this.commandid = commandid;
    }

    public String getPathreceivedocument() {
        return pathreceivedocument;
    }

    public void setPathreceivedocument(String pathreceivedocument) {
        this.pathreceivedocument = pathreceivedocument;
    }

    public User getDeliveredto() {
        return deliveredto;
    }

    public void setDeliveredto(User deliveredto) {
        this.deliveredto = deliveredto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealtransactionid != null ? mealtransactionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mealtransaction)) {
            return false;
        }
        Mealtransaction other = (Mealtransaction) object;
        if ((this.mealtransactionid == null && other.mealtransactionid != null) || (this.mealtransactionid != null && !this.mealtransactionid.equals(other.mealtransactionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Mealtransaction[ mealtransactionid=" + mealtransactionid + " ]";
    }

}
