package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bankaccount database table.
 * 
 */
@Entity
@Table(name="bankaccount")
@NamedQuery(name="Bankaccount.findAll", query="SELECT b FROM Bankaccount b")
public class Bankaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BANKACCOUNTID")
	private Integer bankaccountid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ADDEDDATE")
	private Date addeddate;

	@Column(name="AGENCE")
	private String agence;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DELETEDDATE")
	private Date deleteddate;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FAX")
	private String fax;

	@Column(name="ISDELETED")
	private Short isdeleted;

	@Column(name="NAME")
	private String name;

	@Column(name="PHONE")
	private String phone;

	@Column(name="RIB")
	private String rib;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDEDBY")
	private User user1;

	//bi-directional many-to-one association to Amicale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AMICALEID")
	private Amicale amicale1;

	//bi-directional many-to-one association to Bank
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANKID")
	private Bank bank1;


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DELETEDBY")
	private User user4;

	public Bankaccount() {
	}

	public int getBankaccountid() {
		return this.bankaccountid;
	}

	public void setBankaccountid(int bankaccountid) {
		this.bankaccountid = bankaccountid;
	}

	public Date getAddeddate() {
		return this.addeddate;
	}

	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}

	public String getAgence() {
		return this.agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public Date getDeleteddate() {
		return this.deleteddate;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public short getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(short isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRib() {
		return this.rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public Amicale getAmicale1() {
		return this.amicale1;
	}

	public void setAmicale1(Amicale amicale1) {
		this.amicale1 = amicale1;
	}

	public Bank getBank1() {
		return this.bank1;
	}

	public void setBank1(Bank bank1) {
		this.bank1 = bank1;
	}
		
	
	public User getUser4() {
		return this.user4;
	}

	public void setUser4(User user4) {
		this.user4 = user4;
	}

}