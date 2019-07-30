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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "COMMAND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Command.findAll", query = "SELECT c FROM Command c"),
    @NamedQuery(name = "Command.findByCommandid", query = "SELECT c FROM Command c WHERE c.commandid = :commandid"),
    @NamedQuery(name = "Command.findByQuantity", query = "SELECT c FROM Command c WHERE c.quantitybooks = :quantitybooks"),
    @NamedQuery(name = "Command.findByTotalamount", query = "SELECT c FROM Command c WHERE c.totalamount = :totalamount"),
    @NamedQuery(name = "Command.findByParticipantamount", query = "SELECT c FROM Command c WHERE c.participantamount = :participantamount"),
    @NamedQuery(name = "Command.findByCurrent", query = "SELECT c FROM Command c WHERE c.currentc = :currentc AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Command.findByPayedStatus", query = "SELECT c FROM Command c WHERE c.payedstatus < :payedstatus AND (c.status = 2 OR c.status=3 ) AND c.amicaleid = :amicale ORDER BY c.restamount ASC "),
    @NamedQuery(name = "Command.findRestQuantity", query = "SELECT SUM(c.resttickets) FROM Command c WHERE c.resttickets != 0 AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Command.resetRest", query = "UPDATE   Command c SET c.resttickets=0 WHERE c.amicaleid = :amicale"),
    @NamedQuery(name = "Command.findByDate", query = "SELECT c FROM Command c WHERE c.todate > :from AND c.todate < :to AND c.amicaleid = :amicale"),
    @NamedQuery(name = "Command.findByStatus", query = "SELECT c FROM Command c WHERE c.status = :status AND c.amicaleid = :amicale")})
public class Command implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITYTICKETS")
    private Integer quantitytickets;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAYEDSTATUS")
    private Short payedstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESTAMOUNT")
    private Double restamount;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMANDID")
    private Integer commandid;
    @Column(name = "TITLE")
    private String title;

    @Column(name = "FROMDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Column(name = "TODATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date todate;

    @Column(name = "FORDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fordate;

    @Column(name = "QUANTITYBOOKS")
    private Integer quantitybooks;
    @Column(name = "RESTTICKETS")
    private Integer resttickets;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "DISTRIBUTIONQUANTITY")
    private Integer distributionquantity;
    @Column(name = "TOTALAMOUNT")
    private Double totalamount;
    @Column(name = "PARTICIPANTAMOUNT")
    private Double participantamount;
    @Column(name = "STATUS")
    private Short status;
    @Lob
    @Size(max = 65535)
    @Column(name = "INFO")
    private String info;
    @JoinColumn(name = "BUDGET", referencedColumnName = "BUDGETID")
    @ManyToOne
    private Budget budget;
    @Column(name = "CURRENTC")
    private Short currentc;

    @Column(name = "NUMBL")
    private String numbl;
    @Column(name = "NUMFACTURE")
    private String numfacture;
    @Column(name = "PATHBL")
    private String pathbl;
    @Column(name = "PATHFACTURE")
    private String pathfacture;

    @Column(name = "PATHCOMMAND")
    private String pathcommand;
    @Column(name = "PATHUSERS")
    private String pathusers;

    @OneToMany(mappedBy = "commandid")
    private Collection<Mealtransaction> mealtransactionCollection;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User createdby;
    @OneToMany(mappedBy = "commandid")
    private Collection<Book> bookCollection;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void addBook(Book book) {
        this.bookCollection.add(book);
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Command() {
    }

    public Command(Integer commandid) {
        this.commandid = commandid;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public Integer getDistributionquantity() {
        return distributionquantity;
    }

    public void setDistributionquantity(Integer distributionquantity) {
        this.distributionquantity = distributionquantity;
    }


    public User getCreatedby() {
        return createdby;
    }

    public Date getFordate() {
        return fordate;
    }

    public void setFordate(Date fordate) {
        this.fordate = fordate;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    @XmlTransient
    public Collection<Mealtransaction> getMealtransactionCollection() {
        return mealtransactionCollection;
    }

    public void setMealtransactionCollection(Collection<Mealtransaction> mealtransactionCollection) {
        this.mealtransactionCollection = mealtransactionCollection;
    }

    public Integer getCommandid() {
        return commandid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCommandid(Integer commandid) {
        this.commandid = commandid;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Integer getQuantitybooks() {
        return quantitybooks;
    }

    public void setQuantitybooks(Integer quantitybooks) {
        this.quantitybooks = quantitybooks;
    }


    public Integer getResttickets() {
        return resttickets;
    }

    public void setResttickets(Integer resttickets) {
        this.resttickets = resttickets;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Double getParticipantamount() {
        return participantamount;
    }

    public void setParticipantamount(Double participantamount) {
        this.participantamount = participantamount;
    }


    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Short getCurrentc() {
        return currentc;
    }

    public void setCurrentc(Short currentc) {
        this.currentc = currentc;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNumbl() {
        return numbl;
    }

    public void setNumbl(String numbl) {
        this.numbl = numbl;
    }

    public String getNumfacture() {
        return numfacture;
    }

    public void setNumfacture(String numfacture) {
        this.numfacture = numfacture;
    }

    public String getPathbl() {
        return pathbl;
    }

    public void setPathbl(String pathbl) {
        this.pathbl = pathbl;
    }

    public String getPathfacture() {
        return pathfacture;
    }

    public void setPathfacture(String pathfacture) {
        this.pathfacture = pathfacture;
    }

    public String getPathcommand() {
        return pathcommand;
    }

    public void setPathcommand(String pathcommand) {
        this.pathcommand = pathcommand;
    }

    public String getPathusers() {
        return pathusers;
    }

    public void setPathusers(String pathusers) {
        this.pathusers = pathusers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandid != null ? commandid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Command)) {
            return false;
        }
        Command other = (Command) object;
        if ((this.commandid == null && other.commandid != null) || (this.commandid != null && !this.commandid.equals(other.commandid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }

    public int getQuantitytickets() {
        return quantitytickets;
    }

    public void setQuantitytickets(int quantitytickets) {
        this.quantitytickets = quantitytickets;
    }

    public short getPayedstatus() {
        return payedstatus;
    }

    public void setPayedstatus(short payedstatus) {
        this.payedstatus = payedstatus;
    }

    public double getRestamount() {
        return restamount;
    }

    public void setRestamount(double restamount) {
        this.restamount = restamount;
    }

}
