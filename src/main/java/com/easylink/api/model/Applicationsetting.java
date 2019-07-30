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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "APPLICATIONSETTING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applicationsetting.findAll", query = "SELECT a FROM Applicationsetting a"),
    @NamedQuery(name = "Applicationsetting.findByApplicationsettingid", query = "SELECT a FROM Applicationsetting a WHERE a.applicationsettingid = :applicationsettingid"),
    @NamedQuery(name = "Applicationsetting.findBySettingname", query = "SELECT a FROM Applicationsetting a WHERE a.settingname = :settingname AND a.amicaleid = :amicale"),
    @NamedQuery(name = "Applicationsetting.findByOneParam", query = "SELECT a.settingvalue FROM Applicationsetting a WHERE a.settingname = :subscriptionamount AND a.amicaleid = :amicale"),
    @NamedQuery(name = "Applicationsetting.findBySettingvalue", query = "SELECT a FROM Applicationsetting a WHERE a.settingvalue = :settingvalue")})
public class Applicationsetting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "APPLICATIONSETTINGID")
    private Integer applicationsettingid;
    @Size(max = 255)
    @Column(name = "SETTINGNAME")
    private String settingname;
    @Size(max = 255)
    @Column(name = "SETTINGVALUE")
    private String settingvalue;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne
    private Amicale amicaleid;
    //we have 3 cases(0:bCK is required,1:optionel,2:we don't use it)
    @Transient
    private Short birthCertificateKids;
    //application config for manage budget
    //we have 3 subscripton types:
    //0:only cash
    //1:only tranch payment
    //2: cash & tranche payment
    @Transient
    private Short financeAccountingModule;
    @Transient
    private Short subscriptionType;
    @Transient
    private Short subscriptionPeriod;
    @Transient
    private Short BudgetModule;
    @Transient
    private Short NumBooksDelivery;
    @Transient
    private Short BooksDeadine;
    @Transient
    private Short CommandType;
    @Transient
    private Double AmountTicket;
    @Transient
    private Double ParticipationTicket;
    @Transient
    private Short WorkingWeekend;
    @Transient
    private Short ManageParticipation;
    @Transient
    private Short DelegationWithDrawal;
    @Transient
    private Short EventModule;
    @Transient
    private Short ConventionModule;
    @Transient
    private Short TypeBook;
    @Transient
    private int FixedQuantityTickets;
    @Transient
    private Short editMealTickets;
    @Transient
    private Short autoPrintVoucherResto;
    @Transient
    private Short mealTicketsDistribution;
    @Transient
    private Short credit;
    @Transient
    private Float creaditmax;
    @Transient
    private Short creditecheance;
    @Transient
    private Short AidesModule;
    @Transient
    private Short manageFamily;
    @Transient
    private Short validationFamily;
    @Transient
    private Short buyConfirmPWD;
    @Transient
    private Short buyConfirmSMS;

    //ooredoo Module config
    @Transient
    private Short withNotAutoValidation;
    @Transient
    private Short ooredooOneCommandPerDuration;

    //R.R can manage transaction, convention,event  for his center
    @Transient
    private Short manageTransactionByRR;
    @Transient
    private Short manageConventionByRR;
    @Transient
    private Short manageEventByRR;
    @Transient
    private Short manageProviderByRR;
//limit of months to start listing
    @Transient
    private Short listingMonthsMin;
    //limit of months to start listing
    @Transient
    private Short listingMonthsMax;
    //ThresholdType 
    @Transient
    private Short ThresholdType;
    //retired age
    @Transient
    private Short RetireAge;
    @Transient
    private Short LengthCnrps;
    @Transient
    private Short distributeByDr;

    public Short getDistributeByDr() {
        return distributeByDr;
    }

    public void setDistributeByDr(Short distributeByRR) {
        this.distributeByDr = distributeByRR;
    }

    public Short getLengthCnrps() {
        return LengthCnrps;
    }

    public void setLengthCnrps(Short LengthCnrps) {
        this.LengthCnrps = LengthCnrps;
    }
    
    

    public Short getRetireAge() {
        return RetireAge;
    }

    public void setRetireAge(Short RetireAge) {
        this.RetireAge = RetireAge;
    }

    public Short getThresholdType() {
        return ThresholdType;
    }

    public void setThresholdType(Short ThresholdType) {
        this.ThresholdType = ThresholdType;
    }

    public Short getManageTransactionByRR() {
        return manageTransactionByRR;
    }

    public void setManageTransactionByRR(Short manageTransactionByRR) {
        this.manageTransactionByRR = manageTransactionByRR;
    }

    public Short getListingMonthsMin() {
        return listingMonthsMin;
    }

    public void setListingMonthsMin(Short listingMonthsMin) {
        this.listingMonthsMin = listingMonthsMin;
    }

    public Short getListingMonthsMax() {
        return listingMonthsMax;
    }

    public void setListingMonthsMax(Short listingMonthsMax) {
        this.listingMonthsMax = listingMonthsMax;
    }

 

    public Short getManageConventionByRR() {
        return manageConventionByRR;
    }

    public void setManageConventionByRR(Short manageConventionByRR) {
        this.manageConventionByRR = manageConventionByRR;
    }

    public Short getManageEventByRR() {
        return manageEventByRR;
    }

    public void setManageEventByRR(Short manageEventByRR) {
        this.manageEventByRR = manageEventByRR;
    }

    public Short getManageProviderByRR() {
        return manageProviderByRR;
    }

    public void setManageProviderByRR(Short manageProviderByRR) {
        this.manageProviderByRR = manageProviderByRR;
    }

    public Short getWithNotAutoValidation() {
        return withNotAutoValidation;
    }

    public void setWithNotAutoValidation(Short withNotAutoValidation) {
        this.withNotAutoValidation = withNotAutoValidation;
    }

    public Short getOoredooOneCommandPerDuration() {
        return ooredooOneCommandPerDuration;
    }

    public void setOoredooOneCommandPerDuration(Short ooredooOneCommandPerDuration) {
        this.ooredooOneCommandPerDuration = ooredooOneCommandPerDuration;
    }

    public Short getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(Short subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Short getValidationFamily() {
        return validationFamily;
    }

    public void setValidationFamily(Short validationFamily) {
        this.validationFamily = validationFamily;
    }

    public Short getBirthCertificateKids() {
        return birthCertificateKids;
    }

    public void setBirthCertificateKids(Short birthCertificateKids) {
        this.birthCertificateKids = birthCertificateKids;
    }

    public Short getBuyConfirmPWD() {
        return buyConfirmPWD;
    }

    public void setBuyConfirmPWD(Short buyConfirmPWD) {
        this.buyConfirmPWD = buyConfirmPWD;
    }

    public Short getBuyConfirmSMS() {
        return buyConfirmSMS;
    }

    public void setBuyConfirmSMS(Short buyConfirmSMS) {
        this.buyConfirmSMS = buyConfirmSMS;
    }

    public Short getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(Short subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
    }

    public Short getManageFamily() {
        return manageFamily;
    }

    public void setManageFamily(Short ManageFamily) {
        this.manageFamily = ManageFamily;
    }

    public Short getAidesModule() {
        return AidesModule;
    }

    public void setAidesModule(Short AidesModule) {
        this.AidesModule = AidesModule;
    }

    public Short getCredit() {
        return credit;
    }

    public void setCredit(Short credit) {
        this.credit = credit;
    }

    public Short getFinanceAccountingModule() {
        return financeAccountingModule;
    }

    public void setFinanceAccountingModule(Short financeAccountingModule) {
        this.financeAccountingModule = financeAccountingModule;
    }

    public float getCreaditmax() {
        return creaditmax;
    }

    public void setCreaditmax(float creaditmax) {
        this.creaditmax = creaditmax;
    }

    public Short getCreditecheance() {
        return creditecheance;
    }

    public void setCreditecheance(Short creditecheance) {
        this.creditecheance = creditecheance;
    }

    public Applicationsetting() {
    }

    public Applicationsetting(Integer applicationsettingid) {
        this.applicationsettingid = applicationsettingid;
    }

    public Applicationsetting(String settingname, String settingvalue, Amicale amicaleid) {
        this.settingname = settingname;
        this.settingvalue = settingvalue;
        this.amicaleid = amicaleid;
    }

    public Integer getApplicationsettingid() {
        return applicationsettingid;
    }

    public void setApplicationsettingid(Integer applicationsettingid) {
        this.applicationsettingid = applicationsettingid;
    }

    public Short getMealTicketsDistribution() {
        return mealTicketsDistribution;
    }

    public void setMealTicketsDistribution(Short mealTicketsDistribution) {
        this.mealTicketsDistribution = mealTicketsDistribution;
    }

    public Short getTypeBook() {
        return TypeBook;
    }

    public void setTypeBook(Short TypeBook) {
        this.TypeBook = TypeBook;
    }

    public int getFixedQuantityTickets() {
        return FixedQuantityTickets;
    }

    public void setFixedQuantityTickets(int FixedQuantityTickets) {
        this.FixedQuantityTickets = FixedQuantityTickets;
    }

    public Short getBudgetModule() {
        return BudgetModule;
    }

    public void setBudgetModule(Short BudgetModule) {
        this.BudgetModule = BudgetModule;
    }

    public Short getNumBooksDelivery() {
        return NumBooksDelivery;
    }

    public void setNumBooksDelivery(Short NumBooksDelivery) {
        this.NumBooksDelivery = NumBooksDelivery;
    }

    public Short getBooksDeadine() {
        return BooksDeadine;
    }

    public void setBooksDeadine(Short BooksDeadine) {
        this.BooksDeadine = BooksDeadine;
    }

    public Short getCommandType() {
        return CommandType;
    }

    public void setCommandType(Short CommandType) {
        this.CommandType = CommandType;
    }

    public Double getAmountTicket() {
        return AmountTicket;
    }

    public void setAmountTicket(Double AmountTicket) {
        this.AmountTicket = AmountTicket;
    }

    public Double getParticipationTicket() {
        return ParticipationTicket;
    }

    public void setParticipationTicket(Double ParticipationTicket) {
        this.ParticipationTicket = ParticipationTicket;
    }

    public Short getWorkingWeekend() {
        return WorkingWeekend;
    }

    public void setWorkingWeekend(Short WorkingWeekend) {
        this.WorkingWeekend = WorkingWeekend;
    }

    public Short getManageParticipation() {
        return ManageParticipation;
    }

    public void setManageParticipation(Short ManageParticipation) {
        this.ManageParticipation = ManageParticipation;
    }

    public Short getDelegationWithDrawal() {
        return DelegationWithDrawal;
    }

    public void setDelegationWithDrawal(Short DelegationWithDrawal) {
        this.DelegationWithDrawal = DelegationWithDrawal;
    }

    public String getSettingname() {
        return settingname;
    }

    public void setSettingname(String settingname) {
        this.settingname = settingname;
    }

    public String getSettingvalue() {
        return settingvalue;
    }

    public void setSettingvalue(String settingvalue) {
        this.settingvalue = settingvalue;
    }

    public Short getEventModule() {
        return EventModule;
    }

    public void setEventModule(Short EventModule) {
        this.EventModule = EventModule;
    }

    public Short getConventionModule() {
        return ConventionModule;
    }

    public void setConventionModule(Short ConventionModule) {
        this.ConventionModule = ConventionModule;
    }

    public Short getAutoPrintVoucherResto() {
        return autoPrintVoucherResto;
    }

    public void setAutoPrintVoucherResto(Short autoPrintVoucherResto) {
        this.autoPrintVoucherResto = autoPrintVoucherResto;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Short getEditMealTickets() {
        return editMealTickets;
    }

    public void setEditMealTickets(Short editMealTickets) {
        this.editMealTickets = editMealTickets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationsettingid != null ? applicationsettingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicationsetting)) {
            return false;
        }
        Applicationsetting other = (Applicationsetting) object;
        if ((this.applicationsettingid == null && other.applicationsettingid != null) || (this.applicationsettingid != null && !this.applicationsettingid.equals(other.applicationsettingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Applicationsetting[ applicationsettingid=" + applicationsettingid + " ]";
    }

}
