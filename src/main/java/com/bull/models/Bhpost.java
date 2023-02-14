/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bull.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gilles
 */
@Entity
@Table(name = "Bhpost")
@NamedQueries({
    @NamedQuery(name = "Bhpost.findAll", query = "SELECT b FROM Bhpost b"),
    @NamedQuery(name = "Bhpost.findByPostid", query = "SELECT b FROM Bhpost b WHERE b.postid = :postid"),
    @NamedQuery(name = "Bhpost.findByPostdate", query = "SELECT b FROM Bhpost b WHERE b.postdate = :postdate"),
    @NamedQuery(name = "Bhpost.findByPosttext", query = "SELECT b FROM Bhpost b WHERE b.posttext = :posttext")})
public class Bhpost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postid")
    private Integer postid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postdate")
    @Temporal(TemporalType.DATE)
    private Date postdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "posttext")
    private String posttext;
    @JoinColumn(name = "bhuserid", referencedColumnName = "bhuserid")
    @ManyToOne(optional = false)
    private Bhuser bhuserid;

    public Bhpost() {
    }

    public Bhpost(Integer postid) {
        this.postid = postid;
    }

    public Bhpost(Integer postid, Date postdate, String posttext) {
        this.postid = postid;
        this.postdate = postdate;
        this.posttext = posttext;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public Bhuser getBhuserid() {
        return bhuserid;
    }

    public void setBhuserid(Bhuser bhuserid) {
        this.bhuserid = bhuserid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postid != null ? postid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bhpost)) {
            return false;
        }
        Bhpost other = (Bhpost) object;
        if ((this.postid == null && other.postid != null) || (this.postid != null && !this.postid.equals(other.postid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bull.models.Bhpost[ postid=" + postid + " ]";
    }
    
}
