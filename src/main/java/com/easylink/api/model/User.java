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
import javax.persistence.FetchType;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "USER")
@XmlRootElement

public class User implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEALTICKET")
    private Integer mealticket;
    @OneToMany(mappedBy = "addedby", fetch = FetchType.LAZY)
    private Collection<Comptimputation> comptimputationCollection;
    @OneToMany(mappedBy = "deletedby", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection;
    @OneToMany(mappedBy = "adherent", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection1;
    @OneToMany(mappedBy = "addedby", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection2;
    @OneToMany(mappedBy = "deletedby", fetch = FetchType.LAZY)
    private Collection<Invoice> invoiceCollection;
    @OneToMany(mappedBy = "addedby", fetch = FetchType.LAZY)
    private Collection<Invoice> invoiceCollection1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 50)
    @Column(name = "FIRSTNAMEAR")
    private String firstnamear;
    @Size(max = 50)
    @Column(name = "LASTNAMEAR")
    private String lastnamear;
    @Column(name = "GENDER")
    private Short gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Column(name = "SHOPID", length = 20)
    private String shopid;
    @Basic(optional = false)
    @Size(max = 50)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Size(max = 200)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PROVISIONALPWD")
    private Short provisionalpwd;
    @Size(max = 10)
    @Column(name = "CIN")
    private String cin;
    @Column(name = "DATECIN")
    @Temporal(TemporalType.DATE)
    private Date datecin;
    @Size(max = 255)
    @Column(name = "CINPATH1")
    private String cinpath1;
    @Size(max = 255)
    @Column(name = "CINPATH2")
    private String cinpath2;
    @Size(max = 30)
    @Column(name = "CNPRS")
    private String cnprs;
    @Size(max = 50)
    @Column(name = "PHONE1")
    private String phone1;
    @Size(max = 50)
    @Column(name = "PHONE2")
    private String phone2;
    @Size(max = 200)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "CITY")
    private String city;
    @Size(max = 200)
    @Column(name = "JOB")
    private String job;
    @Size(max = 50)
    @Column(name = "JOBAR")
    private String jobar;
    @Size(max = 255)
    @Column(name = "PICTURE")
    private String picture;
    @Size(max = 50)
    @Column(name = "PHONE_LOGIN")
    private String phonelogin;

    /**
     * 8:user work in agence ooredoo
     */
    @Column(name = "ACCESSLEVEL")
    private Short accesslevel;
    //seuil par adherent
    @Column(name = "THRESHOLD")
    private Double threshold;
    @Column(name = "ADMINACCESSLEVEL")
    private Short adminaccesslevel;
    @Column(name = "ISCOMMERCIAL")
    private Short iscommercial;
    @Size(max = 20)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "SUBSCRIPTIONPAYMENT")
    private Short subscriptiontype;
    @Column(name = "ADDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;
    @Column(name = "ISACTIF")
    private Short isactif;
    @Column(name = "USINGCONDITIONS")
    private Boolean usingconditions;
    @Column(name = "BLACKLIST")
    private Short blacklist;
    @Size(max = 255)
    @Column(name = "RETIREDFILE")
    private String retiredfile;
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Collection<Family> familyCollection;
    @OneToMany(mappedBy = "usertoken", fetch = FetchType.LAZY)
    private Collection<Token> tokenCollection;
    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Event> eventCollection;
    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Convention> conventionCollection;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Subscription> subscriptionCollection;
    @OneToMany(mappedBy = "rejectedby", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection;
    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection1;
    @OneToMany(mappedBy = "relateduser", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection2;
    @OneToMany(mappedBy = "addedby", fetch = FetchType.LAZY)
    private Collection<User> userCollection;
    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Command> commandCollection;
    @OneToMany(mappedBy = "deliveredto", fetch = FetchType.LAZY)
    private Collection<Mealtransaction> deliveredtoCollection;
    @OneToMany(mappedBy = "deletedby", fetch = FetchType.LAZY)
    private Collection<Family> deletedFamilyCollection;
    @OneToMany(mappedBy = "deletedby", fetch = FetchType.LAZY)
    private Collection<Center> deletedCenterCollection;

    @JoinColumn(name = "ADDEDBY", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User addedby;

    @JoinColumn(name = "CENTER", referencedColumnName = "CENTERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Center center;

    @OneToMany(mappedBy = "delegation", fetch = FetchType.LAZY)
    private Collection<User> delegationCollection;

    @JoinColumn(name = "DELEGATION", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User delegation;

    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private Collection<Mealtransaction> mealtransactionCollection;

    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Mealtransaction> mealtransactioncreaedCollection;

    @OneToMany(mappedBy = "createdby", fetch = FetchType.LAZY)
    private Collection<Provider> providercreaedCollection;

    @OneToMany(mappedBy = "nrelateduser", fetch = FetchType.LAZY)
    private Collection<Notification> notificationCollection;
    @OneToMany(mappedBy = "nrelateduser2", fetch = FetchType.LAZY)
    private Collection<Claim> claimCollection;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Globalnotification> globalnotificationCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Amicale amicaleid;
    @OneToMany(mappedBy = "president", fetch = FetchType.LAZY)
    private Collection<Amicale> presidentCollection;
    @OneToMany(mappedBy = "df", fetch = FetchType.LAZY)
    private Collection<Amicale> dfCollection;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User deletedby;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteddate;
    @JoinColumn(name = "DEPARTMENT", referencedColumnName = "DEPARTMENTID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @JoinColumn(name = "CATEGORYAMICALE", referencedColumnName = "CATEGORYAMICALEID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryAmicale categoryamicale;
    @Column(name = "RETIREDATE")
    @Temporal(TemporalType.DATE)
    private Date retiredate;

    //ooredoo
    @JoinColumn(name = "AGENCY", referencedColumnName = "AGENCYID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agency agencyid;
    @Size(max = 50)
    @Column(name = "GOVERNORATE")
    private String governorate;
    @Size(max = 10)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 255)
    @Column(name = "INTERNALID")
    private String internalid;
    @Column(name = "ISVALIDATED")
    private Short isvalidated;

    @Column(name = "MALL_STATUS")
    private Short mallStatus;



    public Short getIsvalidated() {
        return isvalidated;
    }

    public void setIsvalidated(Short isvalidated) {
        this.isvalidated = isvalidated;
    }

    public String getInternalid() {
        return internalid;
    }

    public void setInternalid(String internalid) {
        this.internalid = internalid;
    }



    public Agency getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(Agency agencyid) {
        this.agencyid = agencyid;
    }

    public Short getIscommercial() {
        return iscommercial;
    }

    public void setIscommercial(Short iscommercial) {
        this.iscommercial = iscommercial;
    }

    public CategoryAmicale getCategoryamicale() {
        return categoryamicale;
    }

    public void setCategoryamicale(CategoryAmicale categoryamicale) {
        this.categoryamicale = categoryamicale;
    }

    @Transient
    private String birthdate;
    @Transient
    private String cindate;
    @JoinColumn(name = "PROVIDERROOTID", referencedColumnName = "PROVIDERROOTID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProviderRoot providerrootid;
    @Transient
    private Short hideCinCnrps;

    public User(String firstname, String lastname, String firstnamear, String lastnamear, Date birthDay, String cin, String cnprs, String phone_login, Double threshold, Amicale amicaleid, short hideCinCnrps) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstnamear = firstnamear;
        this.lastnamear = lastnamear;
        this.birthDay = birthDay;
        this.cin = cin;
        this.cnprs = cnprs;
        this.phone1 = phone1;
        this.phonelogin = phone_login;
        this.threshold = threshold;
        this.amicaleid = amicaleid;
        this.hideCinCnrps = hideCinCnrps;
    }

    public User(String firstname, String lastname, String firstnamear, String lastnamear, Date birthDay, String cin, String cnprs, String phone_login, Double threshold, Amicale amicaleid, short hideCinCnrps, CategoryAmicale categoryAmicale) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstnamear = firstnamear;
        this.lastnamear = lastnamear;
        this.birthDay = birthDay;
        this.cin = cin;
        this.cnprs = cnprs;
        this.phone1 = phone1;
        this.phonelogin = phone_login;
        this.threshold = threshold;
        this.amicaleid = amicaleid;
        this.hideCinCnrps = hideCinCnrps;
        this.categoryamicale = categoryAmicale;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public short getHideCinCnrps() {
        return hideCinCnrps;
    }

    public void setHideCinCnrps(short hideCinCnrps) {
        this.hideCinCnrps = hideCinCnrps;
    }

    public Short getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Short blacklist) {
        this.blacklist = blacklist;
    }

    public boolean getUsingconditions() {
        return usingconditions;
    }

    public void setUsingconditions(boolean usingconditions) {
        this.usingconditions = usingconditions;
    }

    public ProviderRoot getProviderrootid() {
        return providerrootid;
    }

    public void setProviderrootid(ProviderRoot providerrootid) {
        this.providerrootid = providerrootid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCindate() {
        return cindate;
    }

    public void setCindate(String cindate) {
        this.cindate = cindate;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Date getRetiredate() {
        return retiredate;
    }

    public void setRetiredate(Date retiredate) {
        this.retiredate = retiredate;
    }

    public Collection<Amicale> getDfCollection() {
        return dfCollection;
    }

    public void setDfCollection(Collection<Amicale> dfCollection) {
        this.dfCollection = dfCollection;
    }

    @XmlTransient
    public Collection<Token> getTokenCollection() {
        return tokenCollection;
    }

    public void setTokenCollection(Collection<Token> tokenCollection) {
        this.tokenCollection = tokenCollection;
    }

    @XmlTransient
    public Collection<Command> getCommandCollection() {
        return commandCollection;
    }

    @XmlTransient
    public Collection<Family> getDeletedFamilyCollection() {
        return deletedFamilyCollection;
    }

    public void setDeletedFamilyCollection(Collection<Family> deletedFamilyCollection) {
        this.deletedFamilyCollection = deletedFamilyCollection;
    }

    public Collection<Center> getDeletedCenterCollection() {
        return deletedCenterCollection;
    }

    public void setDeletedCenterCollection(Collection<Center> deletedCenterCollection) {
        this.deletedCenterCollection = deletedCenterCollection;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    @XmlTransient
    public Collection<Provider> getProvidercreaedCollection() {
        return providercreaedCollection;
    }

    public void setProvidercreaedCollection(Collection<Provider> providercreaedCollection) {
        this.providercreaedCollection = providercreaedCollection;
    }

    public void setCommandCollection(Collection<Command> commandCollection) {
        this.commandCollection = commandCollection;
    }

    @XmlTransient
    public Collection<Mealtransaction> getDeliveredtoCollection() {
        return deliveredtoCollection;
    }

    public void setDeliveredtoCollection(Collection<Mealtransaction> deliveredtoCollection) {
        this.deliveredtoCollection = deliveredtoCollection;
    }

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
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

    public User(Integer userid, String login, String password) {
        this.userid = userid;
        this.login = login;
        this.password = password;
    }

    @XmlTransient
    public Collection<Mealtransaction> getMealtransactioncreaedCollection() {
        return mealtransactioncreaedCollection;
    }

    public void setMealtransactioncreaedCollection(Collection<Mealtransaction> mealtransactioncreaedCollection) {
        this.mealtransactioncreaedCollection = mealtransactioncreaedCollection;
    }

    @XmlTransient
    public Collection<Globalnotification> getGlobalnotificationCollection() {
        return globalnotificationCollection;
    }

    public void setGlobalnotificationCollection(Collection<Globalnotification> globalnotificationCollection) {
        this.globalnotificationCollection = globalnotificationCollection;
    }

    @XmlTransient
    public Collection<Amicale> getPresidentCollection() {
        return presidentCollection;
    }

    public void setPresidentCollection(Collection<Amicale> presidentCollection) {
        this.presidentCollection = presidentCollection;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstnamear() {
        return firstnamear;
    }

    public void setFirstnamear(String firstnamear) {
        this.firstnamear = firstnamear;
    }

    public String getLastnamear() {
        return lastnamear;
    }

    public void setLastnamear(String lastnamear) {
        this.lastnamear = lastnamear;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDatecin() {
        return datecin;
    }

    public void setDatecin(Date datecin) {
        this.datecin = datecin;
    }

    public String getCinpath1() {
        return cinpath1;
    }

    public void setCinpath1(String cinpath1) {
        this.cinpath1 = cinpath1;
    }

    public String getCinpath2() {
        return cinpath2;
    }

    public void setCinpath2(String cinpath2) {
        this.cinpath2 = cinpath2;
    }

    public String getCnprs() {
        return cnprs;
    }

    public void setCnprs(String cnprs) {
        this.cnprs = cnprs;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhonelogin() {
        return phonelogin;
    }

    public void setPhonelogin(String phonelogin) {
        this.phonelogin = phonelogin;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobar() {
        return jobar;
    }

    public void setJobar(String jobar) {
        this.jobar = jobar;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Short getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Short accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Short getAdminaccesslevel() {
        return adminaccesslevel;
    }

    public void setAdminaccesslevel(Short adminaccesslevel) {
        this.adminaccesslevel = adminaccesslevel;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getSubscriptiontype() {
        return subscriptiontype;
    }

    public void setSubscriptiontype(Short subscriptionpayment) {
        this.subscriptiontype = subscriptionpayment;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Short getIsactif() {
        return isactif;
    }

    public void setIsactif(Short isactif) {
        this.isactif = isactif;
    }

    @XmlTransient
    public Collection<User> getDelegationCollection() {
        return delegationCollection;
    }

    public void setDelegationCollection(Collection<User> delegationCollection) {
        this.delegationCollection = delegationCollection;
    }

    public User getDelegation() {
        return delegation;
    }

    public void setDelegation(User delegation) {
        this.delegation = delegation;
    }

    public String getRetiredfile() {
        return retiredfile;
    }

    public void setRetiredfile(String retiredfile) {
        this.retiredfile = retiredfile;
    }

    @XmlTransient
    public Collection<Family> getFamilyCollection() {
        return familyCollection;
    }

    public void setFamilyCollection(Collection<Family> familyCollection) {
        this.familyCollection = familyCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<Convention> getConventionCollection() {
        return conventionCollection;
    }

    public void setConventionCollection(Collection<Convention> conventionCollection) {
        this.conventionCollection = conventionCollection;
    }

    @XmlTransient
    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
    }

    public void addSubscriptionToList(Subscription subscription) {
        subscriptionCollection.add(subscription);
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection1() {
        return transactionCollection1;
    }

    public void setTransactionCollection1(Collection<Transaction> transactionCollection1) {
        this.transactionCollection1 = transactionCollection1;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection2() {
        return transactionCollection2;
    }

    public void setTransactionCollection2(Collection<Transaction> transactionCollection2) {
        this.transactionCollection2 = transactionCollection2;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public User getAddedby() {
        return addedby;
    }

    public void setAddedby(User addedby) {
        this.addedby = addedby;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Short getProvisionalpwd() {
        return provisionalpwd;
    }

    public void setProvisionalpwd(Short provisionalpwd) {
        this.provisionalpwd = provisionalpwd;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.accesslevel == 8 || this.accesslevel == 9 || this.accesslevel == 10) {
            return login + " ";

        } else {
            return firstname + " " + lastname + " " + cnprs;

        }
    }

    public String getFirstName_LastName() {
        return this.firstname + "_" + this.lastname;
    }

    public String getFirstNameLastName() {
        return this.firstname + " " + this.lastname;
    }

    @XmlTransient
    public Collection<Mealtransaction> getMealtransactionCollection() {
        return mealtransactionCollection;
    }

    public void setMealtransactionCollection(Collection<Mealtransaction> mealtransactionCollection) {
        this.mealtransactionCollection = mealtransactionCollection;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public int getMealticket() {
        return mealticket;
    }

    public void setMealticket(int mealticket) {
        this.mealticket = mealticket;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @XmlTransient
    public Collection<Comptimputation> getComptimputationCollection() {
        return comptimputationCollection;
    }

    public void setComptimputationCollection(Collection<Comptimputation> comptimputationCollection) {
        this.comptimputationCollection = comptimputationCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection1() {
        return paymentCollection1;
    }

    public void setPaymentCollection1(Collection<Payment> paymentCollection1) {
        this.paymentCollection1 = paymentCollection1;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection2() {
        return paymentCollection2;
    }

    public void setPaymentCollection2(Collection<Payment> paymentCollection2) {
        this.paymentCollection2 = paymentCollection2;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection1() {
        return invoiceCollection1;
    }

    public void setInvoiceCollection1(Collection<Invoice> invoiceCollection1) {
        this.invoiceCollection1 = invoiceCollection1;
    }

    /**
     * @return the mallStatus
     */
    public Short getMallStatus() {
        return mallStatus;
    }

    /**
     * @param mallStatus the mallStatus to set
     */
    public void setMallStatus(Short mallStatus) {
        this.mallStatus = mallStatus;
    }



}
