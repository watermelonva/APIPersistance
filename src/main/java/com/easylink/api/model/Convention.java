/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "CONVENTION")
@XmlRootElement


public class Convention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONVETIONID")
    private Integer convetionid;
    @Size(max = 100)
    @Column(name = "TITLECONVENTION")
    private String titleconvention;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "PHONERESPONSIBLE")
    private String phoneresponsible;
    @Column(name = "TYPE")
    private Short type;
    @Size(max = 50)
    @Column(name = "DETAILCONV")
    private String detailconv;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALPRICE")
    private Double totalprice;
    @Column(name = "ADVANCEAMOUNT")
    private Double advanceamount;
    @Column(name = "MINAMOUNTMONTHS")
    private Double minamountmonths;
    @Column(name = "MAXMONTHES")
    private Integer maxmonthes;
    @Column(name = "AMOUNTCONVENTION")
    private Double amountconvention;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
//    @Column(name = "PAYMENTBEFOREDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date paymentbeforedate;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "NBRPERSON")
    private Integer nbrperson;
    @Column(name = "NBRFAMILY")
    private Integer nbrfamily;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "VALID")
    private Short valid;
    @Column(name = "WITHCOMMITMENT")
    private Short withcommitment;
    @Column(name = "PAYSLIP")
    private Short paySlip;
    @Column(name = "CESSIONDOCUMENT")
    private Boolean cessiondocument;
    @JoinColumn(name = "PROVIDER", referencedColumnName = "PROVIDERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Provider provider;
    @OneToMany(mappedBy = "needconvention", fetch = FetchType.LAZY)
    private Collection<Convention> conventionCollection;
    @JoinColumn(name = "NEEDCONVENTION", referencedColumnName = "CONVETIONID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Convention needconvention;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User createdby;
    @OneToMany(mappedBy = "convention", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection;

    @Column(name = "VIEWLEVEL")
    private Short viewlevel;

    @OneToMany(mappedBy = "convention2", fetch = FetchType.LAZY)
    private Collection<Notification> notificationCollection;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;

    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User deletedby;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Column(name = "WITHOUTCOMMAND")
    private Short withoutcommand;
    @Size(max = 255)
    @Column(name = "CONVENTIONFILE")
    private String conventionfile;
    @Size(max = 255)
    @Column(name = "POSTER")
    private String poster;
    @Size(max = 255)
    @Column(name = "COMMUNICATION")
    private String communication;
    @OneToMany(mappedBy = "convention", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Offer> offerCollection;
    @OneToMany(mappedBy = "conventionc", fetch = FetchType.LAZY)
    private Collection<Contact> contactCollection;

    //echelonnement
    @Column(name = "LISTING")
    private Boolean listing;
    @Column(name = "PROVIDERLISTING")
    private Boolean providerlisting;

    @Transient
    private Integer validateBtnParticipate;
    @Transient
    private Integer validateBtnPayment;
    @Transient
    private int available;
    @Transient
    private Integer validatebtnPaymentWithoutPreservation;
    @Transient
    private String endDateNull;
    @Transient
    private int withOffer;
    @Transient
    private String logo;
    @Transient
    private Integer selectedIdOffer;
    @Transient
    private List<String> selectedIdOffers;
    @Transient
    private Boolean hided;

    @Column(name = "AVECVALIDATION")
    private Short avecvalidation;

    public Short getAvecvalidation() {
        return avecvalidation;
    }

    public void setAvecvalidation(Short avecvalidation) {
        this.avecvalidation = avecvalidation;
    }

    public Integer getSelectedIdOffer() {
        return selectedIdOffer;
    }

    public void setSelectedIdOffer(Integer selectedIdOffer) {

        this.selectedIdOffer = selectedIdOffer;

    }

    public Boolean getListing() {
        return listing;
    }

    public void setListing(Boolean listing) {
        this.listing = listing;
    }

    public Boolean getProviderlisting() {
        return providerlisting;
    }

    public void setProviderlisting(Boolean providerlisting) {
        this.providerlisting = providerlisting;
    }

    public List<String> getSelectedIdOffers() {
        return selectedIdOffers;
    }

    public void setSelectedIdOffers(List<String> selectedIdOffers) {
        this.selectedIdOffers = selectedIdOffers;
    }

    public Boolean isHided() {
        return hided;
    }

    public void setHided(Boolean hided) {
        this.hided = hided;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Short getPaySlip() {
        return paySlip;
    }

    public void setPaySlip(Short paySlip) {
        this.paySlip = paySlip;
    }

    public int getWithOffer() {
        return withOffer;
    }

    public void setWithOffer(int withOffer) {
        this.withOffer = withOffer;
    }

    public String getEndDateNull() {
        return endDateNull;
    }

    public void setEndDateNull(String endDateNull) {
        this.endDateNull = endDateNull;
    }

    public Integer getValidatebtnPaymentWithoutPreservation() {
        return validatebtnPaymentWithoutPreservation;
    }

    public void setValidatebtnPaymentWithoutPreservation(Integer validatebtnPaymentWithoutPreservation) {
        this.validatebtnPaymentWithoutPreservation = validatebtnPaymentWithoutPreservation;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Integer getValidateBtnParticipate() {
        return validateBtnParticipate;
    }

    public void setValidateBtnParticipate(Integer validateBtnParticipate) {
        this.validateBtnParticipate = validateBtnParticipate;
    }

    public Integer getValidateBtnPayment() {
        return validateBtnPayment;
    }

    public void setValidateBtnPayment(Integer validateBtnPayment) {
        this.validateBtnPayment = validateBtnPayment;
    }

    public Collection<Offer> getOfferCollection() {
        return offerCollection;
    }

    public void setOfferCollection(Collection<Offer> offerCollection) {
        this.offerCollection = offerCollection;
    }

    public Short getWithoutcommand() {
        return withoutcommand;
    }

    public void setWithoutcommand(Short withoutcommand) {
        this.withoutcommand = withoutcommand;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getConventionfile() {
        return conventionfile;
    }

    public void setConventionfile(String conventionfile) {
        this.conventionfile = conventionfile;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    public Convention() {
    }

    public Convention(Integer convetionid) {
        this.convetionid = convetionid;
    }

    public Integer getConvetionid() {
        return convetionid;
    }

    public void setConvetionid(Integer convetionid) {
        this.convetionid = convetionid;
    }

    public Short getWithcommitment() {
        return withcommitment;
    }

    public void setWithcommitment(Short withcommitment) {
        this.withcommitment = withcommitment;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
    }

    public String getTitleconvention() {
        return titleconvention;
    }

    public void setTitleconvention(String titleconvention) {
        this.titleconvention = titleconvention;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailconv() {
        return detailconv;
    }

    public void setDetailconv(String detailconv) {
        this.detailconv = detailconv;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getPhoneresponsible() {
        return phoneresponsible;
    }

    public void setPhoneresponsible(String phoneresponsible) {
        this.phoneresponsible = phoneresponsible;
    }

//    public Date getPaymentbeforedate() {
//        return paymentbeforedate;
//    }
//
//    public void setPaymentbeforedate(Date paymentbeforedate) {
//        this.paymentbeforedate = paymentbeforedate;
//    }
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(Double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Double getMinamountmonths() {
        return minamountmonths;
    }

    public void setMinamountmonths(Double minamountmonths) {
        this.minamountmonths = minamountmonths;
    }

    public Integer getMaxmonthes() {
        return maxmonthes;
    }

    public void setMaxmonthes(Integer maxmonthes) {
        this.maxmonthes = maxmonthes;
    }

    public Double getAmountconvention() {
        return amountconvention;
    }

    public void setAmountconvention(Double amountconvention) {
        this.amountconvention = amountconvention;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNbrperson() {
        return nbrperson;
    }

    public void setNbrperson(Integer nbrperson) {
        this.nbrperson = nbrperson;
    }

    public Integer getNbrfamily() {
        return nbrfamily;
    }

    public void setNbrfamily(Integer nbrfamily) {
        this.nbrfamily = nbrfamily;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<Convention> getConventionCollection() {
        return conventionCollection;
    }

    public void setConventionCollection(Collection<Convention> conventionCollection) {
        this.conventionCollection = conventionCollection;
    }

    public Convention getNeedconvention() {
        return needconvention;
    }

    public void setNeedconvention(Convention needconvention) {
        this.needconvention = needconvention;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Short getViewlevel() {
        return viewlevel;
    }

    public void setViewlevel(Short viewlevel) {
        this.viewlevel = viewlevel;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    public Boolean getCessiondocument() {
        return cessiondocument;
    }

    public void setCessiondocument(Boolean cessiondocument) {
        this.cessiondocument = cessiondocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (convetionid != null ? convetionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convention)) {
            return false;
        }
        Convention other = (Convention) object;
        if ((this.convetionid == null && other.convetionid != null) || (this.convetionid != null && !this.convetionid.equals(other.convetionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titleconvention;
    }

    public Convention(Integer convetionid,Integer duration,Integer nbrfamily,String titleconvention,Short withoutcommand) {
        this.convetionid=convetionid;
        this.duration=duration;
        this.nbrfamily=nbrfamily;
        this.titleconvention=titleconvention;
        this.withoutcommand=withoutcommand;
    }
    public Convention(Integer convetionid,Integer duration,Integer nbrfamily,String titleconvention,Short withoutcommand,Collection<Offer> offerCollection) {
        this.convetionid=convetionid;
        this.duration=duration;
        this.nbrfamily=nbrfamily;
        this.titleconvention=titleconvention;
        this.withoutcommand=withoutcommand;
        this.offerCollection=offerCollection;
    }
}
