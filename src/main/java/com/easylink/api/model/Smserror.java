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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel Trimeche
 */
@Entity
@Table(name = "SMSERROR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smserror.findAll", query = "SELECT s FROM Smserror s"),
    @NamedQuery(name = "Smserror.findBySmserrorid", query = "SELECT s FROM Smserror s WHERE s.smserrorid = :smserrorid"),
    @NamedQuery(name = "Smserror.findByTel", query = "SELECT s FROM Smserror s WHERE s.tel = :tel"),
    @NamedQuery(name = "Smserror.findByMsg", query = "SELECT s FROM Smserror s WHERE s.msg = :msg"),
    @NamedQuery(name = "Smserror.findByRet", query = "SELECT s FROM Smserror s WHERE s.ret = :ret"),
    @NamedQuery(name = "Smserror.findBySentdate", query = "SELECT s FROM Smserror s WHERE s.sentdate = :sentdate"),
    @NamedQuery(name = "Smserror.findByDescription", query = "SELECT s FROM Smserror s WHERE s.description = :description")})
public class Smserror implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SMSERRORID")
    private Integer smserrorid;
    @Size(min = 0, max = 20)
    @Column(name = "TEL")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MSG")
    private String msg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RET")
    private int ret;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentdate;
    @Size(min = 0, max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "AMICALEID", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "MESSAGEID", referencedColumnName = "MESSAGEID")
    @ManyToOne
    private Message messageid;

    public Message getMessageid() {
        return messageid;
    }

    public void setMessageid(Message messageid) {
        this.messageid = messageid;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Smserror() {
    }

    public Smserror(Integer smserrorid) {
        this.smserrorid = smserrorid;
    }

    public Smserror(Integer smserrorid, String tel, String msg, int ret, Date sentdate, String description) {
        this.smserrorid = smserrorid;
        this.tel = tel;
        this.msg = msg;
        this.ret = ret;
        this.sentdate = sentdate;
        this.description = description;
    }

    public Integer getSmserrorid() {
        return smserrorid;
    }

    public void setSmserrorid(Integer smserrorid) {
        this.smserrorid = smserrorid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Date getSentdate() {
        return sentdate;
    }

    public void setSentdate(Date sentdate) {
        this.sentdate = sentdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smserrorid != null ? smserrorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smserror)) {
            return false;
        }
        Smserror other = (Smserror) object;
        if ((this.smserrorid == null && other.smserrorid != null) || (this.smserrorid != null && !this.smserrorid.equals(other.smserrorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Smserror[ smserrorid=" + smserrorid + " ]";
    }

}
