package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the regulation database table.
 * 
 */
@Entity
@Table(name="regulation")
@NamedQuery(name="Regulation.findAll", query="SELECT r FROM Regulation r")
public class Regulation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REGULATIONID")
	private Integer regulationid;

	@Column(name="AMICALE")
	private Integer amicale;

	@Column(name="AMOUNT")
	private Double amount;

	@Column(name="BANK")
	private String bank;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DEADLINE")
	private Date deadline;

	@Column(name="REFRENCE")
	private String refrence;

	@Column(name="RESTAMOUNT")
	private Double restamount;

	@Column(name="STATUS")
	private Short status;

	@Column(name="TITLE")
	private String title;

	@Column(name="TYPE")
	private Short type;

	public Regulation() {
	}

	public int getRegulationid() {
		return this.regulationid;
	}

	public void setRegulationid(int regulationid) {
		this.regulationid = regulationid;
	}

	public int getAmicale() {
		return this.amicale;
	}

	public void setAmicale(int amicale) {
		this.amicale = amicale;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getRefrence() {
		return this.refrence;
	}

	public void setRefrence(String refrence) {
		this.refrence = refrence;
	}

	public double getRestamount() {
		return this.restamount;
	}

	public void setRestamount(double restamount) {
		this.restamount = restamount;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

}