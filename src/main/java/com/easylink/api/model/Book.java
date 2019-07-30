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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookid", query = "SELECT b FROM Book b WHERE b.bookid = :bookid AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title AND b.amicaleid = :amicale"),
    @NamedQuery(name = "Book.findByQuantity", query = "UPDATE Book b SET b.restquantity=0 WHERE b.amicaleid = :amicale"),
    @NamedQuery(name = "Book.findRestQuantityByTitle", query = "SELECT SUM(b.restquantity) FROM Book b WHERE b.restquantity != 0 AND b.title LIKE :title AND b.amicaleid = :amicale")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKID")
    private Integer bookid;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "RESTQUANTITY")
    private Integer restquantity;
    @Column(name = "DISTRIBUTIONQUANTITY")
    private Integer distributionquantity;
    @JoinColumn(name = "COMMANDID", referencedColumnName = "COMMANDID")
    @ManyToOne
    private Command commandid;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @OneToMany(mappedBy = "bookid")
    private Collection<Mealtransaction> mealCollection;

    public Book() {
    }

    public Book(Integer bookid) {
        this.bookid = bookid;
    }

    public Command getCommandid() {
        return commandid;
    }

    public void setCommandid(Command commandid) {
        this.commandid = commandid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRestquantity() {
        return restquantity;
    }

    public void setRestquantity(Integer restquantity) {
        this.restquantity = restquantity;
    }

    public Integer getDistributionquantity() {
        return distributionquantity;
    }

    public void setDistributionquantity(Integer distributionquantity) {
        this.distributionquantity = distributionquantity;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookid != null ? bookid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookid == null && other.bookid != null) || (this.bookid != null && !this.bookid.equals(other.bookid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Book[ bookid=" + bookid + " ]";
    }

}
