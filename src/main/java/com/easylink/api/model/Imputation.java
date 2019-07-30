package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imputation database table.
 * 
 */
@Entity
@Table(name="imputation")
@NamedQuery(name="Imputation.findAll", query="SELECT i FROM Imputation i")
public class Imputation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMPUTATIONID")
	private int imputationid;

	@Column(name="AMICALE")
	private int amicale;

	@Column(name="AMOUNT")
	private Double amount;

	@Column(name="COMMANDID")
	private Integer commandid;

	@Column(name="REGULATIONID")
	private Integer regulationid;

	public Imputation() {
	}

	public int getImputationid() {
		return this.imputationid;
	}

	public void setImputationid(int imputationid) {
		this.imputationid = imputationid;
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

	public int getCommandid() {
		return this.commandid;
	}

	public void setCommandid(int commandid) {
		this.commandid = commandid;
	}

	public int getRegulationid() {
		return this.regulationid;
	}

	public void setRegulationid(int regulationid) {
		this.regulationid = regulationid;
	}

}