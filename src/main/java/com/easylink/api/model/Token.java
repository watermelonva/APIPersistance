/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "TOKEN")
@XmlRootElement
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TOKENID")
    private Integer tokenid;
    @JoinColumn(name = "USERTOKEN", referencedColumnName = "USERID")
    @ManyToOne
    private User usertoken;
    //0:ios
    //1:android
    @Column(name = "OS")
    private Short os;

    public Token() {
    }

    public Token(User usertoken, Short os) {
        this.usertoken = usertoken;
        this.os = os;
    }

    public Integer getTokenid() {
        return tokenid;
    }

    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public User getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(User usertoken) {
        this.usertoken = usertoken;
    }

    public Short getOs() {
        return os;
    }

    public void setOs(Short os) {
        this.os = os;
    }
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenid != null ? tokenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.tokenid, other.tokenid)) {
            return false;
        }
        return true;
    }

 
    

}
