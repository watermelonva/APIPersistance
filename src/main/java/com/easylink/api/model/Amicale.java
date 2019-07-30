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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "AMICALE")
@XmlRootElement
public class Amicale implements Serializable {

    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Invoice> invoiceCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AMICALEID")
    private Integer amicaleid;

    @Size(max = 255)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Size(max = 255)
    @Column(name = "COMPANYNAMEAR")
    private String companynamear;
    @Size(max = 255)
    @Column(name = "LOGO")
    private String logo;
    @Size(max = 255)
    @Column(name = "RESPONSIBLENAMEFR")
    private String responsiblenamefr;
    @Size(max = 255)
    @Column(name = "RESPONSIBLENAMEAR")
    private String responsiblenamear;
    @Size(max = 255)
    @Column(name = "TAXNUMBER")
    private String taxnumber;
    @Size(max = 255)
    @Column(name = "TRADEREGISTER")
    private String Traderegister;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 255)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 255)
    @Column(name = "MEMBERCARDFRONT")
    private String memberCardFront;
    @Size(max = 255)
    @Column(name = "MEMBERCARDBACK")
    private String memberCardBack;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Applicationsetting> applicationsettingsCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Budget> budgetCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Book> bookCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Center> centerCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Command> commandCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Complement> complementCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Convention> conventionCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Event> eventCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Family> familyCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Globalnotification> globalnotificationCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Message> messageCollection;
    @OneToMany(mappedBy = "amicaleid" ,fetch = FetchType.LAZY)
    private Collection<Notification> notificationCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Provider> providerCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Region> regionCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Subscription> subscriptionCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<User> userCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Previoususer> previousCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Claim> claimCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Document> documentCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Department> departmentCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<CategoryAmicale> categoryCollection;
    //president
    @JoinColumn(name = "PRESIDENT", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User president;
    //DF
    @JoinColumn(name = "DF", referencedColumnName = "USERID")
    @ManyToOne( fetch = FetchType.LAZY)
    private User df;
    @Column(name = "DAFVALIDATION")
    private Short dafvalidation;
    @Column(name = "PRERESERVATION")
    private Short prereservation;
    @Column(name = "CENTERS")
    private Short centers;
    @Column(name = "SENDSMS")
    private Short sendsms;
    @Column(name = "SMSBALANCE")
    private int smsbalance;
    @Column(name = "SMSSENT")
    private int smssent;
    @Column(name = "WITHRESERVATION")
    private Short withreservation;
    @JoinColumn(name = "LINKEDAMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale linkedamicale;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Journal> journalCollection;
    @OneToMany(mappedBy = "amicaleid", fetch = FetchType.LAZY)
    private Collection<Account> accountCollection;
    @Column(name = "AUTOVALIDATIONADDUSER")
    private Short autovalidationadduser;
    @Column(name = "MODULE_COMMANDE")
    private Boolean module_commande;
    @Column(name = "MODULE_HANDFREE")
    private Boolean module_handfree;
    @Column(name = "MODULE_MESSAGE")
    private Boolean module_message;
    @Column(name = "MODULE_COMPTABILITE")
    private Boolean module_comptabilite;
    @Column(name = "MODULE_CSS")
    private Boolean module_css;
    @Column(name = "MODULE_CONVENTION")
    private Boolean module_convention;
    @Column(name = "MODULE_EVENT")
    private Boolean module_event;
    @Column(name = "MODULE_PARTNER")
    private Boolean module_partner;
    @Column(name = "MODULE_FAMILY")
    private Boolean module_family;
    @Column(name = "MODULE_CREDIT")
    private Boolean module_credit;
    @Column(name = "MODULE_SMS")
    private Boolean module_sms;
    @Column(name = "MODULE_CIRCULAIRE")
    private Boolean module_circulaire;
    @Column(name = "MODULE_SCORING")
    private Boolean module_scoring;



    public Boolean isModule_circulaire() {
        return module_circulaire;
    }

    public void setModule_circulaire(Boolean module_circulaire) {
        this.module_circulaire = module_circulaire;
    }

    public Boolean isModule_sms() {
        return module_sms;
    }

    public void setModule_sms(Boolean module_sms) {
        this.module_sms = module_sms;
    }

    public Boolean isModule_credit() {
        return module_credit;
    }

    public void setModule_credit(Boolean module_credit) {
        this.module_credit = module_credit;
    }

    public Boolean isModule_family() {
        return module_family;
    }

    public void setModule_family(Boolean module_family) {
        this.module_family = module_family;
    }

    public Boolean isModule_partner() {
        return module_partner;
    }

    public void setModule_partner(Boolean module_partner) {
        this.module_partner = module_partner;
    }

    public Boolean isModule_convention() {
        return module_convention;
    }

    public void setModule_convention(Boolean module_convention) {
        this.module_convention = module_convention;
    }

    public Boolean isModule_event() {
        return module_event;
    }

    public void setModule_event(Boolean module_event) {
        this.module_event = module_event;
    }

    public Boolean isModule_comptabilite() {
        return module_comptabilite;
    }

    public void setModule_comptabilite(Boolean module_comptabilite) {
        this.module_comptabilite = module_comptabilite;
    }

    public Boolean isModule_css() {
        return module_css;
    }

    public void setModule_css(Boolean module_css) {
        this.module_css = module_css;
    }

    public Boolean isModule_message() {
        return module_message;
    }

    public void setModule_message(Boolean module_message) {
        this.module_message = module_message;
    }

    public Boolean isModule_handfree() {
        return module_handfree;
    }

    public void setModule_handfree(Boolean module_handfree) {
        this.module_handfree = module_handfree;
    }

    public Boolean isModule_commande() {
        return module_commande;
    }

    public void setModule_commande(Boolean module_commande) {
        this.module_commande = module_commande;
    }

    public Short getAutovalidationadduser() {
        return autovalidationadduser;
    }

    public void setAutovalidationadduser(Short autovalidationadduser) {
        this.autovalidationadduser = autovalidationadduser;
    }

    public Collection<Journal> getJournalCollection() {
        return journalCollection;
    }

    public void setJournalCollection(Collection<Journal> journalCollection) {
        this.journalCollection = journalCollection;
    }

    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    public Amicale getLinkedamicale() {
        return linkedamicale;
    }

    public void setLinkedamicale(Amicale linkedamicale) {
        this.linkedamicale = linkedamicale;
    }

    public Short getWithreservation() {
        return withreservation;
    }

    public void setWithreservation(Short withreservation) {
        this.withreservation = withreservation;
    }

    //ooredoo
    @OneToMany(mappedBy = "amicale")
    private Collection<Agencyamicale> agencyamicaleCollection;

    public Collection<CategoryAmicale> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<CategoryAmicale> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Collection<Previoususer> getPreviousCollection() {
        return previousCollection;
    }

    public void setPreviousCollection(Collection<Previoususer> previousCollection) {
        this.previousCollection = previousCollection;
    }


    public String getResponsiblenamefr() {
        return responsiblenamefr;
    }

    public void setResponsiblenamefr(String responsiblenamefr) {
        this.responsiblenamefr = responsiblenamefr;
    }

    public String getResponsiblenamear() {
        return responsiblenamear;
    }

    public void setResponsiblenamear(String responsiblenamear) {
        this.responsiblenamear = responsiblenamear;
    }

    public String getMemberCardFront() {
        return memberCardFront;
    }

    public void setMemberCardFront(String memberCardFront) {
        this.memberCardFront = memberCardFront;
    }

    public String getMemberCardBack() {
        return memberCardBack;
    }

    public void setMemberCardBack(String memberCardBack) {
        this.memberCardBack = memberCardBack;
    }

    public int getSmssent() {
        return smssent;
    }

    public void setSmssent(int smssent) {
        this.smssent = smssent;
    }

    public Short getSendsms() {
        return sendsms;
    }

    public void setSendsms(Short sendsms) {
        this.sendsms = sendsms;
    }

    public int getSmsbalance() {
        return smsbalance;
    }

    public void setSmsbalance(int smsbalance) {
        this.smsbalance = smsbalance;
    }

    public Short getCenters() {
        return centers;
    }

    public void setCenters(Short centers) {
        this.centers = centers;
    }

    public User getDf() {
        return df;
    }

    public void setDf(User df) {
        this.df = df;
    }

    public Short getDafvalidation() {
        return dafvalidation;
    }

    public void setDafvalidation(Short dafvalidation) {
        this.dafvalidation = dafvalidation;
    }

    public Short getPrereservation() {
        return prereservation;
    }

    public void setPrereservation(Short prereservation) {
        this.prereservation = prereservation;
    }

    public Amicale() {
        president = new User();
        df = new User();
    }

    public Amicale(Integer amicaleid) {
        this.amicaleid = amicaleid;
    }

    public User getPresident() {
        return president;
    }

    public void setPresident(User president) {
        this.president = president;
    }

    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    public Integer getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Integer amicaleid) {
        this.amicaleid = amicaleid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    public String getTraderegister() {
        return Traderegister;
    }

    public void setTraderegister(String Traderegister) {
        this.Traderegister = Traderegister;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Agencyamicale> getAgencyamicaleCollection() {
        return agencyamicaleCollection;
    }

    public void setAgencyamicaleCollection(Collection<Agencyamicale> agencyamicaleCollection) {
        this.agencyamicaleCollection = agencyamicaleCollection;
    }

    @XmlTransient
    public Collection<Applicationsetting> getApplicationsettingsCollection() {
        return applicationsettingsCollection;
    }

    public void setApplicationsettingsCollection(Collection<Applicationsetting> applicationsettingsCollection) {
        this.applicationsettingsCollection = applicationsettingsCollection;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @XmlTransient
    public Collection<Center> getCenterCollection() {
        return centerCollection;
    }

    public void setCenterCollection(Collection<Center> centerCollection) {
        this.centerCollection = centerCollection;
    }

    @XmlTransient
    public Collection<Command> getCommandCollection() {
        return commandCollection;
    }

    public void setCommandCollection(Collection<Command> commandCollection) {
        this.commandCollection = commandCollection;
    }

    @XmlTransient
    public Collection<Complement> getComplementCollection() {
        return complementCollection;
    }

    public void setComplementCollection(Collection<Complement> complementCollection) {
        this.complementCollection = complementCollection;
    }

    @XmlTransient
    public Collection<Convention> getConventionCollection() {
        return conventionCollection;
    }

    public void setConventionCollection(Collection<Convention> conventionCollection) {
        this.conventionCollection = conventionCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<Family> getFamilyCollection() {
        return familyCollection;
    }

    public void setFamilyCollection(Collection<Family> familyCollection) {
        this.familyCollection = familyCollection;
    }

    @XmlTransient
    public Collection<Globalnotification> getGlobalnotificationCollection() {
        return globalnotificationCollection;
    }

    public void setGlobalnotificationCollection(Collection<Globalnotification> globalnotificationCollection) {
        this.globalnotificationCollection = globalnotificationCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<Provider> getProviderCollection() {
        return providerCollection;
    }

    public void setProviderCollection(Collection<Provider> providerCollection) {
        this.providerCollection = providerCollection;
    }

    @XmlTransient
    public Collection<Region> getRegionCollection() {
        return regionCollection;
    }

    public void setRegionCollection(Collection<Region> regionCollection) {
        this.regionCollection = regionCollection;
    }

    @XmlTransient
    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    public String getCompanynamear() {
        return companynamear;
    }

    public void setCompanynamear(String companynamear) {
        this.companynamear = companynamear;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amicaleid != null ? amicaleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amicale)) {
            return false;
        }
        Amicale other = (Amicale) object;
        if ((this.amicaleid == null && other.amicaleid != null) || (this.amicaleid != null && !this.amicaleid.equals(other.amicaleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return companyname + "";
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    public Amicale(Integer amicaleid,String companyname,String responsiblenamefr,String responsiblenamear) {
        this.amicaleid=amicaleid;
        this.companyname=companyname;
        this.responsiblenamefr=responsiblenamefr;
        this.responsiblenamear=responsiblenamear;
    }
    public Amicale(Integer amicaleid,String companyname,String responsiblenamefr,String responsiblenamear,Collection<Convention> conventionCollection) {
        this.amicaleid=amicaleid;
        this.companyname=companyname;
        this.responsiblenamefr=responsiblenamefr;
        this.responsiblenamear=responsiblenamear;
        this.conventionCollection=conventionCollection;
    }

}
