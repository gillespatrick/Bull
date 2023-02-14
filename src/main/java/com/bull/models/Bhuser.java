/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bull.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Bhuser")
@NamedQueries({
    @NamedQuery(name = "Bhuser.findAll", query = "SELECT b FROM Bhuser b"),
    @NamedQuery(name = "Bhuser.findByBhuserid", query = "SELECT b FROM Bhuser b WHERE b.bhuserid = :bhuserid"),
    @NamedQuery(name = "Bhuser.findByUsername", query = "SELECT b FROM Bhuser b WHERE b.username = :username"),
    @NamedQuery(name = "Bhuser.findByUserpassword", query = "SELECT b FROM Bhuser b WHERE b.userpassword = :userpassword"),
    @NamedQuery(name = "Bhuser.findByMotto", query = "SELECT b FROM Bhuser b WHERE b.motto = :motto"),
    @NamedQuery(name = "Bhuser.findByUseremail", query = "SELECT b FROM Bhuser b WHERE b.useremail = :useremail"),
    @NamedQuery(name = "Bhuser.findByJoindate", query = "SELECT b FROM Bhuser b WHERE b.joindate = :joindate")})
public class Bhuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bhuserid")
    private Integer bhuserid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 50)
    @Column(name = "userpassword")
    private String userpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "motto")
    private String motto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "useremail")
    private String useremail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "joindate")
    @Temporal(TemporalType.DATE)
    private Date joindate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bhuserid")
    private List<Bhpost> bhpostList;

    public Bhuser() {
    }

    public Bhuser(Integer bhuserid) {
        this.bhuserid = bhuserid;
    }

    public Bhuser(Integer bhuserid, String username, String motto, String useremail, Date joindate) {
        this.bhuserid = bhuserid;
        this.username = username;
        this.motto = motto;
        this.useremail = useremail;
        this.joindate = joindate;
    }

    public Integer getBhuserid() {
        return bhuserid;
    }

    public void setBhuserid(Integer bhuserid) {
        this.bhuserid = bhuserid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public List<Bhpost> getBhpostList() {
        return bhpostList;
    }

    public void setBhpostList(List<Bhpost> bhpostList) {
        this.bhpostList = bhpostList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bhuserid != null ? bhuserid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bhuser)) {
            return false;
        }
        Bhuser other = (Bhuser) object;
        if ((this.bhuserid == null && other.bhuserid != null) || (this.bhuserid != null && !this.bhuserid.equals(other.bhuserid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bull.models.Bhuser[ bhuserid=" + bhuserid + " ]";
    }
    
}
