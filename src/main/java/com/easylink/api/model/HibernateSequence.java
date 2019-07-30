package com.easylink.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the hibernate_sequence database table.
 * 
 */

public class HibernateSequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="next_val")
	private BigInteger nextVal;

	public HibernateSequence() {
	}

	public BigInteger getNextVal() {
		return this.nextVal;
	}

	public void setNextVal(BigInteger nextVal) {
		this.nextVal = nextVal;
	}

}