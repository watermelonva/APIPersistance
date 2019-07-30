/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LMS
 */
public class JsonParameters implements Serializable {

    private static final long serialVersionUID = 1L;

    private Event event;
    private User user;
    private Integer eventid;
    private Short transporttype;
    private Integer userid;
    private Integer amicaleid;
    private Integer offerid;
    private Integer deadlineid;
    private Integer relateduser;
    private Short paymenttype;
    private Short paymentmean;
    private Double totalamount;
    private Double amountsubtraction;
    private Double advancedamount;
    private Integer nbrmonths;
    private String startdate;
    private String enddate;
    private String createdate;
    private String path;
    private Short type;
    private String descriptionClaim;
    private Integer conventionid;
    private String transfertCode;
    private Integer transactionid;
    //ooredooWS  NotifyActivation
    private Integer Reference_ID;
    private String ActivationStatus;
    //ooredooWS UpdateOfferCatalog
    private String action;
     public Integer getOfferid() {
        return offerid;
    }

    public void setOfferid(Integer offerid) {
        this.offerid = offerid;
    }

    public Integer getReference_ID() {
        return Reference_ID;
    }

    public void setReference_ID(Integer reference_ID) {
        this.Reference_ID = reference_ID;
    }

    public String getActivationStatus() {
        return ActivationStatus;
    }

    public void setActivationStatus(String activationStatus) {
        this.ActivationStatus = activationStatus;
    }

    public Integer getDeadlineid() {
        return deadlineid;
    }

    public void setDeadlineid(Integer deadlineid) {
        this.deadlineid = deadlineid;
    }

    public Short getPaymentmean() {
        return paymentmean;
    }

    public void setPaymentmean(Short paymentmean) {
        this.paymentmean = paymentmean;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getTransfertCode() {
        return transfertCode;
    }

    public void setTransfertCode(String transfertCode) {
        this.transfertCode = transfertCode;
    }

    public Integer getConventionid() {
        return conventionid;
    }

    public void setConventionid(Integer conventionid) {
        this.conventionid = conventionid;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getDescriptionClaim() {
        return descriptionClaim;
    }

    public void setDescriptionClaim(String descriptionClaim) {
        this.descriptionClaim = descriptionClaim;
    }

    private List<Integer> idEnfants = new ArrayList<Integer>();

    public Integer getRelateduser() {
        return relateduser;
    }

    public void setRelateduser(Integer relateduser) {
        this.relateduser = relateduser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public List<Integer> getIdEnfants() {
        return idEnfants;
    }

    public void setIdEnfants(List<Integer> idEnfants) {
        this.idEnfants = idEnfants;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public Integer getNbrmonths() {
        return nbrmonths;
    }

    public void setNbrmonths(Integer nbrmonths) {
        this.nbrmonths = nbrmonths;
    }

    public Double getAdvancedamount() {
        return advancedamount;
    }

    public void setAdvancedamount(Double advancedamount) {
        this.advancedamount = advancedamount;
    }

    public Double getAmountsubtraction() {
        return amountsubtraction;
    }

    public void setAmountsubtraction(Double amountsubtraction) {
        this.amountsubtraction = amountsubtraction;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Short getTransporttype() {
        return transporttype;
    }

    public void setTransporttype(Short transporttype) {
        this.transporttype = transporttype;
    }

    public Short getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Short paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Integer getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Integer amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public JsonParameters() {
    }

    public Event getEvent() {
        return event;
    }

    public User getUser() {
        return user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
