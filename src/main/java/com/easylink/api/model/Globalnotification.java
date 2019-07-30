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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "GLOBALNOTIFICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Globalnotification.findAll", query = "SELECT g FROM Globalnotification g"),
    @NamedQuery(name = "Globalnotification.findByUserAndNotification", query = "SELECT g FROM Globalnotification g WHERE g.notification = :notification  AND g.user = :user AND g.amicaleid = :amicale"),
    @NamedQuery(name = "Globalnotification.findByUserAndMessage", query = "SELECT g FROM Globalnotification g WHERE g.message = :message  AND g.user = :user AND g.amicaleid = :amicale"),
    @NamedQuery(name = "Globalnotification.findByGlobalnotificationid", query = "SELECT g FROM Globalnotification g WHERE g.globalnotificationid = :globalnotificationid AND g.amicaleid = :amicale")
})
public class Globalnotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GLOBALNOTIFICATIONID")
    private Integer globalnotificationid;
    @JoinColumn(name = "NOTIFICATION", referencedColumnName = "NOTIFICATIONID")
    @ManyToOne
    private Notification notification;
    @JoinColumn(name = "MESSAGE", referencedColumnName = "MESSAGEID")
    @ManyToOne
    private Message message;
    @JoinColumn(name = "USER", referencedColumnName = "USERID")
    @ManyToOne
    private User user;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Globalnotification() {
    }

    public Globalnotification(Notification notification, User user,Amicale amicale) {
        this.notification = notification;
        this.user = user;
              this.amicaleid=amicale;
    }

    public Globalnotification(Message message, User user,Amicale amicale) {
        this.message = message;
        this.user = user;
        this.amicaleid=amicale;
    }

    public Globalnotification(Integer globalnotificationid) {
        this.globalnotificationid = globalnotificationid;
    }

    public Integer getGlobalnotificationid() {
        return globalnotificationid;
    }

    public void setGlobalnotificationid(Integer globalnotificationid) {
        this.globalnotificationid = globalnotificationid;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globalnotificationid != null ? globalnotificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Globalnotification)) {
            return false;
        }
        Globalnotification other = (Globalnotification) object;
        if ((this.globalnotificationid == null && other.globalnotificationid != null) || (this.globalnotificationid != null && !this.globalnotificationid.equals(other.globalnotificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.vegarh.entities2.Globalnotification[ globalnotificationid=" + globalnotificationid + " ]";
    }

}
