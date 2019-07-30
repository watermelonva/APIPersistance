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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adeveganet
 */
@Entity
@Table(name = "CONTACT")
@XmlRootElement
public class Contact implements Serializable {
      private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACTID")
    private Integer contactid;
    @Size(max = 50, min = 1, message = "Intitulé invalide.")
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50, min = 1, message = "Téléphone invalide.")
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 255, message = "Adresse invalide.")
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50, message = "Ville invalide.")
    @Column(name = "CITY")
    private String city;
    @Size(max = 50, message = "Code postal invalide.")
    @Column(name = "CODE")
    private String code;
    @JoinColumn(name = "CONVENTIONC", referencedColumnName = "CONVETIONID")
    @ManyToOne
    private Convention conventionc;
    @Transient
    private Boolean isDeleted;

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Convention getConventionc() {
        return conventionc;
    }

    public void setConventionc(Convention conventionc) {
        this.conventionc = conventionc;
    }

}
