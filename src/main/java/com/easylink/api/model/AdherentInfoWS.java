/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LMS
 */
public class AdherentInfoWS implements Serializable{
    
    private String centerName;
    private int isActive;
    private List<Event> listEvents;
    private List<Family> listfamilies;
    private List<Convention> listConventions;
    private List<Claim> listClaims;
    private List<Transaction> listTransaction;
    private List<Offer> listOffer;
    private List<Contact> listContact;
    private List<Discount> listDiscounts;
    private List<Product> listProducts;
    private User user;
    private Integer userid;
    private Convention convention;
    private Document document;
    private Event event;
    private String result;
    private Amicale amicale;
    private List<Transaction> detailsPurse;
    public AdherentInfoWS()
    {
        
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<Transaction> getDetailsPurse() {
        return detailsPurse;
    }

    public void setDetailsPurse(List<Transaction> detailsPurse) {
        this.detailsPurse = detailsPurse;
    }

    public List<Contact> getListContact() {
        return listContact;
    }

    public void setListContact(List<Contact> listContact) {
        this.listContact = listContact;
    }

    public List<Offer> getListOffer() {
        return listOffer;
    }

    public void setListOffer(List<Offer> listOffer) {
        this.listOffer = listOffer;
    }

    public List<Discount> getListDiscounts() {
        return listDiscounts;
    }

    public void setListDiscounts(List<Discount> listDiscounts) {
        this.listDiscounts = listDiscounts;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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

    public Amicale getAmicale() {
        return amicale;
    }

    public void setAmicale(Amicale amicale) {
        this.amicale = amicale;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }
    
    /**
     * @return the result
     */
    
    public String getResult() {
        return result;
    }
    
    /**
     * @param result the isActive to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the isActive
     */
    
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the listEvents
     */
    public List<Event> getListEvents() {
        return listEvents;
    }

    /**
     * @param listEvents the listEvents to set
     */
    public void setListEvents(List<Event> listEvents) {
        this.listEvents = listEvents;
    }

    /**
     * @return the listfamilies
     */
    public List<Family> getListfamilies() {
        return listfamilies;
    }

    /**
     * @param listfamilies the listfamilies to set
     */
    public void setListfamilies(List<Family> listfamilies) {
        this.listfamilies = listfamilies;
    }

    /**
     * @return the listConventions
     */
    public List<Convention> getListConventions() {
        return listConventions;
    }

    /**
     * @param listConventions the listConventions to set
     */
    public void setListConventions(List<Convention> listConventions) {
        this.listConventions = listConventions;
    }

    /**
     * @return the listClaims
     */
    public List<Claim> getListClaims() {
        return listClaims;
    }

    /**
     * @param listClaims the listClaims to set
     */
    public void setListClaims(List<Claim> listClaims) {
        this.listClaims = listClaims;
    }
    
}
