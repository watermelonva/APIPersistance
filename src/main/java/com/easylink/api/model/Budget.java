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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "BUDGET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"),
    @NamedQuery(name = "Budget.updateAllCurrentFalse", query = "UPDATE Budget b SET b.current=0 WHERE b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByBudgetid", query = "SELECT b FROM Budget b WHERE b.budgetid = :budgetid AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByEntitled", query = "SELECT b FROM Budget b WHERE b.entitled = :entitled AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByFromdate", query = "SELECT b FROM Budget b WHERE b.fromdate = :fromdate AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByTodate", query = "SELECT b FROM Budget b WHERE b.todate = :todate AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByCurrent", query = "SELECT b FROM Budget b WHERE b.current = :current AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByTotalamount", query = "SELECT b FROM Budget b WHERE b.totalamount = :totalamount AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByResidualamount", query = "SELECT b FROM Budget b WHERE b.residualamount = :residualamount AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.selectReportedBudget", query = "SELECT b FROM Budget b WHERE b.reportedamount != 0 AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Budget.findByClosing", query = "SELECT b FROM Budget b WHERE b.closing = :closing AND b.amicaleid = :amicale")})
public class Budget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BUDGETID")
    private Integer budgetid;
    @Size(max = 255)
    @Column(name = "ENTITLED")
    private String entitled;
    @Column(name = "FROMDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Column(name = "TODATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date todate;
    @Size(max = 255)
    @Column(name = "AVAILABLEMONTHS")
    private String availablemonths;
    @Column(name = "CURRENTB")
    private Short current;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALAMOUNT")
    private Double totalamount;
    @Column(name = "RESIDUALAMOUNT")
    private Double residualamount;
    @Column(name = "REPORTAMOUNT")
    private Double reportedamount;
    @OneToMany(mappedBy = "budgetid")
    private Collection<Complement> complementCollection;

    @OneToMany(mappedBy = "budget")
    private Collection<Command> commandCollection;
    @Column(name = "CLOSING")
    private Short closing;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }
    
    @XmlTransient
    public Collection<Command> getCommandCollection() {
        return commandCollection;
    }

    public void setCommandCollection(Collection<Command> commandCollection) {
        this.commandCollection = commandCollection;
    }

    public Budget() {
    }

    public Budget(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public Integer getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
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

    public String getAvailablemonths() {
        return availablemonths;
    }

    public void setAvailablemonths(String availablemonths) {
        this.availablemonths = availablemonths;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Double getResidualamount() {
        return residualamount;
    }

    public void setResidualamount(Double residualamount) {
        this.residualamount = residualamount;
    }

    public Short getCurrent() {
        return current;
    }

    public void setCurrent(Short current) {
        this.current = current;
    }

    public Double getReportedamount() {
        return reportedamount;
    }

    public void setReportedamount(Double reportedamount) {
        this.reportedamount = reportedamount;
    }

    @XmlTransient
    public Collection<Complement> getComplementCollection() {
        return complementCollection;
    }

    public void setComplementCollection(Collection<Complement> complementCollection) {
        this.complementCollection = complementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetid != null ? budgetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.budgetid == null && other.budgetid != null) || (this.budgetid != null && !this.budgetid.equals(other.budgetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Budget[ budgetid=" + budgetid + " ]";
    }

    public Short getClosing() {
        return closing;
    }

    public void setClosing(Short closing) {
        this.closing = closing;
    }

}
