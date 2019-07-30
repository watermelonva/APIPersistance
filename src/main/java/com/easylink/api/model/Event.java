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
import javax.persistence.CascadeType;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventid", query = "SELECT e FROM Event e WHERE e.eventid = :eventid"),
    @NamedQuery(name = "Event.findByTitle", query = "SELECT e FROM Event e WHERE e.title = :title"),
    @NamedQuery(name = "Event.countByAmicale", query = "SELECT COUNT(e) FROM Event e WHERE e.amicaleid = :amicale"),
    @NamedQuery(name = "Event.findByType", query = "SELECT e FROM Event e WHERE e.type = :type"),
    @NamedQuery(name = "Event.findByWithcommitment", query = "SELECT e FROM Event e WHERE e.withcommitment = :withcommitment"),
    @NamedQuery(name = "Event.findByPoster", query = "SELECT e FROM Event e WHERE e.poster = :poster"),
    @NamedQuery(name = "Event.findByPhoneresponsible", query = "SELECT e FROM Event e WHERE e.phoneresponsible = :phoneresponsible"),
    @NamedQuery(name = "Event.findByStartdate", query = "SELECT e FROM Event e WHERE e.startdate = :startdate"),
    @NamedQuery(name = "Event.findByEnddate", query = "SELECT e FROM Event e WHERE e.enddate = :enddate"),
    @NamedQuery(name = "Event.findByPriceadult", query = "SELECT e FROM Event e WHERE e.priceadult = :priceadult"),
    @NamedQuery(name = "Event.findByPricechild", query = "SELECT e FROM Event e WHERE e.pricechild = :pricechild"),
    @NamedQuery(name = "Event.findByPricebaby", query = "SELECT e FROM Event e WHERE e.pricebaby = :pricebaby"),
    @NamedQuery(name = "Event.findByNameplace", query = "SELECT e FROM Event e WHERE e.nameplace = :nameplace"),
    @NamedQuery(name = "Event.findByEnterdate", query = "SELECT e FROM Event e WHERE e.enterdate = :enterdate"),
    @NamedQuery(name = "Event.findByNumbernights", query = "SELECT e FROM Event e WHERE e.numbernights = :numbernights"),
    @NamedQuery(name = "Event.findByTypearrangement", query = "SELECT e FROM Event e WHERE e.typearrangement = :typearrangement"),
    @NamedQuery(name = "Event.findByMinamountmonths", query = "SELECT e FROM Event e WHERE e.minamountmonths = :minamountmonths"),
    @NamedQuery(name = "Event.findByMaxmonthes", query = "SELECT e FROM Event e WHERE e.maxmonthes = :maxmonthes"),
    @NamedQuery(name = "Event.findByConveyancetype", query = "SELECT e FROM Event e WHERE e.conveyancetype = :conveyancetype"),
    @NamedQuery(name = "Event.findByPublictpublicConveyance", query = "SELECT e FROM Event e WHERE e.publictpublicConveyance = :publictpublicConveyance"),
    @NamedQuery(name = "Event.findByNbrperson", query = "SELECT e FROM Event e WHERE e.nbrperson = :nbrperson"),
    @NamedQuery(name = "Event.findByNbrfamily", query = "SELECT e FROM Event e WHERE e.nbrfamily = :nbrfamily"),
    @NamedQuery(name = "Event.findByPaymentbeforedate", query = "SELECT e FROM Event e WHERE e.paymentbeforedate = :paymentbeforedate"),
    @NamedQuery(name = "Event.findByCreatedate", query = "SELECT e FROM Event e WHERE e.createdate = :createdate"),
    @NamedQuery(name = "Event.findByRecursive", query = "SELECT e FROM Event e WHERE e.recursive = :recursive"),
    @NamedQuery(name = "Event.findByIsdeleted", query = "SELECT e FROM Event e WHERE e.isdeleted = :isdeleted")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENTID")
    private Integer eventid;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TYPE")
    private Short type;
    @Column(name = "WITHCOMMITMENT")
    private Short withcommitment;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "POSTER")
    private String poster;
    @Size(max = 50)
    @Column(name = "PHONERESPONSIBLE")
    private String phoneresponsible;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICEADULT")
    private Double priceadult;
    @Column(name = "ADVANCEAMOUNT")
    private Double advanceamount;
    @Column(name = "PRICECHILD")
    private Double pricechild;
    @Column(name = "PRICEBABY")
    private Double pricebaby;
    @Size(max = 100)
    @Column(name = "NAMEPLACE")
    private String nameplace;
    @Column(name = "ENTERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterdate;
    @Column(name = "NUMBERNIGHTS")
    private Short numbernights;
    @Column(name = "TYPEARRANGEMENT")
    private Short typearrangement;

    @Column(name = "MINAMOUNTMONTHS")
    private Double minamountmonths;
    @Column(name = "MAXMONTHES")
    private Integer maxmonthes;
    @Column(name = "STARTCESSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startcession;
    @Column(name = "CONVEYANCETYPE")
    private Short conveyancetype;
    @Column(name = "PUBLICTPUBLIC_CONVEYANCE_")
    private Double publictpublicConveyance;
    @Column(name = "SUPPLEMENTTRANSPORT")
    private Double supplementtransport;
    @Column(name = "NBRPERSON")
    private Integer nbrperson;
    @Column(name = "NBRFAMILY")
    private Integer nbrfamily;
    @Column(name = "PAYMENTBEFOREDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentbeforedate;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Column(name = "RECURSIVE")
    private Short recursive;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "VALID")
    private Short valid;
    @Column(name = "ONLYFAMILY")
    private Short onlyfamily;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User createdby;
    @JoinColumn(name = "PROVIDER", referencedColumnName = "PROVIDERID")
    @ManyToOne
    private Provider provider;
    @OneToMany(mappedBy = "event")
    private Collection<Transaction> transactionCollection;

    @OneToMany(mappedBy = "event2")
    private Collection<Notification> notificationCollection;

    @Column(name = "VIEWLEVEL")
    private Short viewlevel;

    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne
    private User deletedby;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @Transient
    private Integer validateBtnParticipate;
    @Transient
    private Integer validateBtnPayment;
    @Transient
    private int validatebtnPaymentWithoutPreservation;
    @Transient
    private int available;
    @Column(name = "PAYSLIP")
    private Short paySlip;
    @Column(name = "CESSIONDOCUMENT")
    private Boolean cessiondocument;
    @OneToMany(mappedBy = "eventid", cascade = CascadeType.PERSIST)
    private Collection<Pack> packCollection;
    @Column(name = "WITHSUBVENTION")
    private Boolean withsubvention;
    @Column(name = "TOTALSUBVENTION")
    private Double totalsubvention;
    @Column(name = "AMOUNTSUBVENTION")
    private Double amountsubvention;
    @Column(name = "WITHTHRESHOLDSUBVENTION")
    private Boolean withthresholdsubvention;
    @Column(name = "THRESHOLDSUBVENTION")
    private Double thresholdsubvention;
    @Size(max = 100)
    @Column(name = "TYPESUBVENTION")
    private String typesubvention;
    @Column(name = "PERIODEFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodefrom;
    @Column(name = "PERIODETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodeto;
    @Size(max = 255)
    @Column(name = "STATEMENT")
    private String statement;
    @Column(name = "TYPEADVANCE")
    private Short typeadvance;
    @Column(name = "CAPACITYTYPE")
    private Short capacitytype;
    @Column(name = "CAPACITY")
    private Double capacity;
    @OneToMany(mappedBy = "eventid", cascade = CascadeType.PERSIST)
    private Collection<Hotel> hotelCollection;
    @JoinColumn(name = "CIRCULARID", referencedColumnName = "CIRCULARID")
    @ManyToOne
    private Circular circularid;

    public Circular getCircularid() {
        return circularid;
    }

    public void setCircularid(Circular circularid) {
        this.circularid = circularid;
    }

    public Collection<Hotel> getHotelCollection() {
        return hotelCollection;
    }

    public void setHotelCollection(Collection<Hotel> hotelCollection) {
        this.hotelCollection = hotelCollection;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Short getCapacitytype() {
        return capacitytype;
    }

    public void setCapacitytype(Short capacitytype) {
        this.capacitytype = capacitytype;
    }

    public Short getTypeadvance() {
        return typeadvance;
    }

    public void setTypeadvance(Short typeadvance) {
        this.typeadvance = typeadvance;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Date getPeriodefrom() {
        return periodefrom;
    }

    public void setPeriodefrom(Date periodefrom) {
        this.periodefrom = periodefrom;
    }

    public Date getPeriodeto() {
        return periodeto;
    }

    public void setPeriodeto(Date periodeto) {
        this.periodeto = periodeto;
    }

    public Boolean getWithsubvention() {
        return withsubvention;
    }

    public void setWithsubvention(Boolean withsubvention) {
        this.withsubvention = withsubvention;
    }

    public Double getTotalsubvention() {
        return totalsubvention;
    }

    public void setTotalsubvention(Double totalsubvention) {
        this.totalsubvention = totalsubvention;
    }

    public Double getAmountsubvention() {
        return amountsubvention;
    }

    public void setAmountsubvention(Double amountsubvention) {
        this.amountsubvention = amountsubvention;
    }

    public Boolean getWiththresholdsubvention() {
        return withthresholdsubvention;
    }

    public void setWiththresholdsubvention(Boolean withthresholdsubvention) {
        this.withthresholdsubvention = withthresholdsubvention;
    }

    public Double getThresholdsubvention() {
        return thresholdsubvention;
    }

    public void setThresholdsubvention(Double thresholdsubvention) {
        this.thresholdsubvention = thresholdsubvention;
    }

    public String getTypesubvention() {
        return typesubvention;
    }

    public void setTypesubvention(String typesubvention) {
        this.typesubvention = typesubvention;
    }

    public Collection<Pack> getPackCollection() {
        return packCollection;
    }

    public void setPackCollection(Collection<Pack> packCollection) {
        this.packCollection = packCollection;
    }

    public int getValidatebtnPaymentWithoutPreservation() {
        return validatebtnPaymentWithoutPreservation;
    }

    public void setValidatebtnPaymentWithoutPreservation(int validatebtnPaymentWithoutPreservation) {
        this.validatebtnPaymentWithoutPreservation = validatebtnPaymentWithoutPreservation;
    }

    public Short getPaySlip() {
        return paySlip;
    }

    public void setPaySlip(Short paySlip) {
        this.paySlip = paySlip;
    }

    public Boolean getCessiondocument() {
        return cessiondocument;
    }

    public void setCessiondocument(Boolean cessiondocument) {
        this.cessiondocument = cessiondocument;
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

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Date getStartcession() {
        return startcession;
    }

    public void setStartcession(Date startcession) {
        this.startcession = startcession;
    }

    public Short getOnlyfamily() {
        return onlyfamily;
    }

    public void setOnlyfamily(Short onlyfamily) {
        this.onlyfamily = onlyfamily;
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

    public Event() {
    }

    public Event(Integer eventid) {
        this.eventid = eventid;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
    }

    public Double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(Double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getWithcommitment() {
        return withcommitment;
    }

    public void setWithcommitment(Short withcommitment) {
        this.withcommitment = withcommitment;
    }

    public Double getSupplementtransport() {
        return supplementtransport;
    }

    public void setSupplementtransport(Double supplementtransport) {
        this.supplementtransport = supplementtransport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPhoneresponsible() {
        return phoneresponsible;
    }

    public void setPhoneresponsible(String phoneresponsible) {
        this.phoneresponsible = phoneresponsible;
    }

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

    public Double getPriceadult() {
        return priceadult;
    }

    public void setPriceadult(Double priceadult) {
        this.priceadult = priceadult;
    }

    public Double getPricechild() {
        return pricechild;
    }

    public void setPricechild(Double pricechild) {
        this.pricechild = pricechild;
    }

    public Double getPricebaby() {
        return pricebaby;
    }

    public void setPricebaby(Double pricebaby) {
        this.pricebaby = pricebaby;
    }

    public String getNameplace() {
        return nameplace;
    }

    public void setNameplace(String nameplace) {
        this.nameplace = nameplace;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Short getNumbernights() {
        return numbernights;
    }

    public void setNumbernights(Short numbernights) {
        this.numbernights = numbernights;
    }

    public Short getTypearrangement() {
        return typearrangement;
    }

    public void setTypearrangement(Short typearrangement) {
        this.typearrangement = typearrangement;
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

    public Short getConveyancetype() {
        return conveyancetype;
    }

    public void setConveyancetype(Short conveyancetype) {
        this.conveyancetype = conveyancetype;
    }

    public Double getPublictpublicConveyance() {
        return publictpublicConveyance;
    }

    public void setPublictpublicConveyance(Double publictpublicConveyance) {
        this.publictpublicConveyance = publictpublicConveyance;
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

    public Date getPaymentbeforedate() {
        return paymentbeforedate;
    }

    public void setPaymentbeforedate(Date paymentbeforedate) {
        this.paymentbeforedate = paymentbeforedate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Short getRecursive() {
        return recursive;
    }

    public void setRecursive(Short recursive) {
        this.recursive = recursive;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Event[ eventid=" + eventid + " ]";
    }

}
