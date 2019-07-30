package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the handfree_transaction database table.
 * 
 */
@Entity
@Table(name="handfree_transaction")
@NamedQuery(name="HandfreeTransaction.findAll", query="SELECT h FROM HandfreeTransaction h")
public class HandfreeTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HFTID")
	private Integer hftid;

	@Column(name="AMOUNT")
	private Double amount;

	//bi-directional many-to-one association to Transaction
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTIONID")
	private Transaction transaction;

	//bi-directional many-to-one association to HandFree
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HANDFREEID")
	private HandFree handFree;

	public HandfreeTransaction() {
	}

	public int getHftid() {
		return this.hftid;
	}

	public void setHftid(int hftid) {
		this.hftid = hftid;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public HandFree getHandFree() {
		return this.handFree;
	}

	public void setHandFree(HandFree handFree) {
		this.handFree = handFree;
	}

}