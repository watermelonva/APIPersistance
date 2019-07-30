package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the carnet database table.
 * 
 */
@Entity
@Table(name="carnet")
@NamedQuery(name="Carnet.findAll", query="SELECT c FROM Carnet c")
public class Carnet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARNETID")
	private Integer carnetid;

	@Column(name="AMOUNT")
	private Double amount;

	@Column(name="RECOVERED")
	private Byte recovered;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RECOVEREDTIME")
	private Date recoveredtime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERCARNET")
	private User user;

	public Carnet() {
	}

	public int getCarnetid() {
		return this.carnetid;
	}

	public void setCarnetid(int carnetid) {
		this.carnetid = carnetid;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public byte getRecovered() {
		return this.recovered;
	}

	public void setRecovered(byte recovered) {
		this.recovered = recovered;
	}

	public Date getRecoveredtime() {
		return this.recoveredtime;
	}

	public void setRecoveredtime(Date recoveredtime) {
		this.recoveredtime = recoveredtime;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}