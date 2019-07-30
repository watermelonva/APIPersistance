/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.servlet.http.Part;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "TRANSACTION")
@XmlRootElement

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSACTIONID")
    private Integer transactionid;
    @Column(name = "STATUS")
    private Short status;
    @Lob
    @Size(max = 65535)
    @Column(name = "REPLAYMESSAGE")
    private String replaymessage;
    @Column(name = "ADVANCEDAMOUNT", scale = 3)
    private Double advancedamount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNTSUBTRACTION", scale = 3)
    private Double amountsubtraction;
    @Column(name = "TOTALAMOUNT", scale = 3)
    private Double totalamount;
    @Column(name = "PAYMENTTYPE")
    private Short paymenttype;
    // echelonnement 0:false,1:true
    @Column(name = "LISTED")
    private Short listed;
    @Column(name = "NBRMONTHS")
    private Integer nbrmonths;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "TYPEDISPOSAL")
    private Short typedisposal;
    @Column(name = "TRANSPORTTYPE")
    private Short transporttype;
    @Size(max = 20)
    @Column(name = "REFPACK")
    private String refpack;
    @Size(max = 30)
    @Column(name = "TRANSFERTCODE")
    private String transfertCode;
    @Size(max = 20)
    @Column(name = "NUMCONTRACT")
    private String numcontract;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Column(name = "VALIDATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationdate;
    @Column(name = "CESSIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cessiondate;
    @Column(name = "FIRSTITEMPURSE")
    private Short firstitempurse;
    @Column(name = "ONLYFAMILY")
    private Short onlyfamily;
    @Lob
    @Size(max = 65535)
    @Column(name = "CAUSE")
    private String cause;
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private Collection<Contain> containCollection;
    @JoinColumn(name = "REJECTEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User rejectedby;
    @JoinColumn(name = "EVENT", referencedColumnName = "EVENTID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Event event;
    @JoinColumn(name = "CONVENTION", referencedColumnName = "CONVETIONID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Convention convention;
    @JoinColumn(name = "OFFER", referencedColumnName = "OFFERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Offer offer;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User createdby;
    @JoinColumn(name = "RELATEDUSER", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User relateduser;
    @Transient
    private String details = "";

    @OneToMany(mappedBy = "ntransaction", fetch = FetchType.LAZY)
    private Collection<Notification> notificationCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;

    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Product productid;
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private Collection<Bill> billCollection;
    @Column(name = "ISDELIVERED")
    private Short isdelivered;
    @Column(name = "DELIVERYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverydate;
    @Column(name = "PURSEREF")
    private Integer purseref;
    @Column(name = "CHECKPAYMENT")
    private Short checkpayment;
    //transient title of event or convention for WS
    @Transient
    private String title = "";
    //transient type of transaction for WS
    @Transient
    private int type;
    @Transient
    transient private Part signedFile;
    @Size(max = 200)
    @Column(name = "DELETECAUSE")
    private String deletecause;
    @Column(name = "DELETEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedate;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User deletedby;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "SN")
    private String sn;
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CITY")
    private String city;
    @Size(max = 10)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Size(max = 20)
    @Column(name = "DELIVERYGOVERNORATE")
    private String deliveryGovernorate;
    @Column(name = "DELIVERYSTATUS")
    private Short deliverystatus;
    @Column(name = "DATECONFIRMATIONORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateconfirmationorder;
    @Column(name = "DATECONTACTMEMBER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecontactmember;
    @Column(name = "MEMBERNOTREACHABLE")
    private Short membernotreachable;
    @Column(name = "DATERECONTACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daterecontact;
    @Column(name = "DATESTARTDELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datestartdelivery;
    @Column(name = "DATEENDDELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateenddelivery;
    @Column(name = "DATECONFIRMATIONDELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateconfirmationdelivery;
    @Column(name = "DATECONCELLATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateconcellation;
    @Size(max = 50)
    @Column(name = "HAWB")
    private String hawb;
    @Size(max = 50)
    @Column(name = "MANIFESID")
    private String manifesid;
    @Size(max = 10)
    @Column(name = "ACTIVATIONSTATUS")
    private String activationstatus;
    @Size(max = 50)
    @Column(name = "SERIALNUMBER")
    private String serialNumber;
    @Column(name = "DATEOPERATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "CONCELLATIONREASON")
    private String concellationreason;
    @JoinColumn(name = "CONFIRMATIONDELIVERYBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User confirmationdeliveryby;
    @JoinColumn(name = "CONFIRMATIONORDERBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User confirmationorderby;
    @JoinColumn(name = "MEMBERCONTATEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User membercontatedby;
    @JoinColumn(name = "ORDERCANCELLEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User ordercancelledby;
    @JoinColumn(name = "DELIVERYCREATEDBY", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User deliveryCreatedby;
    @Column(name = "TOTALPAID", scale = 3)
    private Double totalpaid;
    @Size(max = 2)
    @Column(name = "PAYMENTSTATUS")
    private String paymentstatus;
    @Column(name = "CONVEYANCETYPE")
    private Short conveyancetype;
    @Column(name = "SUBVENTION")
    private Double subvention;
    @JoinColumn(name = "PACKID", referencedColumnName = "PACKID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Pack packid;
    @JoinColumn(name = "HOTELID", referencedColumnName = "HOTELID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Hotel hotelid;
    @Column(name = "FROMDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Column(name = "TODATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date todate;
    @Column(name = "ARRANGEMENT")
    private String arrangement;
    @OneToMany(mappedBy = "transactionid", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Room> roomCollection;
    @Column(name = "NBROOM")
    private Integer nbroom;

    public Integer getNbroom() {
        return nbroom;
    }

    public void setNbroom(Integer nbroom) {
        this.nbroom = nbroom;
    }
    
    

    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }
    

    public Pack getPackid() {
        return packid;
    }

    public void setPackid(Pack packid) {
        this.packid = packid;
    }

    public Hotel getHotelid() {
        return hotelid;
    }

    public void setHotelid(Hotel hotelid) {
        this.hotelid = hotelid;
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

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }
    
    

    public Double getSubvention() {
        return subvention;
    }

    public void setSubvention(Double subvention) {
        this.subvention = subvention;
    }

    public Short getConveyancetype() {
        return conveyancetype;
    }

    public void setConveyancetype(Short conveyancetype) {
        this.conveyancetype = conveyancetype;
    }

    public Double getTotalpaid() {
        return totalpaid;
    }

    public void setTotalpaid(Double totalpaid) {
        this.totalpaid = totalpaid;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getActivationstatus() {
        return activationstatus;
    }

    public void setActivationstatus(String activationstatus) {
        this.activationstatus = activationstatus;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public User getDeliveryCreatedby() {
        return deliveryCreatedby;
    }

    public void setDeliveryCreatedby(User deliveryCreatedby) {
        this.deliveryCreatedby = deliveryCreatedby;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryGovernorate() {
        return deliveryGovernorate;
    }

    public void setDeliveryGovernorate(String deliveryGovernorate) {
        this.deliveryGovernorate = deliveryGovernorate;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDeletecause() {
        return deletecause;
    }

    public Short getListed() {
        return listed;
    }

    public void setListed(Short listed) {
        this.listed = listed;
    }

    public void setDeletecause(String deletecause) {
        this.deletecause = deletecause;
    }

    public Date getDeletedate() {
        return deletedate;
    }

    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }

    public User getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(User deletedby) {
        this.deletedby = deletedby;
    }

    public Part getSignedFile() {
        return signedFile;
    }

    public void setSignedFile(Part signedFile) {
        this.signedFile = signedFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Transaction() {
        transporttype = (short) 1;
    }

    public Transaction(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Short getCheckpayment() {
        return checkpayment;
    }

    public void setCheckpayment(Short checkpayment) {
        this.checkpayment = checkpayment;
    }

    public Short getOnlyfamily() {
        return onlyfamily;
    }

    public void setOnlyfamily(Short onlyfamily) {
        this.onlyfamily = onlyfamily;
    }

    public String getCause() {
        return cause;
    }

    public String[] getCauseAsList() {
        return cause.split("//");
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getPurseref() {
        return purseref;
    }

    public void setPurseref(Integer purseref) {
        this.purseref = purseref;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public void addAmount(Double addAmountsubtraction) {
        this.amountsubtraction = amountsubtraction + addAmountsubtraction;

    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Short getIsdelivered() {
        return isdelivered;
    }

    public void setIsdelivered(Short isdelivered) {
        this.isdelivered = isdelivered;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public void addDetails(String addDetails) {
        this.details = details + "," + addDetails;

    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {

        this.totalamount = preciseDouble(totalamount);
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getReplaymessage() {
        return replaymessage;
    }

    public void setReplaymessage(String replaymessage) {
        this.replaymessage = replaymessage;
    }

    public String getTransfertCode() {
        return transfertCode;
    }

    public void setTransfertCode(String transfertCode) {
        this.transfertCode = transfertCode;
    }

    public Double getAdvancedamount() {
        return advancedamount;
    }

    public void setAdvancedamount(Double advancedamount) {

        this.advancedamount = preciseDouble(advancedamount);
    }

    public Double getAmountsubtraction() {
        return amountsubtraction;
    }

    public void setAmountsubtraction(Double amountsubtraction) {

        this.amountsubtraction = preciseDouble(amountsubtraction);
    }

    public Integer getNbrmonths() {
        return nbrmonths;
    }

    public void setNbrmonths(Integer nbrmonths) {
        this.nbrmonths = nbrmonths;
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

    public Short getTypedisposal() {
        return typedisposal;
    }

    public void setTypedisposal(Short typedisposal) {
        this.typedisposal = typedisposal;
    }

    public String getRefpack() {
        return refpack;
    }

    public void setRefpack(String refpack) {
        this.refpack = refpack;
    }

    public String getNumcontract() {
        return numcontract;
    }

    public void setNumcontract(String numcontract) {
        this.numcontract = numcontract;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getValidationdate() {
        return validationdate;
    }

    public Short getTransporttype() {
        return transporttype;
    }

    public void setTransporttype(Short transporttype) {
        this.transporttype = transporttype;
    }

    public void setValidationdate(Date validationdate) {
        this.validationdate = validationdate;
    }

    public Date getCessiondate() {
        return cessiondate;
    }

    public void setCessiondate(Date cessiondate) {
        this.cessiondate = cessiondate;
    }

    public Short getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Short paymenttype) {
        this.paymenttype = paymenttype;
    }

    @XmlTransient
    public Collection<Contain> getContainCollection() {
        return containCollection;
    }

    public void setContainCollection(Collection<Contain> containCollection) {
        this.containCollection = containCollection;
    }

    public void setNewContain(Contain contain) {
        this.containCollection.add(contain);
    }

    public User getRejectedby() {
        return rejectedby;
    }

    public void setRejectedby(User rejectedby) {
        this.rejectedby = rejectedby;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public User getRelateduser() {
        return relateduser;
    }

    public void setRelateduser(User relateduser) {
        this.relateduser = relateduser;
    }

    public Short getFirstitempurse() {
        return firstitempurse;
    }

    public void setFirstitempurse(Short firstitempurse) {
        this.firstitempurse = firstitempurse;
    }

    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    public Short getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(Short deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public Date getDateconfirmationorder() {
        return dateconfirmationorder;
    }

    public void setDateconfirmationorder(Date dateconfirmationorder) {
        this.dateconfirmationorder = dateconfirmationorder;
    }

    public Date getDatecontactmember() {
        return datecontactmember;
    }

    public void setDatecontactmember(Date datecontactmember) {
        this.datecontactmember = datecontactmember;
    }

    public Short getMembernotreachable() {
        return membernotreachable;
    }

    public void setMembernotreachable(Short membernotreachable) {
        this.membernotreachable = membernotreachable;
    }

    public Date getDaterecontact() {
        return daterecontact;
    }

    public void setDaterecontact(Date daterecontact) {
        this.daterecontact = daterecontact;
    }

    public Date getDatestartdelivery() {
        return datestartdelivery;
    }

    public void setDatestartdelivery(Date datestartdelivery) {
        this.datestartdelivery = datestartdelivery;
    }

    public Date getDateenddelivery() {
        return dateenddelivery;
    }

    public void setDateenddelivery(Date dateenddelivery) {
        this.dateenddelivery = dateenddelivery;
    }

    public Date getDateconfirmationdelivery() {
        return dateconfirmationdelivery;
    }

    public void setDateconfirmationdelivery(Date dateconfirmationdelivery) {
        this.dateconfirmationdelivery = dateconfirmationdelivery;
    }

    public Date getDateconcellation() {
        return dateconcellation;
    }

    public void setDateconcellation(Date dateconcellation) {
        this.dateconcellation = dateconcellation;
    }

    public String getHawb() {
        return hawb;
    }

    public void setHawb(String hawb) {
        this.hawb = hawb;
    }

    public String getManifesid() {
        return manifesid;
    }

    public void setManifesid(String manifesid) {
        this.manifesid = manifesid;
    }

    public String getConcellationreason() {
        return concellationreason;
    }

    public void setConcellationreason(String concellationreason) {
        this.concellationreason = concellationreason;
    }

    public User getConfirmationdeliveryby() {
        return confirmationdeliveryby;
    }

    public void setConfirmationdeliveryby(User confirmationdeliveryby) {
        this.confirmationdeliveryby = confirmationdeliveryby;
    }

    public User getConfirmationorderby() {
        return confirmationorderby;
    }

    public void setConfirmationorderby(User confirmationorderby) {
        this.confirmationorderby = confirmationorderby;
    }

    public User getMembercontatedby() {
        return membercontatedby;
    }

    public void setMembercontatedby(User membercontatedby) {
        this.membercontatedby = membercontatedby;
    }

    public User getOrdercancelledby() {
        return ordercancelledby;
    }

    public void setOrdercancelledby(User ordercancelledby) {
        this.ordercancelledby = ordercancelledby;
    }

    public Double preciseDouble(Double mt) {
        BigDecimal bd = new BigDecimal(mt);
        return bd.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Transaction[ transactionid=" + transactionid + " ]";
    }

}
