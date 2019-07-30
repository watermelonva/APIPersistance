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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "Hotel")
@XmlRootElement
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HOTELID")
    private Integer hotelid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "PLACE")
    private String place;
    @Size(max = 255)
    @Column(name = "AGENCY")
    private String agency;
    @Size(max = 255)
    @Column(name = "URL")
    private String url;
    @Column(name = "STARS")
    private String stars;
    @JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
    @ManyToOne
    private Event eventid;
    @Column(name = "LPD")
    private Boolean lpd;
    @Column(name = "DO")
    private Boolean dp;
    @Column(name = "PC")
    private Boolean pc;
    @Column(name = "ALLIN")
    private Boolean allin;

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
    }

    public Boolean isLpd() {
        return lpd;
    }

    public void setLpd(Boolean lpd) {
        this.lpd = lpd;
    }

    public Boolean isDp() {
        return dp;
    }

    public void setDp(Boolean dp) {
        this.dp = dp;
    }

    public Boolean isPc() {
        return pc;
    }

    public void setPc(Boolean pc) {
        this.pc = pc;
    }

    public Boolean isAllin() {
        return allin;
    }

    public void setAllin(Boolean allin) {
        this.allin = allin;
    }
    
    @Override
    public String toString() {
        return name+" "+stars+"*";
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelid != null ? hotelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelid == null && other.hotelid != null) || (this.hotelid != null && !this.hotelid.equals(other.hotelid))) {
            return false;
        }
        return true;
    }
    
    

}
