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
 * @author ade
 */
@Entity
@Table(name = "NOTIFICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNotificationid", query = "SELECT n FROM Notification n WHERE n.notificationid = :notificationid"),
    @NamedQuery(name = "Notification.findByCreatedate", query = "SELECT n FROM Notification n WHERE n.createdate = :createdate"),
    @NamedQuery(name = "Notification.findByDescription", query = "SELECT n FROM Notification n WHERE n.description = :description"),
    @NamedQuery(name = "Notification.findByNotificationtype", query = "SELECT n FROM Notification n WHERE n.notificationtype = :notificationtype"),
    @NamedQuery(name = "Notification.findByStatus", query = "SELECT n FROM Notification n WHERE n.status = :status")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NOTIFICATIONID")
    private Integer notificationid;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NOTIFICATIONTYPE")
    private Short notificationtype;
    @Column(name = "STATUS")
    private Short status;
    @JoinColumn(name = "NTRANSACTION", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction ntransaction;
    @JoinColumn(name = "NRELATEDUSER", referencedColumnName = "USERID")
    @ManyToOne
    private User nrelateduser;
    @JoinColumn(name = "EVENT2", referencedColumnName = "EVENTID")
    @ManyToOne
    private Event event2;
    @JoinColumn(name = "CONVENTION2", referencedColumnName = "CONVETIONID")
    @ManyToOne
    private Convention convention2;

    @JoinColumn(name = "NCENTER", referencedColumnName = "CENTERID")
    @ManyToOne
    private Center ncenter;

    @OneToMany(mappedBy = "notification")
    private Collection<Globalnotification> globalnotificationCollection;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Notification() {
    }

    public Notification(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public Notification(Short notificationtype, Date createdate, String description, Short status, User nrelateduser, Transaction ntransaction, Amicale amicale) {
        this.notificationtype = notificationtype;
        this.createdate = createdate;
        this.description = description;
        this.status = status;
        this.nrelateduser = nrelateduser;
        this.ntransaction = ntransaction;
        this.amicaleid = amicale;
    }

    public Notification(Short notificationtype, Date createdate, String description, Short status, User nrelateduser, Convention nconvention, Event event2, Amicale amicale) {
        this.notificationtype = notificationtype;
        this.createdate = createdate;
        this.description = description;
        this.status = status;
        this.nrelateduser = nrelateduser;
        this.convention2 = nconvention;
        this.event2 = event2;
        this.amicaleid = amicale;
    }

    public Notification(Date createdate, String description, Short notificationtype, Short status, User nrelateduser, Event event2, Center ncenter, Amicale amicaleid) {
        this.createdate = createdate;
        this.description = description;
        this.notificationtype = notificationtype;
        this.status = status;
        this.nrelateduser = nrelateduser;
        this.event2 = event2;
        this.ncenter = ncenter;
        this.amicaleid = amicaleid;
    }
        public Notification(Date createdate, String description, Short notificationtype, Short status, User nrelateduser, Convention convention, Center ncenter, Amicale amicaleid) {
        this.createdate = createdate;
        this.description = description;
        this.notificationtype = notificationtype;
        this.status = status;
        this.nrelateduser = nrelateduser;
        this.convention2 = convention;
        this.ncenter = ncenter;
        this.amicaleid = amicaleid;
    }
    

    public Integer getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getNotificationtype() {
        return notificationtype;
    }

    public void setNotificationtype(Short notificationtype) {
        this.notificationtype = notificationtype;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Transaction getNtransaction() {
        return ntransaction;
    }

    public void setNtransaction(Transaction ntransaction) {
        this.ntransaction = ntransaction;
    }

    public User getNrelateduser() {
        return nrelateduser;
    }

    public void setNrelateduser(User nrelateduser) {
        this.nrelateduser = nrelateduser;
    }


    public Convention getNconvetion() {
        return convention2;
    }

    public void setNconvetion(Convention nconvetion) {
        this.convention2 = nconvetion;
    }

    public Center getNcenter() {
        return ncenter;
    }

    public void setNcenter(Center ncenter) {
        this.ncenter = ncenter;
    }

    public Event getEvent2() {
        return event2;
    }

    public void setEvent2(Event event2) {
        this.event2 = event2;
    }

    public Convention getConvention2() {
        return convention2;
    }

    public void setConvention2(Convention convention2) {
        this.convention2 = convention2;
    }

    @XmlTransient
    public Collection<Globalnotification> getGlobalnotificationCollection() {
        return globalnotificationCollection;
    }

    public void setGlobalnotificationCollection(Collection<Globalnotification> globalnotificationCollection) {
        this.globalnotificationCollection = globalnotificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationid != null ? notificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationid == null && other.notificationid != null) || (this.notificationid != null && !this.notificationid.equals(other.notificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veganet.vegarh.entities2.Notification[ notificationid=" + notificationid + " ]";
    }

}
