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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamel TRIMECHE
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROOMID")
    private Integer roomid;
    @Column(name = "NBADULT")
    private Integer nbadult;
    @Column(name = "NBCHILDREN")
    private Integer nbchildren;
    @Column(name = "AGECHILD1")
    private Integer agechild1;
    @Column(name = "AGECHILD2")
    private Integer agechild2;
    @Column(name = "AGECHILD3")
    private Integer agechild3;
    @Column(name = "AGECHILD4")
    private Integer agechild4;
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "TRANSACTIONID")
    @ManyToOne
    private Transaction transactionid;

    public Transaction getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transaction transactionid) {
        this.transactionid = transactionid;
    }
    

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getNbadult() {
        return nbadult;
    }

    public void setNbadult(Integer nbadult) {
        this.nbadult = nbadult;
    }

    public Integer getNbchildren() {
        return nbchildren;
    }

    public void setNbchildren(Integer nbchildren) {
        this.nbchildren = nbchildren;
    }

    public Integer getAgechild1() {
        return agechild1;
    }

    public void setAgechild1(Integer agechild1) {
        this.agechild1 = agechild1;
    }

    public Integer getAgechild2() {
        return agechild2;
    }

    public void setAgechild2(Integer agechild2) {
        this.agechild2 = agechild2;
    }

    public Integer getAgechild3() {
        return agechild3;
    }

    public void setAgechild3(Integer agechild3) {
        this.agechild3 = agechild3;
    }

    public Integer getAgechild4() {
        return agechild4;
    }

    public void setAgechild4(Integer agechild4) {
        this.agechild4 = agechild4;
    }
    
    

}
