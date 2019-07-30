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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "CLAIM")
@XmlRootElement
public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLAIMID")
    private Integer claimid;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "REPLY")
    private String reply;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "TYPE")
    private Short type;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "NRELATEDUSER2", referencedColumnName = "USERID")
    @ManyToOne
    private User nrelateduser2;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Claim() {
    }

    public Claim(String description, String reply, Short status, Short type, Date date, User nrelateduser2) {
        this.description = description;
        this.reply = reply;
        this.status = status;
        this.type = type;
        this.date = date;
        this.nrelateduser2 = nrelateduser2;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    
    public Integer getClaimid() {
        return claimid;
    }

    public void setClaimid(Integer claimid) {
        this.claimid = claimid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getNrelateduser2() {
        return nrelateduser2;
    }

    public void setNrelateduser2(User nrelateduser2) {
        this.nrelateduser2 = nrelateduser2;
    }

}
