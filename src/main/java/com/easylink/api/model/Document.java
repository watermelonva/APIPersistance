/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ade
 */
@Entity
@Table(name = "DOCUMENT")
@XmlRootElement


public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DOCUMENTID")
    private Integer documentid;
    @Size(max = 255)
    @Column(name = "PATH")
    private String path;
    @Size(max = 50)
    @Column(name = "DOCUMENTNAME")
    private String documentName;
    @Column(name = "TYPEDOCUMENT")
    private Short typedocument;
    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
    private Collection<Contain> containCollection;
    @JoinColumn(name = "AMICALE", referencedColumnName = "AMICALEID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Amicale amicaleid;
    
    public Document() {
    }

    public Document(String documentName,String path ,Short typedocument) {
        this.path = path;
        this.documentName=documentName;
        this.typedocument = typedocument;
    }

    public Document(Integer documentid) {
        this.documentid = documentid;
    }

    public Integer getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Integer documentid) {
        this.documentid = documentid;
    }

    public Amicale getAmicaleid() {
        return amicaleid;
    }

    public void setAmicaleid(Amicale amicaleid) {
        this.amicaleid = amicaleid;
    }

    public Short getTypedocument() {
        return typedocument;
    }

    public void setTypedocument(Short typedocument) {
        this.typedocument = typedocument;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @XmlTransient
    public Collection<Contain> getContainCollection() {
        return containCollection;
    }

    public void setContainCollection(Collection<Contain> containCollection) {
        this.containCollection = containCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentid != null ? documentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentid == null && other.documentid != null) || (this.documentid != null && !this.documentid.equals(other.documentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vegatech.atfp.entities.Document[ documentid=" + documentid + " ]";
    }

}
